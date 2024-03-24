package com.mytools.utils;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Timbre {

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

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public int getSegundoInicio() {
        return segundoInicio;
    }

    public void setSegundoInicio(int segundoInicio) {
        this.segundoInicio = segundoInicio;
    }

    private Timer timer;
    private long INTERVALO;

    private int horaRestante;
    private int minutoRestante;
    private int segundoRestante;

    private int horaInicio;
    private int minutoInicio;
    private int segundoInicio;

    public Timbre() {
        timer = new Timer();
    }

    public void inicir(int hora, int minuto, int segundo) {
        setHoraInicio(hora);
        setMinutoInicio(minuto);
        setSegundoInicio(segundo);

        INTERVALO = (long) ((getHoraInicio() * 60 * 60) + (getMinutoInicio() * 60) + getSegundoInicio()) * 1000;

        timer.schedule(new MiTarea(), 0, 1000); // Actualizar cada segundo
    }

    public void inicir() {

        INTERVALO = (long) ((getHoraInicio() * 60 * 60) + (getMinutoInicio() * 60) + getSegundoInicio()) * 1000;

        timer.schedule(new MiTarea(), 0, 1000); // Actualizar cada segundo
    }

    public void detener() {
        timer.cancel();
        timer = new Timer();
    }

    class MiTarea extends TimerTask {

        long tiempoRestante = INTERVALO;

        @Override
        public void run() {
            tiempoRestante -= 1000;

            // Calcular horas, minutos y segundos
            int horas = (int) (tiempoRestante / 3600000);
            int minutos = (int) ((tiempoRestante % 3600000) / 60000);
            int segundos = (int) ((tiempoRestante % 60000) / 1000);

            setHoraRestante(horas);
            setMinutoRestante(minutos);
            setSegundoRestante(segundos);

            Toolkit.getDefaultToolkit().beep();

            if (tiempoRestante <= 0) {
                System.out.println("Timer Detenido");
                detener();
            }
        }
    }
}
