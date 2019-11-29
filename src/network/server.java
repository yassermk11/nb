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
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author y186_
 */

public class server{
  public static void main(String[] args) throws IOException {
     String[] accounts = new String[20];
     int account_count=0;
     ServerSocket listener = new ServerSocket(9090);
  
     System.out.println("Waiting for client on port " + listener.getLocalPort() + "...");
                
     Socket socket = listener.accept();
     System.out.println("Just connected to " + socket.getRemoteSocketAddress());
               
     //To receive message from client
     DataInputStream dis=new DataInputStream(socket.getInputStream());  
     System.out.println("Message Recevied from Client: " + dis.readUTF());
           //System.out.println(dis.readUTF());
           boolean b3;
           while(dis.readUTF()!="EXIT".toLowerCase()){
           if (b3= Pattern.matches("(0)(1);[a-z]+;[a-z]+#", dis.readUTF())){
               System.out.println("20;OK#");
               accounts[account_count]=dis.readUTF(); 
               account_count++;
             }else if(b3= Pattern.matches("(0)(2);[a-z]+;[a-z]+#", dis.readUTF())){    
               System.out.println("20;OK#");
                   
             }else if(b3= Pattern.matches("(0)(3);[a-z]+;[a-z]+#", dis.readUTF())){
               System.out.println("20;OK#");
                   
             }
           }
     // To send message back to the client                   
     DataOutputStream out = new DataOutputStream(socket.getOutputStream());
     out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress() + "\nGoodbye!");
     socket.close();
  
  }                         
}
