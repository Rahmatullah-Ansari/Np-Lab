import java.io.*; 
import java.net.*; 
import java.util.*; 
public class client 
{ 
public static void main(String[] args)
{
    Scanner w;
    Socket s;
try
{ 
w = new Scanner(System.in); 
s = new Socket("localhost",6432); 
DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
String number; 
    number=w.nextLine();
    if (number != "0"){
        dout.writeUTF(number);
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String msg=br.readLine();
        System.out.println("Hexadecimal of "+number+" = "+msg);
    }else{
        dout.flush(); 
        dout.close();
        w.close();
        s.close();
    }
}
catch(Exception e)
{
System.out.println(e);
}
} }