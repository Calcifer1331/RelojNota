
package com.mytools.swings.JComponents.Label;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LabelCopy extends JLabel{
    
    private final int  MAX_ICON_SIZE=20;
    

    public LabelCopy() {
        cargarConfiguraio();
    }
    
    public void cargarConfiguraio(){
        setBackground(new Color(0,0,0,250));
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setForeground(Color.WHITE);
        
        setText("Calcifer ©.");
    }
}
