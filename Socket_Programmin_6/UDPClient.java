package Socket_Programmin_6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to send data
            DatagramSocket clientSocket = new DatagramSocket();

            // Define the server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            // Prepare the message to send
            String message = "Hello from UDP Client!";
            byte[] sendData = message.getBytes();

            // Create and send the datagram packet to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
            System.out.println("Message sent to server.");

            // Buffer to receive response from server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive response from server
            clientSocket.receive(receivePacket);
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from server: " + serverResponse);

            // Close the client socket
            clientSocket.close();
            System.out.println("UDP Client closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



//xplanation of the UDP Client Code
//DatagramSocket:
//
//A DatagramSocket is created for the client, which allows it to send and receive packets over UDP.
//Server Address and Port:
//
//The server’s IP address is set to "localhost" (indicating the same machine) and port 9876, which must match the port the UDP server is listening on.
//Sending Data:
//
//The client prepares a message ("Hello from UDP Client!") and converts it to bytes using getBytes().
//A DatagramPacket is created with this message, server address, and port, and sent using clientSocket.send().
//Receiving Data:
//
//A buffer receiveData is created to store the incoming response from the server.
//The client waits for the server’s response using clientSocket.receive(receivePacket).
//The data received in receivePacket is converted to a String and displayed.
//Closing the Socket:
//
//After receiving the server’s response, the client closes the socket, ending the communication.

