package ds.socket.server;

import ds.socket.server.model.Supermarket;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServerApp {
    
    public static final int PORTNO = 60;

    public static void main(String[] args) {
        MySocketServerApp server = new MySocketServerApp();
        server.doTask();
    }
    
    
    public void doTask(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORTNO);
            System.out.println("SERVER is doing the task...");
             
            Socket socket = serverSocket.accept();
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    
            Supermarket note = (Supermarket) in.readObject();
            getReminderReady(note);
            out.writeObject(note);
            socket.close();
            
           
            
            
        } catch (IOException x) {
           System.out.println(x.getMessage());
           x.printStackTrace();
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
        
        
    }
    
    private void getReminderReady (Supermarket note){
        // TODO, example: capitalise the contents of the message
        System.out.println("SERVER: Got the message to process = "+note.getProductID());
        note.setProductID(note.getProductID().toUpperCase());
    }
 
   
     
    
   
    
    
}
