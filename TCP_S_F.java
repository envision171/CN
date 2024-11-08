import java.io.*;
import java.net.*;

public class TCP_S_F{

public static void main(String[] args){

try{

ServerSocket serverSocket=new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

Socket clientSocket=serverSocket.accept();
System.out.println("Client Connected");


InputStream inFromClient=clientSocket.getInputStream();
FileOutputStream fileOut=new FileOutputStream("./r.txt");


byte[] buffer=new byte[4096];

int byteRead;


while((byteRead=inFromClient.read(buffer))!=-1){
fileOut.write(buffer,0,byteRead);}

System.out.println("File received and saved as 'r.txt'");

            // Close resources
            fileOut.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server closed.");

}catch(IOException e){
e.printStackTrace();
}





}
}