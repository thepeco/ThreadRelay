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

            gestoreBox.attendiTurno(idCorridore);

            boolean testimonePassato = false;

            for (int i = 0; i <= 100; i++) {
                int progresso = i;

                progressBar.setValue(progresso);
                labelTempo.setText(progresso + "%");

                if (progresso == 90 && !testimonePassato) {
                    int prossimo = (idCorridore % 3) + 1;
                    gestoreBox.cambiaRunner(prossimo);
                    testimonePassato = true;
                }

                Thread.sleep(50);
            }

            labelTempo.setText("Fine");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
