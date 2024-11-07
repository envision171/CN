package TCP_File_Transfer_8;

import java.io.*;
import java.net.*;

public class TCPFileClient {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost at port 6789
            Socket clientSocket = new Socket("localhost", 6789);
            System.out.println("Connected to server!");

            // Specify the file to be sent
            File file = new File("TCP_File_Transfer_8/file_to_send.txt");
            FileInputStream fileIn = new FileInputStream(file);
            OutputStream outToServer = clientSocket.getOutputStream();

            // Buffer for reading file data
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read from the file and send to the server
            while ((bytesRead = fileIn.read(buffer)) != -1) {
                outToServer.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent to server.");

            // Close resources
            fileIn.close();
            clientSocket.close();
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
