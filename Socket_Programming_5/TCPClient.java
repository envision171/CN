package Socket_Programming_5;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try {
            // Connect to server on localhost at port 6789
            Socket socket = new Socket("localhost", 8000);
            System.out.println("Connected to the server!");

            // Setup input and output streams
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send message to server
            String message = "Hello from Client!";
            outToServer.writeBytes(message + "\n");

            // Receive response from server
            String serverResponse = inFromServer.readLine();
            System.out.println("Received from server: " + serverResponse);

            // Close the connection
            socket.close();
            System.out.println("Client closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//TCP Client Explanation
//The client program connects to the server using the server’s IP address (in this case, localhost) and port. It then sends a message to the server and waits for a response.
//
//Code Explanation for TCPClient
//        java
//Copy code
//import java.io.*;
//        import java.net.*;
//
//public class TCPClient {
//    public static void main(String[] args) {
//        try {
//            // Connect to server on localhost at port 6789
//            Socket socket = new Socket("localhost", 6789);
//            System.out.println("Connected to the server!");
//            Socket: The Socket object, socket, establishes a connection to the server running on localhost (the same machine) at port 6789. The client and server must use the same port to communicate.
//                    Connection Confirmation: A confirmation message, "Connected to the server!", is displayed when the connection is successful.
//            java
//            Copy code
//            // Setup input and output streams
//            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
//            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            Input and Output Streams:
//            DataOutputStream outToServer is used to send data to the server.
//            BufferedReader inFromServer reads responses from the server.
//                    java
//            Copy code
//            // Send message to server
//            String message = "Hello from Client!";
//            outToServer.writeBytes(message + "\n");
//            Sending Data: The client sends the message "Hello from Client!" to the server using outToServer.writeBytes(). The \n ensures that the server reads the message properly.
//                    java
//            Copy code
//            // Receive response from server
//            String serverResponse = inFromServer.readLine();
//            System.out.println("Received from server: " + serverResponse);
//            Receiving Data: The client waits for a response from the server. inFromServer.readLine() reads the server's response, which is then displayed on the client’s console.
//            java
//            Copy code
//            // Close the connection
//            socket.close();
//            System.out.println("Client closed.");
//            Closing Connection: The socket is closed after the communication is complete, releasing the resources and ending the connection.
//
