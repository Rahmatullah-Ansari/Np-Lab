import java.io.*;
import java.net.*;
import java.util.Date;

public class server{
    public static final int DEFAULT_PORT=13;
    public static void main(String[] args) throws IOException {
        try (DatagramSocket ds = new DatagramSocket(DEFAULT_PORT)) {
            DatagramPacket dp=new DatagramPacket(new byte[1],1);
            while(true){
                ds.receive(dp);
                System.out.println("Received from :"+dp.getAddress()+":"+dp.getPort());
                byte[] outBuffer=new Date().toString().getBytes();
                dp.setData(outBuffer);
                dp.setLength(outBuffer.length);
                ds.send(dp);
            }
        }
    }
}