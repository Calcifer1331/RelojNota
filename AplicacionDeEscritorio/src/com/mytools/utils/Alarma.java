package com.mytools.utils;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Alarma {

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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
    private String img;

    private int horaRestante;
    private int minutoRestante;
    private int segundoRestante;

    private int horaInicio;
    private int minutoInicio;
    private int segundoInicio;
    String[] imagenes = {
        "resource/IconoReloj/relojAlarma-ariba.svg",
        "resource/IconoReloj/relojAlarma-derecha.svg",
        "resource/IconoReloj/relojAlarma-abajo.svg",
        "resource/IconoReloj/relojAlarma-izquierda.svg"
    };

    public Alarma() {
        timer = new Timer();
        setImg("resource/IconoReloj/reloj.svg");
    }

    public void inicir(int hora, int minuto, int segundo) {
        setHoraInicio(hora);
        setMinutoInicio(minuto);
        setSegundoInicio(segundo);

        INTERVALO = (long) ((hora * 60 * 60) + (minuto * 60) + segundo) * 1000;

        timer.schedule(new MiTarea(), 0, 1000); // Actualizar cada segundo
    }

    @Override
    public String toString() {
        return horaRestante + ":" + minutoRestante + ":" + segundoRestante;
    }

    class MiTarea extends TimerTask {

        long tiempoRestante = INTERVALO;
        int ciclosCompletados = 0;

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

            if (tiempoRestante <= 0) {
                System.out.println("¡¡¡ALARMA!!!");
                Toolkit.getDefaultToolkit().beep();
                ciclosCompletados++;
                setImg(imagenes[ciclosCompletados % imagenes.length]);
                //alarmaSe(1);
                tiempoRestante = INTERVALO; // Reiniciar el tiempo restante
            }
        }

    }
}
