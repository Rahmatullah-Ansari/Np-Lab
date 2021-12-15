import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client{
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner s1=new Scanner(System.in);
        String msg=new String();
        Socket s=new Socket("localhost",6666);
        DataOutputStream dStream=new DataOutputStream(s.getOutputStream());
        do{
            msg=s1.nextLine();
            dStream.writeUTF(msg);
            dStream.flush();
        }while(!(msg.equals("bye")));
        s1.close();
        s.close();
    }
}