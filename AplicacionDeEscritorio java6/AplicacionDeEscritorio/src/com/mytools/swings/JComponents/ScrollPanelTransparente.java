
package com.mytools.swings.JComponents;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class ScrollPanelTransparente extends JScrollPane{
    public ScrollPanelTransparente() {
        setOpaque(false);
        setBackground(new Color(0, 0, 0, 0));
        getViewport().setOpaque(false);
        setHorizontalScrollBar(null);
        setBorder(null);
    }
    
}
