package com.mytools.swings.JComponents.tree;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

    private FlatSVGIcon svgIcon;

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
        setForeground(Color.WHITE);
    }

    @Override
    public TreeCellRenderer getCellRenderer() {
        return new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                Component component = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

                if (value instanceof TreeNode) {
                    TreeNode node = (TreeNode) value;

                    if (node.isFolder()) {
                        if (expanded) {
                            setIcon(setSvgImage("resource/Opened Folder.svg"));

                        } else {
                            if (node.isEmpty()) {
                                setIcon(setSvgImage("resource/Folder null.svg"));
                            } else {
                                setIcon(setSvgImage("resource/Folder full.svg"));
                            }
                        }
                    } else {
                        if (node.isEmpty()) {
                            setIcon(setSvgImage("resource/File.svg"));
                        } else {
                            setIcon(setSvgImage("resource/Document.svg"));
                        }

                    }
                    setBorder(new EmptyBorder(5, 5, 5, 5));
                    setText(node.getNameFile());
                }
                //setTextSelectionColor(Color.BLACK);
                setBackgroundSelectionColor(new Color(250, 250, 250, 25));
                //setBackgroundNonSelectionColor(Color.GREEN);
                setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
                setForeground(Color.WHITE);

                return component;

            }
        };
    }

    public ImageIcon setSvgImage(String image, int width, int height) {
        svgIcon = new FlatSVGIcon(image, width, height);
        return (svgIcon);
    }

    public ImageIcon setSvgImage(String image) {
        svgIcon = new FlatSVGIcon(image, 25, 25);
        return (svgIcon);
    }

    private void init() {
        setFolder(new File(folderPath));
        actualizar(getFolder());
        addTreeSelectionListener(e -> {
            TreePath path = e.getPath();
            TreeNode selectedNode = (TreeNode) path.getLastPathComponent();
            setSelectedFolder(new File(getPath(selectedNode)));
            loadFromFile(getSelectedFolder());
            getLabelTitle().setText(selectedNode.getNameFile());
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
        if (textArea != null) {
            if (file.exists() && file.isFile()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
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

    private String getPath(TreeNode node) {
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
            System.out.println(selectedFile);
            if (selectedFile.exists()) {
                if (selectedFile.delete()) {
                    actualizar(getFolder());
                    labelMensaje.setText("Se elimino: " + selectedPath);
                } else {
                    labelMensaje.setText("No se pudo eliminar: " + selectedPath);
                }
            }
        } else {
            labelMensaje.setText("No se ha seleccionado ningún archivo o directorio.");
        }

    }

}
