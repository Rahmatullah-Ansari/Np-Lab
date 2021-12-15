import java.io.BufferedOutputStream; 
import java.io.FileOutputStream; 
import java.io.InputStream; 
import java.net.Socket; 
public class client {
public static void main(String[] argv) throws Exception { 
Socket sock = new Socket("127.0.0.1", 12345);
System.out.println("Connected to server"); 
byte[] mybytearray = new byte[1024]; 
InputStream is = sock.getInputStream(); 
FileOutputStream fos = new FileOutputStream("E:\\others\\VT 7th Sem\\Network Programming Lab\\Experiment-10\\Aim.txt"); 
BufferedOutputStream bos = new BufferedOutputStream(fos); 
int bytesRead; 
System.out.println("Receiving file "); 
while ((bytesRead = is.read(mybytearray)) != -1) 
{ 
bos.write(mybytearray, 0, bytesRead); 
} 
System.out.println("File Copied Successfully"); 
bos.close(); 
sock.close(); 
} } 