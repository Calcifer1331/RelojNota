package com.mytools.swings.JComponents.Alarmas;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyList<E extends Object> extends JList<E> {

    public DefaultListModel getModel() {
        return model;
    }

    private final DefaultListModel model;
    private int hoverindex = -1;
    private boolean press;

    public MyList() {
        model = new DefaultListModel();
        setModel(model);

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                checkMouse(e);
            }

        });
    }

    private void checkMouse(MouseEvent me) {
        Point p = me.getPoint();
        int index = locationToIndex(p);
        if (index != hoverindex) {
            hoverindex = index;
            repaint();
        }
    }

    @Override
    public ListCellRenderer getCellRenderer() {
        return new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                ListItem ListItem = new ListItem();

                ListItem.setItem(value);

                ListItem.getPanel().setSelecionado(isSelected);
                if (index == hoverindex || isSelected) {
                    ListItem.getPanel().setPress(true);
                    ListItem.getPanel().setExitado(true);
                } else {
                    ListItem.getPanel().setPress(false);
                }

                return ListItem;
            }

        };
    }

    public void addItem(Alarma_Timbre item) {
        getModel().addElement(item);
    }

    public void addItems(Map<Integer, Alarma_Timbre> items) {
        for (Alarma_Timbre item : items.values()) {
            addItem(item);
        }
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

}
