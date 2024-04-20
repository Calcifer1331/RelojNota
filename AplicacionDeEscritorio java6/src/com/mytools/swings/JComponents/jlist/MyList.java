package com.mytools.swings.JComponents.jlist;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class MyList<E extends Object> extends JList<E> {

    public DefaultListModel getModel() {
        return model;
    }

    /**
     * Define un nuevo modelo
     */
    private final DefaultListModel model;
    private int hoverindex = -1;
    private boolean press;

    public MyList() {
        /**
         * Instancia el nuevo modelo
         */
        model = new DefaultListModel();
        /**
         * Asigna el nuevo modelo
         */
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

    /**
     * ListCellRenderer se utiliza para personalizar la apariencia de los
     * elementos en un JList
     *
     * @return
     */
    @Override
    public ListCellRenderer getCellRenderer() {
        /*
        se está creando una instancia anónima de DefaultListCellRenderer y 
        se está sobrescribiendo el método getListCellRendererComponent para 
        personalizar la apariencia de cada elemento en la lista.
         */
        return new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                /*
                se crea un nuevo objeto ListItem
                 */
                ListItem ListItem = new ListItem();
                /**
                 * value debería ser el objeto que se desea mostrar en el
                 * ListItem
                 */
                ListItem.setItem(value);
                /**
                 * este objeto ListItem se devuelve como el componente que se
                 * mostrará en la lista en lugar del valor original.
                 */

                ListItem.getPanel().setSelecionado(isSelected);
                if (index == hoverindex || isSelected) {
                    ListItem.getPanel().setPress(true);
                    ListItem.getPanel().setExitado(true);
                } else {
                    ListItem.getPanel().setPress(false);
                }

                return ListItem;
                //return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        };
    }

    /**
     * Agrega un item-elemento al modelo
     *
     * @param item elemento a agregar
     */
    public void addItem(Item item) {
        getModel().addElement(item);
    }

    public void addItem(Item[] item) {
        for(Item i: item){
            getModel().addElement(i);
        }
        
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
    }

}
