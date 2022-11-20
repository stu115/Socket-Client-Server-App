package ds.socket.client;


import ds.socket.server.MySocketServerApp;
import ds.socket.server.model.Supermarket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySocketClientApp {

    public static final int PORTNO = MySocketServerApp.PORTNO;
    
    public static final String HOST = "localhost";


    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORTNO);
            
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());  
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());  
            
            Supermarket smt = new Supermarket("Check if the number of brown jackets in shop are enough. Otherwise arrange for delivery by Monday");
            out.writeObject(smt);
            
            Supermarket givenBackSmt = (Supermarket) in.readObject();
           
            System.out.println("CLIENT: Got the message = "+givenBackSmt.getProductID());
            
           
            
            
            
        
        } catch (IOException x) {
            x.printStackTrace();
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
            
        }
        
        
        
    }
    
}
