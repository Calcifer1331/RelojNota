package com.mytools.utils;

import com.mytools.ilib.Dashboard;
import com.mytools.utils.Timbre;
import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Alarma {

    public Timbre getTimbre() {
        return timbre;
    }

    public void setTimbre(Timbre timbre) {
        this.timbre = timbre;
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
    private Timbre timbre;
    private long INTERVALO;

    private int horaRestante;
    private int minutoRestante;
    private int segundoRestante;

    private int horaInicio;
    private int minutoInicio;
    private int segundoInicio;

    int ciclosCompletados;

    private Dashboard dashboard;

    public interface AlarmaListener {

        void cicloCompletado(int ciclo);
    }

private List<AlarmaListener> listeners = new ArrayList<AlarmaListener>();
    public void addAlarmaListener(AlarmaListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(int ciclo) {
        for (AlarmaListener listener : listeners) {
            listener.cicloCompletado(ciclo);
        }
    }

    public Alarma() {
        System.out.print("alarma inicia");
        timer = new Timer();
        timbre = new Timbre();

    }

    public void inicir(int hora, int minuto, int segundo) {
        ciclosCompletados = 0;
        notifyListeners(ciclosCompletados);
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

            if (tiempoRestante <= 0) {
                ciclosCompletados++;
                notifyListeners(ciclosCompletados);
                getTimbre().inicir();

                //getTimbre().panel();
                System.out.println("¡¡¡ALARMA!!!");

                //alarmaSe(1);
                tiempoRestante = INTERVALO; // Reiniciar el tiempo restante

            }
        }

    }
}
