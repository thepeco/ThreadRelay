/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package staffetta_thread;

import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class Runner extends Thread {

    private int idCorridore;
    private Gestore gestoreBox;
    private JProgressBar progressBar;
    private JLabel labelTempo;

    private boolean running = true;
    private boolean inPausa = false;
    private int velocita = 50;

    public Runner(int idCorridore, Gestore gestoreBox, JProgressBar progressBar, JLabel labelTempo) {
        this.idCorridore = idCorridore;
        this.gestoreBox = gestoreBox;
        this.progressBar = progressBar;
        this.labelTempo = labelTempo;
    }

    public void fermaGara() {
        running = false;
    }

    public void setPausa(boolean pausa) {
        inPausa = pausa;
    }

    public void setVelocita(int v) {
        velocita = v;
    }

    @Override
    public void run() {
        try {
            while (running) {
                gestoreBox.attendiTurno(idCorridore);
                boolean testimonePassato = false;

                for (int i = 0; i <= 100 && running; i++) {
                    while (inPausa) {
                        Thread.sleep(100);
                    }
                    gestoreBox.notificaProgresso(idCorridore, i);

                    progressBar.setValue(i);
                    labelTempo.setText(i + "%");

                    if (i == 90 && !testimonePassato) {
                        int prossimo = (idCorridore % 3) + 1;
                        gestoreBox.cambiaRunner(prossimo);
                        testimonePassato = true;
                    }

                    Thread.sleep(velocita);
                }

                if (running) {
                    labelTempo.setText("Fine");
                } else {
                    labelTempo.setText("Stop");
                }

                break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
