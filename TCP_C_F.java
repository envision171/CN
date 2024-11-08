import java.io.*;
import java.net.*;

public class TCP_C_F{


public static void main(String[] args){

try{


Socket clientSocket=new Socket("localhost",8080);

System.out.println("Connected to server!");

File file=new File("test.txt");
FileInputStream fileIn=new FileInputStream(file);
OutputStream outToServer=clientSocket.getOutputStream();


    byte[] buffer = new byte[4096];
            int bytesRead;

while ((bytesRead = fileIn.read(buffer)) != -1) {
                outToServer.write(buffer, 0, bytesRead);
            }

System.out.println("File sent to server.");

            // Close resources
            fileIn.close();
            clientSocket.close();
            System.out.println("Client closed.");

}catch(IOException e){
	e.printStackTrace();
}

}

}