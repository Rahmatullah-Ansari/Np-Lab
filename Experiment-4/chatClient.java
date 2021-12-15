import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class chatClient{
    public static void main(String[] args) {
        String name=JOptionPane.showInputDialog(null,"Enter your name :","Username",JOptionPane.PLAIN_MESSAGE);
        String serverName="localhost";
        try {
            new ChatClient(name,serverName);
        } catch (Exception e) {
            System.out.println("Error => "+e.getLocalizedMessage());
        }
    }
    public class ChatClient extends JFrame implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }

    }
}