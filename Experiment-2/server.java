import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        try {
            try (ServerSocket ss = new ServerSocket(6666)) {
                while(true){
                    Socket s=ss.accept();
                    Myclass obj=new Myclass(s);
                    obj.start();
                }
            }
        } catch (Exception e) {
            System.out.println("Error :"+e.getLocalizedMessage());
        }
    }
    public static class Myclass extends Thread{
        Socket socket;
        public Myclass(Socket s) {
            socket=s;
        }
        public void run(){
            try {
                DataInputStream dInputStream=new DataInputStream(socket.getInputStream());
                String str;
                do{
                    str=(String)dInputStream.readUTF();
                    System.out.println("Message = "+str);
                }while(!str.equals("bye"));
                socket.close();
            } catch (Exception e) {
                System.out.println("Thread error :"+e.getLocalizedMessage());
            }
        }

    }
}
