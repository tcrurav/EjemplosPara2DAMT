/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class Lanzador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Process proceso;
        for (int i = 0; i < 100; i++) {
            String programa = "java -jar EntradaSalida.jar";
            try {
                proceso = Runtime.getRuntime().exec(programa + " 1");
                proceso = Runtime.getRuntime().exec(programa + " -1");
            } catch (IOException ex) {
                Logger.getLogger(Lanzador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
