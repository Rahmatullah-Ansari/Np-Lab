import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.OutputStream; 
import java.io.OutputStreamWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
public class server 
{ 
private static Socket socket; 
public static void main(String[] args) 
{ 
try 
{ 
int port = 25000; 
try (ServerSocket serverSocket = new ServerSocket(port)) {
    System.out.println("Server Started and listening to the port 25000");
     //Server is running always. This is done using this while(true) loop
    while (true) 
    {
     //Reading the message from the client 
    socket = serverSocket.accept();
    InputStream is = socket.getInputStream(); 
    InputStreamReader isr = new InputStreamReader(is); 
    BufferedReader br = new BufferedReader(isr); 
    String command = br.readLine(); 
    System.out.println("Command received from client is " + command);
    String returnMessage; 
    server ss = new 
    server(); returnMessage =
    ss.executeCommand(command);
    System.out.println("Command output " + returnMessage); 
    //Sending the response back to the client. 
    OutputStream os = socket.getOutputStream(); 
    OutputStreamWriter osw = new OutputStreamWriter(os);
    BufferedWriter bw = new BufferedWriter(osw);
    bw.write(returnMessage); 
    bw.flush(); 
    }
} } 
catch (Exception e) 
{ 
e.printStackTrace(); 
} 
finally 
{ 
try 
{ 
socket.close(); 
} 
catch (Exception e) 
{ } } } 
private String executeCommand(String command) 
{ 
StringBuffer output = new StringBuffer(); 
try 
{ 
Process p = Runtime.getRuntime().exec(command); 
p.waitFor(); 
BufferedReader reader = new BufferedReader( new InputStreamReader(p.getInputStream()) ); 
String line; 
while ((line = reader.readLine()) != null) 
{ 
output.append(line).append("\n"); 
} } 
catch (IOException e1) 
{ } 
catch (InterruptedException e2) 
{ } 
return output.toString(); 
} } 