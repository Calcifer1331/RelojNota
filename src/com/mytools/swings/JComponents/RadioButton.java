/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytools.swings.JComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;

public class RadioButton extends JRadioButton{

    public RadioButton() {
        cargarConfiguracion();
    }
    private void cargarConfiguracion(){
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
        setForeground(Color.WHITE);
    }
    
}
