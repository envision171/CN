package Socket_Programmin_6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);
            System.out.println("UDP Server is listening on port 9876...");

            // Buffer to receive incoming data
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            // Receive a packet from client
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Convert received data to string
            String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received from client: " + clientMessage);

            // Prepare response message
            String responseMessage = "Hello from UDP Server!";
            sendData = responseMessage.getBytes();

            // Get client address and port from received packet
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            // Send response to client
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            System.out.println("Response sent to client.");

            // Close the server socket
            serverSocket.close();
            System.out.println("UDP Server closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Explanation of the UDP Server Code
//DatagramSocket:
//
//A DatagramSocket is created on port 9876 to listen for incoming datagrams (packets) from clients.
//The server listens for incoming UDP packets without establishing a dedicated connection.
//Receiving Data:
//
//A DatagramPacket called receivePacket is created with a buffer receiveData to store incoming data from the client.
//        serverSocket.receive(receivePacket) waits until a packet is received from the client.
//        receivePacket.getData() retrieves the data as bytes, which is then converted to a String for easy reading.
//Preparing the Response:
//
//The server prepares a response message, "Hello from UDP Server!" and converts it into bytes using responseMessage.getBytes().
//Sending the Response:
//
//The server gets the client’s IP address and port from receivePacket to know where to send the response.
//It then creates a DatagramPacket named sendPacket with the response data, client address, and client port, and sends it using serverSocket.send(sendPacket).
//Closing the Socket:
//
//The server socket is closed after sending the response, which terminates the server.