/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerfichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class LeerFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("ocupacion.txt");
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file, "r");
            raf.seek(0);
            int ocupacion = raf.readInt();
            System.out.println("Hay " + ocupacion);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (raf != null) try {
                raf.close();
            } catch (IOException ex) {
                Logger.getLogger(LeerFichero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
