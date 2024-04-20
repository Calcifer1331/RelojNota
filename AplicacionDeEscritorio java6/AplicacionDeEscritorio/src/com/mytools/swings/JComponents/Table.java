package com.mytools.swings.JComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Table extends JTable {

    public Table() {
        cargarConfiguracion();

        getTableHeader().setForeground(getForeground());
    }

    private void cargarConfiguracion() {
        setFont(new Font("Segoe UI Semilight", 0, 14));
        setForeground(Color.WHITE);
        getTableHeader().setFont(new Font("Segoe UI Semibold", 0, 14));
        setRowHeight(40);
        setShowGrid(true);

    }

}
