/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorweb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class ServidorWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            final int PORT = 40080;

            ServerSocket sk = new ServerSocket(PORT);

            while (true) {
                Socket socket = sk.accept();

                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                //while(linea.equals())
                String ruta = "";
                String peticion = br.readLine();

                if (peticion.startsWith("GET")) {
                    StringTokenizer stringinizador = new StringTokenizer(peticion);
                    stringinizador.nextToken();
                    ruta = stringinizador.nextToken();
                }
                
                String paginaHola;
                switch(ruta){
                    case "/":
                        paginaHola = "<html><head><title>algo</title></head><body><p>Hola</p></body></html>";
                        break;
                    case "/otra":
                        paginaHola = "<html><head><title>otra</title></head><body><p>otra</p></body></html>";
                        break;
                    default:
                        paginaHola = "<html><head><title>defecto</title><meta http-equiv=\"refresh\" content=\"5; url=http://www.ieselrincon.org\" /></head><body><p>redirigiendo...</p></body></html>";
                        break; 
                }

                System.out.println("Cliente dice: " + br.readLine());

                
                bw.write("HTTP/1.1 200 OK");
                bw.newLine();
//                bw.newLine();
//                bw.write("\n");
                bw.write("Content-Type:text/html;charset=UTF-8");
                bw.newLine();
//                bw.newLine();
//                bw.write("\n");
                bw.write("Content-Length: " + paginaHola.length());
//                bw.newLine();
//                bw.write("Date: " + new Date());
                bw.newLine();
                bw.newLine();
                bw.flush();
//                bw.write("\n");
                bw.write(paginaHola);
                bw.newLine();
                bw.flush();

                System.out.println("Ya envié la ");

            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
