package com.mytools.swings.JComponents.Alarmas;

import com.mytools.utils.Timbre;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Alarma_Timbre {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


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
    
    private String nombre;

    int ciclosCompletados;

    public interface AlarmaListener {

        void cicloCompletado(int ciclo);
    }

    private List<AlarmaListener> listeners = new ArrayList<>();

    public void addAlarmaListener(AlarmaListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(int ciclo) {
        for (AlarmaListener listener : listeners) {
            listener.cicloCompletado(ciclo);
        }
    }

    public Alarma_Timbre() {
        timer = new Timer();
        timbre = new Timbre();
    }
    public Alarma_Timbre(String nombre) {
        timer = new Timer();
        timbre = new Timbre();
        this.nombre =nombre;
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

        private Clip clip;

        public interface TimbreListener {

            void cicloCompletado(boolean activo);
        }

        private List<TimbreListener> listeners = new ArrayList<>();

        public void addTimbreListener(TimbreListener listener) {
            listeners.add(listener);
        }

        public void notifyListeners(boolean activo) {
            for (TimbreListener listener : listeners) {
                listener.cicloCompletado(activo);
            }
        }

        public Timbre() {
            timer = new Timer();
            // Cargar el archivo de sonido
        }

        public Timbre(Timer timer, int horaInicio, int minutoInicio, int segundoInicio) {
            this.timer = timer;
            this.horaInicio = horaInicio;
            this.minutoInicio = minutoInicio;
            this.segundoInicio = segundoInicio;
        }

        private void iniciraWAV() {
            try {

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/resource/alarma.wav"));

                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void inicir(int hora, int minuto, int segundo) {
            setHoraInicio(hora);
            setMinutoInicio(minuto);
            setSegundoInicio(segundo);

            notifyListeners(true);

            iniciraWAV();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            INTERVALO = (long) ((getHoraInicio() * 60 * 60) + (getMinutoInicio() * 60) + getSegundoInicio()) * 1000;

            timer.schedule(new MiTarea(), 0, 1000); // Actualizar cada segundo
        }

        public void inicir() {
            notifyListeners(true);
            iniciraWAV();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            INTERVALO = (long) ((getHoraInicio() * 60 * 60) + (getMinutoInicio() * 60) + getSegundoInicio()) * 1000;

            timer.schedule(new MiTarea(), 0, 1000); // Actualizar cada segundo
        }

        public void detener() {
            timer.cancel();
            timer = new Timer();
            notifyListeners(false);
            clip.close();
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
                    System.out.println("Timer Detenido");
                    detener();
                }

            }
        }
    }
}
