/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class ClientCommunication extends Thread {
    Socket socket;

    public ClientCommunication(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        serveClient(socket);
    }
    
    private static void serveClient(Socket socket) {
        BufferedReader br = null;
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            
            Scanner sc = new Scanner(System.in);
            
            String line;
            String lineToSendToClient;
            
            do {
                line = br.readLine();
                System.out.println("Client said: " + line); 
                
                System.out.println("Write to something to send to client: ");
                lineToSendToClient = sc.nextLine();
                
                bw.write(lineToSendToClient);
                bw.newLine();
                bw.flush();
            } while(line != "FIN");
    
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(br != null) try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
