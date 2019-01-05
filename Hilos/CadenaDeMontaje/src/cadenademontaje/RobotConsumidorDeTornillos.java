/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadenademontaje;

/**
 *
 * @author tibur
 */
public class RobotConsumidorDeTornillos extends Thread{
    BandejaDeTornillos bandejaDeTornillos;
    public RobotConsumidorDeTornillos(BandejaDeTornillos bandejaDeTornillos){
        this.bandejaDeTornillos = bandejaDeTornillos;
    }

    @Override
    public void run() {
        bandejaDeTornillos.dejarEsparandoAHilo();
        for (int i = 0; i < 1000; i++) {
            bandejaDeTornillos.consumirTornillo();
            yield();
        }
    }
    
    
}
