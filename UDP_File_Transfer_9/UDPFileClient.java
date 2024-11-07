package UDP_File_Transfer_9;

import java.io.*;
import java.net.*;

public class UDPFileClient {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        try {
            // Create a DatagramSocket to send data to the server
            clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            // Specify the file to be sent
            File file = new File("UDP_File_Transfer_9/test.txt");
            FileInputStream fileIn = new FileInputStream(file);

            // Buffer for reading file data
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileIn.read(buffer)) != -1) {
                // Create a packet and send it to the server
                DatagramPacket sendPacket = new DatagramPacket(buffer, bytesRead, serverAddress, serverPort);
                clientSocket.send(sendPacket);
                System.out.println("Sent packet of size: " + bytesRead);
            }

            // Send a final packet with length 0 to indicate the end of file transfer
            DatagramPacket endPacket = new DatagramPacket(new byte[0], 0, serverAddress, serverPort);
            clientSocket.send(endPacket);
            System.out.println("File transfer completed.");

            // Close resources
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null && !clientSocket.isClosed()) {
                clientSocket.close();
            }
        }
    }
}

