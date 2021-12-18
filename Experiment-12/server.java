import java.io.*; 
import java.net.*; 
public class server 
{ 
public static void main(String[] args)
{ 
try
{ 
ServerSocket ss=new ServerSocket(6432); 
Socket s=ss.accept();
//establishes connection
    DataInputStream dis=new DataInputStream(s.getInputStream()); 
    String str=(String)dis.readUTF();
    if(str != "0"){
        Integer n=Integer.parseInt(str); 
        String hex1=Integer.toHexString(n); 
        System.out.println("hexadecimal value of user input = "+ hex1);
        PrintStream pStream=new PrintStream(s.getOutputStream());
        pStream.println(hex1);
    }else{
    s.close();
    ss.close();
    }
} 
catch(Exception e){
    System.out.println(e);
} 
} 
} 