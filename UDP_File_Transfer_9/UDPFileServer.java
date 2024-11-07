package UDP_File_Transfer_9;

import java.io.*;
import java.net.*;

public class UDPFileServer {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        try {
            // Create a DatagramSocket to listen for packets on port 9876
            serverSocket = new DatagramSocket(9876);
            System.out.println("Server is listening on port 9876...");

            // Buffer to receive incoming packets
            byte[] receiveData = new byte[4096];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Prepare to save the received file
            FileOutputStream fileOut = new FileOutputStream("received_file.txt");

            while (true) {
                // Receive the file data from the client
                serverSocket.receive(receivePacket);
                byte[] data = receivePacket.getData();
                int length = receivePacket.getLength();

                // If length is zero, stop the server (end of file transfer)
                if (length == 0) {
                    break;
                }

                // Write received data into file
                fileOut.write(data, 0, length);
                System.out.println("Received packet of size: " + length);
            }

            // Close resources
            fileOut.close();
            System.out.println("File received and saved as 'received_file.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }
}

