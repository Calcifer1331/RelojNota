package com.mytools.swings.JComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFranccion extends JSlider {

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    private float floatValue;

    public SliderFranccion() {
        cargarConfigiuracion();
    }

    private void cargarConfigiuracion() {
        setPaintTicks(true);
        setMajorTickSpacing(10);
        setPaintLabels(true);
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

        setForeground(Color.WHITE);
        // Agregar un ChangeListener al JSlider
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Obtener el valor del JSlider como un float en el rango 0.0f a 1.0f
                setFloatValue(getValue() / 100.0f);

            }
        });
    }

}
