package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

@SuppressWarnings("unused")
public class TableAdapter<M extends Model> extends DefaultTableModel {

    private final Class<M> clazz;

    public TableAdapter(Class<M> clazz) {
        this.clazz = clazz;
    }

    public TableAdapter(int rowCount, int columnCount, Class<M> clazz) {
        super(rowCount, columnCount);
        this.clazz = clazz;
    }

    public TableAdapter(Vector<String> columnNames, int rowCount, Class<M> clazz) {
        super(columnNames, rowCount);
        this.clazz = clazz;
    }

    public TableAdapter(String[] columnNames, int rowCount, Class<M> clazz) {
        super(columnNames, rowCount);
        this.clazz = clazz;
    }

    public TableAdapter(Vector<Vector<M>> items, Vector<String> columnNames, Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    public TableAdapter(M[][] items, String[] columnNames, Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    @Override
    public M getValueAt(int row, int column) {
        return clazz.cast(super.getValueAt(row, column));
    }
}
