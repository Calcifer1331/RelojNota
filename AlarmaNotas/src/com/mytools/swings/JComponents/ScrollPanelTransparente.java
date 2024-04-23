
package com.mytools.swings.JComponents;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
public class ScrollPanelTransparente extends JScrollPane{
    public ScrollPanelTransparente() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        getViewport().setOpaque(false);
        setHorizontalScrollBar(null);
        setBorder(null);
        setViewportBorder(null);
    }
    
}
