/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author pecorelli.davide
 */
public class Runner extends Thread {

    private int idCorridore;
    private Gestore GestoreBox;
    private Random rnd = new Random();

    public Runner(int idCorridore, Gestore GestoreBox) {

        this.idCorridore = idCorridore;
        this.GestoreBox = GestoreBox;
    }

    @Override
    public void run() {

        try {
            while (true) {
                GestoreBox.attendiTurno(idCorridore);
            }

            //int tempoCorsa = rnd.nextInt(2000, 3000);
            //Thread.sleep(tempoCorsa);

            int prossimo;

            if (idCorridore == 1) {

                prossimo = 2;
            } else {
                prossimo = 1;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


