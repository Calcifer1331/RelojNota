package com.mytools.utils;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Alarma {

    public int getHoraRestante() {
        return horaRestante;
    }

    public void setHoraRestante(int horaRestante) {
        this.horaRestante = horaRestante;
    }

    public int getMinutoRestante() {
        return minutoRestante;
    }

    public void setMinutoRestante(int minutoRestante) {
        this.minutoRestante = minutoRestante;
    }

    public int getSegundoRestante() {
        return segundoRestante;
    }

    public void setSegundoRestante(int segundoRestante) {
        this.segundoRestante = segundoRestante;
    }

    private Timer timer;
    private long INTERVALO;

    private int horaRestante;
    private int minutoRestante;
    private int segundoRestante;

    public Alarma() {
        timer = new Timer();
    }

    public void inicirAlarma(int hora, int minuto, int segundo) {
        int horaSegundo = hora * 60 * 60;
        int minutoSegundo = minuto * 60;
        INTERVALO = (long) (horaSegundo + minutoSegundo + segundo) * 1000;

        timer.schedule(new MiTarea(), 0, 1000); // Actualizar cada segundo
    }

    @Override
    public String toString() {
        return horaRestante + ":" + minutoRestante + ":" + segundoRestante;
    }
    
    

    class MiTarea extends TimerTask {

        long tiempoRestante = INTERVALO;

        @Override
        public void run() {
            tiempoRestante -= 1000;

            int a = (int) ((tiempoRestante / 60) / 60) / 1000;
            int b = (int) ((tiempoRestante / 60) / 1000) - (a * 60);
            int c = (int) (tiempoRestante / 1000) - (a * 60 * 60) - (b * 60);

            setHoraRestante(a);
            setMinutoRestante(b);
            setSegundoRestante(c);


            if (tiempoRestante <= 0) {
                System.out.println("¡¡¡ALARMA!!!");
                Toolkit.getDefaultToolkit().beep();

                //alarmaSe(1);
                tiempoRestante = INTERVALO; // Reiniciar el tiempo restante
            }
        }

    }
}
