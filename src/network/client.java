/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author y186_
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 9090);
      
        // Send message to server.
        DataOutputStream dout=new DataOutputStream(socket.getOutputStream());  
        dout.writeUTF("Hello Server!");  // sends message to the socket
         System.out.println("Enter pass and user name in this format: 01;username;passwd# ");
         String aa=sc.next();
         dout.writeUTF(aa);
        // Receive message from server
     while(aa!="EXIT".toLowerCase()){
         System.out.println("Create an account format: 01;username;passwd# \n"
                 + "Log on format: 02;username;passwd# \n"
                 + "Upload Book Information format: 03;username, Bookname;# ");
         aa=sc.next();
     }
        DataInputStream in = new DataInputStream(socket.getInputStream());
        System.out.println("Server says " + in.readUTF());
        
        socket.close(); 
    }
    
}
