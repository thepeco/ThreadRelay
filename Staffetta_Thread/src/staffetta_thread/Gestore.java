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
    
    public Gestore(int corridoreTestimone){
        
        this.corridoreTestimone = corridoreTestimone;
    }
    
    public synchronized void cambiaRunner(int IdCorridore) throws InterruptedException{
        
       while(corridoreTestimone != IdCorridore){
           
           wait();
       } 
   }
    
    public synchronized void attendiTurno(int prossimoRunner){
        
        this.corridoreTestimone = prossimoRunner;
        notifyAll();
    }
    
}
