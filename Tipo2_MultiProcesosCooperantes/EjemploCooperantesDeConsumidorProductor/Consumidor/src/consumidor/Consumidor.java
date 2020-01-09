/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumidor;

import java.util.Scanner;

/**
 *
 * @author tibur
 */
public class Consumidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            System.out.println("He leído: " + sc.nextLine());
        }
    }
    
}
