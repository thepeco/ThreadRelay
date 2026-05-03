/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
/**
 *
 * @author pecorelli.davide
 */
public class Gestore extends Thread {

    private int corridoreTestimone;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

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
