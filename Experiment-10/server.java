import java.io.BufferedInputStream; 
import java.io.File; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.OutputStream; 
import java.net.ServerSocket; 
import java.net.Socket; 
public class server {
public static void main(String[] args) throws IOException 
{
try (ServerSocket servsock = new ServerSocket(12345)) {
    File myFile = new File("E:\\others\\VT 7th Sem\\Network Programming Lab\\Remain.txt"); 
    while (true) 
    { 
    System.out.println("Waiting for client"); 
    Socket sock = servsock.accept(); 
    byte[] mybytearray = new byte[(int) myFile.length()];
    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile))) {
        bis.read(mybytearray, 0, mybytearray.length);
    } 
    OutputStream os = sock.getOutputStream();
    System.out.println("Sending file data to client");
    os.write(mybytearray, 0, mybytearray.length);
    System.out.println("Sent file successfully to client"); 
    os.flush(); sock.close(); 
    }
} } } 