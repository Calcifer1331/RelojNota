/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mytools.swings.JComponents.tree;

import javax.swing.tree.DefaultMutableTreeNode;

public class TreeNode extends DefaultMutableTreeNode {

    private String name;
    private boolean isFolder;
    private boolean isEmpty;

    public TreeNode(String name, boolean isFolder, boolean isEmpty) {
        super(name);
        this.name = name;
        this.isFolder = isFolder;
        this.isEmpty = isEmpty;
    }

    public TreeNode(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String getNameFile() {
        String name = getName();
        if (name != null && !name.isEmpty() && name.contains(".")) {
            return isFolder() ? name : name.substring(0, name.lastIndexOf('.'));
        } else {
            return name;
        }
    }
    

}
