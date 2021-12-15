import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Scanner sc =new Scanner(System.in);
        int port=13;
        InetAddress host=InetAddress.getByName("localhost");
        DatagramSocket socket=new DatagramSocket();
        socket.setSoTimeout(5000);
        DatagramPacket packet=new DatagramPacket(new byte[256],1,host,port);
        byte[] outBuffer=sc.nextLine().getBytes();
        packet.setData(outBuffer);
        packet.setLength(outBuffer.length);
        socket.send(packet);
        socket.receive(packet);
        //socket.close();
        sc.close();
    }
}
