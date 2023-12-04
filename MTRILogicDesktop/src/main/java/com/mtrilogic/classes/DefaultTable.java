package com.mtrilogic.classes;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.abstracts.TableItem;
import com.mtrilogic.adapters.TableAdapter;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultTable<M extends Model> extends JTable {

    private final Class<M> clazz;

    public DefaultTable(Class<M> clazz) {
        super();
        this.clazz = clazz;
    }

    public DefaultTable(TableAdapter<M> adapter, Class<M> clazz) {
        super(adapter);
        this.clazz = clazz;
    }

    public DefaultTable(TableAdapter<M> adapter, TableColumnModel columnModel, Class<M> clazz) {
        super(adapter, columnModel);
        this.clazz = clazz;
    }

    public DefaultTable(TableAdapter<M> adapter, TableColumnModel columnModel, ListSelectionModel selectionModel, Class<M> clazz) {
        super(adapter, columnModel, selectionModel);
        this.clazz = clazz;
    }

    public DefaultTable(int numRows, int numColumns, Class<M> clazz) {
        super(numRows, numColumns);
        this.clazz = clazz;
    }

    public DefaultTable(Vector<Vector<M>> items, Vector<String> columnNames, Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    public DefaultTable(M[][] items, String[] columnNames, Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    @Override
    public M getValueAt(int row, int column) {
        return clazz.cast(super.getValueAt(row, column));
    }

    public TableAdapter<M> getAdapter(Class<TableAdapter<M>> clazz){
        return clazz.cast(getModel());
    }

    public void setAdapter(TableAdapter<M> adapter){
        setModel(adapter);
    }

    public TableItem<M> getDefaultItem(Class<TableItem<M>> clazz){
        return clazz.cast(getDefaultRenderer(String.class));
    }

    public void setDefaultItem(TableItem<M> item){
        setDefaultRenderer(String.class, item);
    }

    public TableItem<M> getColumnItem(Class<TableItem<M>> clazz, int column){
        return clazz.cast(getColumnModel().getColumn(column).getCellRenderer());
    }

    public void setColumnItem(TableItem<M> item, int column) {
        getColumnModel().getColumn(column).setCellRenderer(item);
    }
}
