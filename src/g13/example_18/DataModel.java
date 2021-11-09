package g13.example_18;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

class DataModel extends AbstractTableModel {

    private final String[] HEADERS ={"Студент", "Оценка"};
    private final int COLS = 2;
    private int rows = 0;


    public void setValueAt(Object o, int row, int col) {
        if (col == 1){
            int mark = new Integer(o.toString());
            if (mark > 10 || mark < 0){
                JOptionPane.showMessageDialog(null,
                        "Введите число от 0 до 10", "Ошибка ввода!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        JTableDemo.list.get(row)[col] = o.toString();
        fireTableDataChanged(); //обновление таблицы после изменений
    }
    public boolean isCellEditable(int row, int col) {
        return true;
    }
    public void addRow(String name, int mark) {
        JTableDemo.list.add(new String[COLS]);
        setValueAt(name, rows, 0);
        setValueAt(mark, rows, 1);
        rows++;
    }
    public Class getColumnClass(int col) {
        switch (col) {
            case 0: return String.class;
            case 1: return Integer.class;
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
        return JTableDemo.list.get(row)[col];
    }
}
