/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mywebmanager.swings.JComponents;

import com.mywebmanager.db.ConfiguracionArchivo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;

public class Slider extends JSlider {

    public Slider() {
        cargarConfigiuracion();
        ConfiguracionArchivo.getForeground("labelText", this);
    }

    private void cargarConfigiuracion() {
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

    }
}
