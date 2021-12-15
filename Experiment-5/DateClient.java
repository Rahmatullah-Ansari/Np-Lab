import java.io.*;
import java.net.*;

public class DateClient
{
    public static void main(String args[]) throws Exception
    {
        Socket soc=new Socket(InetAddress.getLocalHost(),5217);
        InputStream iStream=soc.getInputStream();
        InputStreamReader iReader=new InputStreamReader(iStream);
        BufferedReader in=new BufferedReader(iReader);
        System.out.println(in.readLine());
    }    
}