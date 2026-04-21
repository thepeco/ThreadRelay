/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;

/**
 *
 * @author pecorelli.davide
 */
public class Runner extends Thread {
    
    private int tempo;
    private String nome;
    
    public Runner (int tempo,String nome){
        
        this.tempo=tempo;
        this.nome=nome;
    }
    
    
}
