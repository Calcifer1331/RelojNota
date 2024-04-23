package com.mytools.ilib;

import com.mytools.utils.Alarma;
import com.mytools.views.Inicio;
import com.mytools.views.NewJPanel;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Dashboard extends javax.swing.JFrame {

    public static Alarma alarma;
    private Inicio inicio;
//    private List<Alarma_Timbre> alarmas = new ArrayList<Alarma_Timbre>();
    private TrayIcon trayIcon;

    public Dashboard() {
        initComponents();
        initTrayIcon();
        ImageIcon icon = new ImageIcon(getClass().getResource("/resource/IconoReloj/reloj300.png"));
        setIconImage(icon.getImage());
        Init();
    }

    private void initTrayIcon() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resource/IconoReloj/reloj16.png"));
            ActionListener listener = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(MAXIMIZED_BOTH);
                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem AbrirtItem = new MenuItem("Abrir");
            AbrirtItem.addActionListener(listener);
            MenuItem CerrarItem = new MenuItem("Cerrar");
            CerrarItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });
            MenuItem StropItem = new MenuItem("Detener Alarma");
            StropItem.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    inicio.getBotonDetener().doClick();
                }
            });

            popup.add(AbrirtItem);
            popup.add(CerrarItem);
            popup.add(StropItem);

            trayIcon = new TrayIcon(image, "Dashboard", popup);
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("Error al agregar el icono de la bandeja del sistema.");
            }

            addWindowListener(new WindowAdapter() {

                public void windowIconified(WindowEvent e) {
                    setVisible(false);
                }
            });
        }
    }

    private void Init() {
        alarma = new Alarma();
        alarma.setHoraInicio(2);
        alarma.getTimbre().setMinutoInicio(2);
        inicio = new Inicio(alarma, this);
        alarma.addAlarmaListener(inicio);
        alarma.getTimbre().addTimbreListener(inicio);
        //configuracion = new Configuracion();

//        Alarma_Timbre alarma_Timbre = new Alarma_Timbre("Yoseph");
//        alarmas.add(alarma_Timbre);
//        System.out.println(alarmas.get(0).getNombre());
        ShoJPanel(inicio);
    }

    public static void ShoJPanel(JPanel p) {
        content.removeAll();
        content.setLayout(new BorderLayout());  // Añade esta línea para restablecer el diseño del Content
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        panelDegradadoBack1 = new com.mytools.swings.JComponents.PanelDegradadoBack();
        scrollPanelTransparente1 = new com.mytools.swings.JComponents.ScrollPanelTransparente();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPanelTransparente1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        content.setOpaque(false);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        scrollPanelTransparente1.setViewportView(content);

        javax.swing.GroupLayout panelDegradadoBack1Layout = new javax.swing.GroupLayout(panelDegradadoBack1);
        panelDegradadoBack1.setLayout(panelDegradadoBack1Layout);
        panelDegradadoBack1Layout.setHorizontalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelDegradadoBack1Layout.setVerticalGroup(
            panelDegradadoBack1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDegradadoBack1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradadoBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDegradadoBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(" If Nimbus is not available, you can set the GUI to another look and feel.");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Dashboard d = new Dashboard();
                d.setVisible(true);
                d.setExtendedState(MAXIMIZED_BOTH);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel content;
    private javax.swing.JPopupMenu jPopupMenu1;
    public com.mytools.swings.JComponents.PanelDegradadoBack panelDegradadoBack1;
    private com.mytools.swings.JComponents.ScrollPanelTransparente scrollPanelTransparente1;
    // End of variables declaration//GEN-END:variables
}
