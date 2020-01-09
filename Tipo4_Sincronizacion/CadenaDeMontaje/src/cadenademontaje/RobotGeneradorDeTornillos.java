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
public class RobotGeneradorDeTornillos extends Thread{
    BandejaDeTornillos bandejaDeTornillos;
    int idRobot;
    public RobotGeneradorDeTornillos(BandejaDeTornillos bandejaDeTornillos, int idRobot){
        this.bandejaDeTornillos = bandejaDeTornillos;
        this.idRobot =idRobot;
    }
    
    @Override
    public void run() {
        bandejaDeTornillos.dejarEsparandoAHilo();
        for(int i = 0; i < 100; i++){
            bandejaDeTornillos.generarTornillo(idRobot);
            yield();
        }
    }
    
}
