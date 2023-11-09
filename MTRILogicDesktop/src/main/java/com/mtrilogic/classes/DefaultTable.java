package com.mtrilogic.classes;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.abstracts.TableItem;
import com.mtrilogic.adapters.TableAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultTable<M extends Model> extends JTable {

    private final Class<M> clazz;

    public DefaultTable(@NotNull Class<M> clazz) {
        super();
        this.clazz = clazz;
    }

    public DefaultTable(@NotNull TableAdapter<M> adapter, @NotNull Class<M> clazz) {
        super(adapter);
        this.clazz = clazz;
    }

    public DefaultTable(@NotNull TableAdapter<M> adapter, @NotNull TableColumnModel columnModel, @NotNull Class<M> clazz) {
        super(adapter, columnModel);
        this.clazz = clazz;
    }

    public DefaultTable(@NotNull TableAdapter<M> adapter, @NotNull TableColumnModel columnModel, @NotNull ListSelectionModel selectionModel, @NotNull Class<M> clazz) {
        super(adapter, columnModel, selectionModel);
        this.clazz = clazz;
    }

    public DefaultTable(int numRows, int numColumns, @NotNull Class<M> clazz) {
        super(numRows, numColumns);
        this.clazz = clazz;
    }

    public DefaultTable(@NotNull Vector<Vector<M>> items, @NotNull Vector<String> columnNames, @NotNull Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    public DefaultTable(@NotNull M[][] items, @NotNull String[] columnNames, @NotNull Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    @Override
    public M getValueAt(int row, int column) {
        return clazz.cast(super.getValueAt(row, column));
    }

    public TableAdapter<M> getAdapter(@NotNull Class<TableAdapter<M>> clazz){
        return clazz.cast(getModel());
    }

    public void setAdapter(@NotNull TableAdapter<M> adapter){
        setModel(adapter);
    }

    public TableItem<M> getDefaultItem(Class<TableItem<M>> clazz){
        return clazz.cast(getDefaultRenderer(String.class));
    }

    public void setDefaultItem(@NotNull TableItem<M> item){
        setDefaultRenderer(String.class, item);
    }

    public TableItem<M> getColumnItem(Class<TableItem<M>> clazz, int column){
        return clazz.cast(getColumnModel().getColumn(column).getCellRenderer());
    }

    public void setColumnItem(@NotNull TableItem<M> item, int column) {
        getColumnModel().getColumn(column).setCellRenderer(item);
    }
}
