/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Runner extends Thread {

    private int idCorridore;
    private Gestore gestoreBox;
    private JProgressBar progressBar;
    private JLabel labelTempo;

    public Runner(int idCorridore, Gestore gestoreBox, JProgressBar progressBar, JLabel labelTempo) {
        this.idCorridore = idCorridore;
        this.gestoreBox = gestoreBox;
        this.progressBar = progressBar;
        this.labelTempo = labelTempo;
    }

    @Override
    public void run() {
        try {
            while (true) {
                
                gestoreBox.attendiTurno(idCorridore);

                
                for (int i = 0; i <= 100; i++) {
                    int progresso = i;

                    
                    progressBar.setValue(progresso);
                    labelTempo.setText(progresso + "%");

                    
                    if (progresso == 90) {
                        int prossimo;
                        if (idCorridore == 1) {
                            prossimo = 2;
                        } else if (idCorridore == 2) {
                            prossimo = 3;
                        } else {
                            prossimo = 1;
                        }

                        gestoreBox.cambiaRunner(prossimo);
                    }

                    
                    Thread.sleep(50);
                }

                labelTempo.setText("Fine");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto");
        }
    }
}
