package com.mytools.swings.JComponents.tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

public class Tree extends JTree {

    public File getFolder() {
        return folder;
    }

    public void setFolder(File folder) {
        this.folder = folder;
    }

    public JLabel getLabelTitle() {
        return labelTitle;
    }

    public void setLabelTitle(JLabel labelTitle) {
        this.labelTitle = labelTitle;
    }

    public File getSelectedFolder() {
        return selectedFolder;
    }

    public void setSelectedFolder(File selectedFolder) {
        this.selectedFolder = selectedFolder;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JLabel getLabelMensaje() {
        return labelMensaje;
    }

    public void setLabelMensaje(JLabel labelMensaje) {
        this.labelMensaje = labelMensaje;
    }
    TreeNode root;//Raiz del arbol
    private DefaultTreeModel modelo;//modelo del arbol
    private String folderPath = "Notas";
    private File folder;
    private JTextArea textArea = new JTextArea();
    private JLabel labelMensaje = new JLabel();
    private JLabel labelTitle = new JLabel();
    private File selectedFolder;

    public Tree() {
        init();
        setOpaque(false);
        setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));

    }

    @Override
    public TreeCellRenderer getCellRenderer() {
        return new DefaultTreeCellRenderer() {

            @Override
            public JLabel getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                JLabel jLabel = (JLabel) super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
                if (value instanceof TreeNode) {
                    TreeNode node = (TreeNode) value;

                    if (node.isFolder()) {
                        if (expanded) {
                            setIcon(setImage("/resource/Opened Folder.png"));

                        } else {
                            if (node.isEmpty()) {
                                setIcon(setImage("/resource/Folder null.png"));
                            } else {
                                setIcon(setImage("/resource/Folder full.png"));
                            }
                        }
                    } else {
                        if (node.isEmpty()) {
                            setIcon(setImage("/resource/File.png"));
                        } else {
                            setIcon(setImage("/resource/Document.png"));
                        }

                    }
                    setBorder(new EmptyBorder(5, 5, 5, 5));
                    setText(node.getNameFile());
                }
                
                    setTextNonSelectionColor(Color.BLACK);
                    setTextSelectionColor(Color.CYAN);
                setBackgroundSelectionColor(new Color(250, 250, 250, 20));
                setBackgroundSelectionColor(new Color(67, 98, 12)); // Fondo transparente
                setBorderSelectionColor(new Color(240,23,12)); // Borde transparente
                
                
                setOpaque(false);
                setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
                setForeground(Color.BLACK);
                
                setBackground(new Color(67, 12, 213,0));
                return jLabel;

            }
            @Override
        protected void paintComponent(Graphics g) {
            Color bColor = getBackground();
            if (bColor != null) {
                g.setColor(bColor);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
            super.paintComponent(g);
        }
        };
    }

    public ImageIcon setImage(String image) {
        URL imageUrl = getClass().getResource(image);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            Image scaledImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } else {
            // Manejar el caso en el que la URL sea nula
            System.err.println("Error: La URL de la imagen es nula para " + image);
            return null;
        }
    }

    private void init() {
        setFolder(new File(folderPath));
        actualizar(getFolder());
        addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                TreePath path = e.getPath();
                TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
                setSelectedFolder(new File(getPath(selectedNode)));
                loadFromFile(getSelectedFolder());
                getLabelTitle().setText(selectedNode.getNameFile());
            }
        });
    }

    public void expandirTodosLosNodos() {
        expandirNodos((DefaultMutableTreeNode) getModel().getRoot());
    }

    private void expandirNodos(DefaultMutableTreeNode nodo) {
        if (nodo != null) {
            expandPath(new TreePath(nodo.getPath()));
            for (int i = 0; i < nodo.getChildCount(); i++) {
                DefaultMutableTreeNode hijo = (DefaultMutableTreeNode) nodo.getChildAt(i);
                expandirNodos(hijo);
            }
        }
    }

    private void loadFromFile(File file) {
        if (getSelectedFolder().isFile()) {//------------------------------
            textArea.setEnabled(true);
        } else {
            textArea.setEnabled(false);
        }
        if (textArea != null) {
            if (file.exists() && file.isFile()) {
                BufferedReader reader = null;
                //try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {//aqui tengo error
                try {
                    reader = new BufferedReader(new FileReader(file));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    textArea.setText(sb.toString());

                    //labelMensaje.setText(file.getName().substring(0, file.getName().lastIndexOf('.')));
                } catch (IOException e) {
                    e.printStackTrace();
                    labelMensaje.setText("Error al cargar: " + file.getName().substring(0, file.getName().lastIndexOf('.')));
                }
            } else {
                textArea.setText("");
                labelMensaje.setText(file.isDirectory() ? "" : "El archivo no existe");
            }
        } else {
            labelMensaje.setText("No hay componente");
        }
    }

    public String getPath(TreeNode node) {
        StringBuilder path = new StringBuilder(node.getName());
        TreeNode parent = (TreeNode) node.getParent();
        while (parent != null) {
            path.insert(0, File.separator);
            path.insert(0, parent.getName());
            parent = (TreeNode) parent.getParent();
        }
        return path.toString();
    }

    public void actualizar(File fichero) {
        if (fichero.exists() && fichero.isDirectory()) {
            root = new TreeNode(fichero.getName());//crear raiz del arbol con nombre del fiile
            modelo = new DefaultTreeModel(root);//actuazliar el modelo con le nueva raiz
            //llamr a metodo que crea todo el arbol

            crear(root, fichero);//crear arbol apropiado a partir de raiz
            this.setModel(modelo);//cambiar modelo del arbol
            expandirTodosLosNodos();
            labelMensaje.setText("La carpeta raiz es: " + fichero.getPath());
        } else {
            // Crea la carpeta si no existe
            if (fichero.mkdirs()) {
                System.out.println("Carpeta creada: " + fichero.getPath());
                actualizar(fichero);
            } else {
                System.out.println("No se pudo crear la carpeta.");
            }
            labelMensaje.setText("La carpeta no existe o no es un directorio válido.");
        }
    }

    private void crear(TreeNode nodo, File carpeta) {
        // Obtener los hijos para ir creando nodos
        File[] archivos = carpeta.listFiles();
        // Si fichero creamos nodo, si carpeta creamos nodo y llamamos recursivamente
        if (archivos != null) {// Tiene algún directorio o archivo en su interior
            int contador = 0;
            for (File f : archivos) {// Recreamos el vector de ficheros y carpetas hijas

                TreeNode hijo = new TreeNode(f.getName(), f.isDirectory(), f.isDirectory() ? f.listFiles().length == 0 : f.length() == 0);// Crear nodo con nombre
                crear(hijo, f);
                modelo.insertNodeInto(hijo, nodo, contador);// Lo insertamos en su padre
                contador++;// Para cambiar posición de los hijos
            }
        }
    }

    public void crearArchivoEnCarpetaSeleccionada(String nombreArchivo, JLabel label) {
        if (label == null) {
            label = labelMensaje;
        }
        TreePath path = getSelectionPath();
        if (path != null) {
            System.out.println(path);
            TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
            String selectedFolderPath = getPath(selectedNode);
            File selectedFolder = new File(selectedFolderPath);
            if (selectedFolder.exists() && selectedFolder.isDirectory()) {
                File nuevoArchivo = new File(selectedFolderPath + File.separator + nombreArchivo + ".txt");
                if (!nuevoArchivo.exists()) {
                    try {
                        if (nuevoArchivo.createNewFile()) {
                            actualizar(getFolder());
                            label.setText("Archivo creado en " + selectedFolderPath + ": " + nombreArchivo);
                        } else {
                            label.setText("No se pudo crear el archivo.");
                        }
                    } catch (IOException e) {
                        label.setText("Error al crear el archivo: " + e.getMessage());
                    }
                } else {
                    label.setText("El archivo ya existe en la carpeta seleccionada.");
                }
            } else {
                label.setText("La carpeta seleccionada no existe o no es un directorio válido.");
            }
        } else {
            label.setText("No se ha seleccionado ninguna carpeta.");
        }
    }

    public void crearCarpetaEnCarpetaSeleccionada(String nombreCarpeta) {
        TreePath path = getSelectionPath();
        if (path != null) {
            TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
            String selectedFolderPath = getPath(selectedNode);
            File selectedFolder = new File(selectedFolderPath);
            if (selectedFolder.exists() && selectedFolder.isDirectory()) {
                File nuevaCarpeta = new File(selectedFolderPath + File.separator + nombreCarpeta);
                if (!nuevaCarpeta.exists()) {
                    if (nuevaCarpeta.mkdirs()) {
                        actualizar(getFolder());
                        labelMensaje.setText("Carpeta creada en " + selectedFolderPath + ": " + nombreCarpeta);
                    } else {
                        labelMensaje.setText("No se pudo crear la carpeta.");
                    }
                } else {
                    labelMensaje.setText("La carpeta ya existe en la carpeta seleccionada.");
                }
            } else {
            }
            labelMensaje.setText("La carpeta seleccionada no existe o no es un directorio válido.");
        } else {
            labelMensaje.setText("No se ha seleccionado ninguna carpeta.");
        }

    }

    public void eliminarArchivoODirectorioSeleccionado() {

        TreePath path = getSelectionPath();
        if (path != null) {
            TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
            String selectedPath = getPath(selectedNode);
            File selectedFile = new File(selectedPath);
            System.out.println();
            System.out.println(selectedPath); // Imprimir la ruta del archivo
            System.out.println(selectedFile);
            System.out.println(selectedFile.getAbsolutePath());
            if (selectedFile.exists()) {
                if (selectedFile.delete()) {
                    actualizar(getFolder());
                    System.out.print(selectedPath);
                    labelMensaje.setText("Se elimino: " + selectedFile);
                } else {
                    labelMensaje.setText("No se pudo eliminar: " + selectedFile);
                    try {
                        selectedFile.delete();
                        System.out.println("try eliminar");
//                                SecurityManager securityManager
                    } catch (SecurityException securityException) {
                        System.out.println(securityException);
                    }
                }
            } else {
                labelMensaje.setText("No existe" + selectedFile);
            }
        } else {
            labelMensaje.setText("No se ha seleccionado ningún archivo o directorio.");
        }
    }
