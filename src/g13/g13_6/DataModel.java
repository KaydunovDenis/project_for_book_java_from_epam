package g13.g13_6;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

class DataModel extends AbstractTableModel {
    private final String[] HEADERS ={"N","X", "Y"};
    private final int COLS = 3;
    private int rows = 0;

    public void setValueAt(Object value, int row, int col) {
        String stringValue = value.toString();
        System.out.println(stringValue + " row = " + row + " col=" + col);
        TableFunction.list.get(row)[col] = stringValue;
        fireTableDataChanged(); //обновление таблицы после изменений
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void addRow(int N, double X, double Y) {
        TableFunction.list.add(new String[COLS]);
        setValueAt(N, rows, 0);
        setValueAt(X, rows, 1);
        setValueAt(Y, rows, 2);
        rows++;
    }

    public Class getColumnClass(int col) {
        switch (col) {
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
        }
        return null;
    }

    public String getColumnName(int col) {
        return HEADERS[col];
    }
    public int getRowCount() {
        return rows;
    }
    public int getColumnCount() {
        return COLS;
    }
    public Object getValueAt(int row, int col) {
        return TableFunction.list.get(row)[col];
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}

