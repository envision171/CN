package TCP_File_Transfer_8;

import java.io.*;
import java.net.*;

public class TCPFileServer {
    public static void main(String[] args) {
        try {
            // Set up server socket to listen on port 6789
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Server is listening on port 6789...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Set up input stream to receive file from client
            InputStream inFromClient = clientSocket.getInputStream();
            FileOutputStream fileOut = new FileOutputStream("received_file.txt");

            // Buffer for reading data
            byte[] buffer = new byte[4096];
            int bytesRead;

            // Read from the client and write to the file
            while ((bytesRead = inFromClient.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
            }

            System.out.println("File received and saved as 'received_file.txt'");

            // Close resources
            fileOut.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
