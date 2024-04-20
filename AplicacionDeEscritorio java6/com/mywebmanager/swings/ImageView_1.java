package com.mywebmanager.swings;

import com.mywebmanager.ilib.Dashboard;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageView extends JPanel {

    public ImageView() {
        setOpaque(false);
    }
    

    private BufferedImage backgroundImage;

    public void loadBackgroundImage(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            backgroundImage = ImageIO.read(url);
            repaint();
        } catch (IOException ex) {
            Toolkit.getDefaultToolkit().beep();
            javax.swing.JOptionPane.showMessageDialog(Dashboard.content, "No contiene una URL valida \n", "AVISO", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja la imagen de fondo si está disponible
        if (backgroundImage != null) {
            int imgWidth = backgroundImage.getWidth();
            int imgHeight = backgroundImage.getHeight();

            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double scaleFactor = Math.min((double) panelWidth / imgWidth, (double) panelHeight / imgHeight);

            int newWidth = (int) (imgWidth * scaleFactor);
            int newHeight = (int) (imgHeight * scaleFactor);

            int x = (panelWidth - newWidth) / 2;
            int y = (panelHeight - newHeight) / 2;

            g2.drawImage(backgroundImage, x, y, newWidth, newHeight, this);
        } else {
            System.out.println("No se pintó");
        }
    }
}
