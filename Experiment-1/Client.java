import java.net.*;
import java.io.*;
public class Client{
    public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket=new Socket("localhost",4999);
    PrintWriter pWriter=new PrintWriter(socket.getOutputStream());
    pWriter.println("It is working...");
    pWriter.flush();
    InputStreamReader iReader=new InputStreamReader(socket.getInputStream());
    BufferedReader bReader=new BufferedReader(iReader);
    String s=bReader.readLine();
    System.out.println("Server : "+s);
    socket.close();
    }
}
