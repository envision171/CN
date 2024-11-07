package TCP_Wired_7;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // Create server socket to listen on port 6789
            ServerSocket serverSocket = new ServerSocket(6789);
            System.out.println("Server is listening on port 6789...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Set up input and output streams for communication
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            // Send "Hello" message to the client
            outToClient.writeBytes("Hello from Server!\n");
            System.out.println("Sent to client: Hello from Server!");

            // Receive and print the "Hello" message from the client
            String clientMessage = inFromClient.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Close connection
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
