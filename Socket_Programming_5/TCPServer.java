package Socket_Programming_5;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            // Start server and listen on port 6789
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening on port 8000...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Setup input and output streams
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

            // Read message from client
            String clientMessage = inFromClient.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Send response back to client
            String responseMessage = "Hello from Server!";
            outToClient.writeBytes(responseMessage + "\n");

            // Close connections
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//Explanation of Code

//TCP Server Explanation
//The server program creates a socket that listens for incoming connections on a specified port. Once a client connects, the server can receive data from and send responses to the client.
//
//Code Explanation for TCPServer
//        java
//Copy code
//import java.io.*;
//        import java.net.*;
//
//public class TCPServer {
//    public static void main(String[] args) {
//        try {
//            // Start server and listen on port 6789
//            ServerSocket serverSocket = new ServerSocket(6789);
//            System.out.println("Server is listening on port 6789...");
//            ServerSocket: The ServerSocket object listens for incoming connections on port 6789. Ports are like channels that allow communication with different applications.
//            Port Number: Port 6789 is chosen here, but any available port could be used as long as it’s consistent between the client and server.
//                    java
//            Copy code
//            // Accept client connection
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("Client connected!");
//            Accepting Connection: serverSocket.accept() waits until a client connects. Once connected, it returns a Socket object, clientSocket, representing the connection with the client.
//                    Connection Confirmation: The program prints "Client connected!" once a client successfully connects.
//                    java
//            Copy code
//            // Setup input and output streams
//            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
//            Input and Output Streams:
//            BufferedReader inFromClient reads data sent by the client.
//            DataOutputStream outToClient is used to send data back to the client.
//                    java
//            Copy code
//            // Read message from client
//            String clientMessage = inFromClient.readLine();
//            System.out.println("Received from client: " + clientMessage);
//            Receiving Data: The server reads the client's message using inFromClient.readLine(), which reads a line of text. The message is then displayed on the server’s console.
//            java
//            Copy code
//            // Send response back to client
//            String responseMessage = "Hello from Server!";
//            outToClient.writeBytes(responseMessage + "\n");
//            Sending Data: The server sends a response, "Hello from Server!", to the client using outToClient.writeBytes(). The \n ensures the client reads the message correctly.
//            java
//            Copy code
//            // Close connections
//            clientSocket.close();
//            serverSocket.close();
//            System.out.println("Server closed.");
//            Closing Connections: Both clientSocket and serverSocket are closed after the communication ends, which releases the resources and ends the server.
//