//    public void eliminarArchivoODirectorioSeleccionado() {
//    TreePath path = getSelectionPath();
//    if (path != null) {
//        TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
//        String selectedPath = getPath(selectedNode);
//        File selectedFile = new File(selectedPath);
//        System.out.println(selectedPath); // Imprimir la ruta del archivo
//        System.out.println(selectedFile);
//        if (selectedFile.exists()) {
//            // Obtener el nodo raíz
//            TreeNode rootNode = (TreeNode) getModel().getRoot();
//            TreePath rootPath = new TreePath(rootNode);
//            
//            // Seleccionar el nodo raíz antes de eliminar
//            setSelectionPath(rootPath);
//
//            if (selectedFile.delete()) {
//                actualizar(getFolder());
//                System.out.print(selectedPath);
//                labelMensaje.setText("Se eliminó: " + selectedPath);
//            } else {
//                labelMensaje.setText("No se pudo eliminar: " + selectedPath);
//            }
//        }
//    } else {
//        labelMensaje.setText("No se ha seleccionado ningún archivo o directorio.");
//    }
////}
//    public void eliminarArchivoODirectorioSeleccionado() {
//    TreePath path = getSelectionPath();
//    if (path != null) {
//        TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
//        String selectedPath = getPath(selectedNode);
//        File selectedFile = new File(selectedPath);
//        if (selectedFile.exists()) {
//            // Obtener el nodo raíz
//            TreeNode rootNode = (TreeNode) getModel().getRoot();
//            TreePath rootPath = new TreePath(rootNode);
//
//            // Seleccionar el nodo raíz antes de eliminar
//            setSelectionPath(rootPath);
//
//            if (selectedFile.delete()) {
//                actualizar(getFolder());
//                labelMensaje.setText("Se eliminó correctamente: " + selectedPath);
//            } else {
//                labelMensaje.setText("No se pudo eliminar: " + selectedPath);
//            }
//        } else {
//            labelMensaje.setText("El archivo o directorio seleccionado no existe.");
//        }
//    } else {
//        labelMensaje.setText("No se ha seleccionado ningún archivo o directorio.");
//    }
//}
}
