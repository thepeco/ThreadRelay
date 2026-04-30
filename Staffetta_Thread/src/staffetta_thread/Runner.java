/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;

import java.util.Random;

public class Runner extends Thread {

    private int idCorridore;
    private Gestore GestoreBox;
    private Random rnd = new Random();
    private int prossimo;

    public Runner(int idCorridore, Gestore GestoreBox) {
        this.idCorridore = idCorridore;
        this.GestoreBox = GestoreBox;
    }

    @Override
    public void run() {
        try {
            while (true) {
                GestoreBox.attendiTurno(idCorridore);

                int tempoCorsa = 5000;
                Thread.sleep(tempoCorsa);

                System.out.println("Corridore " + idCorridore + " ha terminato la sua frazione.");

                if (idCorridore == 1) {
                    prossimo = 2;
                } else {
                    prossimo = 1;
                }

                GestoreBox.cambiaRunner(prossimo);
            }
        } catch (InterruptedException e) {
            System.out.println("Il corridore " + idCorridore + " è stato interrotto!");
            
        }
    }
}
