/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class EntradaSalida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numDeEntradasSalidas = Integer.parseInt(args[0]);
        
        File file = new File("ocupacion.txt");
        if(!file.exists()) try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
        }
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");
            FileLock bloqueo = raf.getChannel().lock();
            raf.seek(0);
            int ocupacion;
            try{
                ocupacion = raf.readInt();
            } catch(Exception e){
                ocupacion = 0;
            }
            ocupacion += numDeEntradasSalidas;
            raf.seek(0);
            raf.writeInt(ocupacion);
            
            bloqueo.release();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (raf != null) try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
