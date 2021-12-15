import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(4999);
        Socket s=ss.accept();
        System.out.println("Client Connected..");
        InputStreamReader iReader=new InputStreamReader(s.getInputStream());
        BufferedReader bReader=new BufferedReader(iReader);
        String str=bReader.readLine();
        System.out.println("Client : "+str);
        PrintWriter pWriter=new PrintWriter(s.getOutputStream());
        pWriter.println("Yes");
        pWriter.flush();
        ss.close();

    }
}
