/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;

/**
 *
 * @author pecorelli.davide
 */
public class Gestore extends Thread {

    private int corridoreTestimone;

    public Gestore(int partenza) {
        this.corridoreTestimone = partenza;
    }

    public synchronized void attendiTurno(int id) throws InterruptedException {
        while (corridoreTestimone != id) {
            wait();
        }
    }

    public synchronized void cambiaRunner(int prossimoID) {
        this.corridoreTestimone = prossimoID;
        notifyAll();
    }
}
