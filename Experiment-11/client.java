import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.io.OutputStreamWriter; 
import java.net.InetAddress; 
import java.net.Socket; 
public class client 
{ 
private static Socket socket; 
public static void main(String args[]) 
{ 
try 
{ 
String host = "localhost"; 
int port = 25000; 
InetAddress address = InetAddress.getByName(host); 
socket = new Socket(address, port); 
//Send the message to the server 
OutputStream os = socket.getOutputStream(); 
OutputStreamWriter osw = new OutputStreamWriter(os);
BufferedWriter bw = new BufferedWriter(osw); 
String cmd = "cmd /c ver"; 
String sendMessage = cmd + "\n"; 
bw.write(sendMessage); 
bw.flush(); 
System.out.println("Command sent to the server : " + sendMessage);
 //Get the return message from the server 
InputStream is = socket.getInputStream(); 
InputStreamReader isr = new InputStreamReader(is); 
BufferedReader br = new BufferedReader(isr); 
String line; 
//line = br.readLine(); 
while ((line = br.readLine()) != null) 
{
 System.out.println(line); 
} 
System.out.println("Command output received from the server :\n " + line); 
} 
catch (Exception exception) 
{ 
exception.printStackTrace(); 
} 
finally 
{
 //Closing the socket 
try 
{ 
socket.close(); 
} 
catch (Exception e) 
{ 
e.printStackTrace(); 
} } } }