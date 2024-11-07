package TCP_Wired_7;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // Connect to the server on localhost and port 6789
            Socket clientSocket = new Socket("localhost", 6789);
            System.out.println("Connected to the server!");

            // Set up input and output streams for communication
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            // Receive "Hello" message from the server
            String serverMessage = inFromServer.readLine();
            System.out.println("Received from server: " + serverMessage);

            // Send "Hello" message to the server
            outToServer.writeBytes("Hello from Client!\n");
            System.out.println("Sent to server: Hello from Client!");

            // Close connection
            clientSocket.close();
            System.out.println("Client closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
