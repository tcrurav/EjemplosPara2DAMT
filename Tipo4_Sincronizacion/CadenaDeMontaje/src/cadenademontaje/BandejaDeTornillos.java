/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenademontaje;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class BandejaDeTornillos {
    int numTornillos = 0;
    int numTornillosGeneradosTotales = 0;
    int numTornillosConsumidosTotales = 0;
    final int MAX_TORNILLOS_EN_BANDEJA = 5;
    
    public synchronized void dejarEsparandoAHilo(){
        try {
            wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(BandejaDeTornillos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized void despartarATodos(){
        notifyAll();
    }
    
    public synchronized void generarTornillo(int idRobot){
        while(numTornillos == MAX_TORNILLOS_EN_BANDEJA){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BandejaDeTornillos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numTornillos++;
        numTornillosGeneradosTotales++;
        System.out.println("El Robot generador nº " + idRobot + " ha generado el tornillo " + numTornillosGeneradosTotales + ".");
        System.out.println("Ahora hay en la bandeja hay " + numTornillos + " tornillos.");
        notifyAll();
    }
    
    public synchronized void consumirTornillo(){
        while(numTornillos == 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(BandejaDeTornillos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        numTornillos--;
        numTornillosConsumidosTotales++;
        System.out.println("El Robot Consumidor ha consumido el tornillo " + numTornillosConsumidosTotales + ".");
        System.out.println("Ahora hay en la bandeja hay " + numTornillos + " tornillos.");
        notifyAll();
    }
}
