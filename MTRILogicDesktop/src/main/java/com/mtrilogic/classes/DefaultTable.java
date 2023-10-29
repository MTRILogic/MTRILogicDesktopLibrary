package com.mtrilogic.classes;

import com.mtrilogic.abstracts.Model;
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

    public <TA extends TableAdapter<M>> TA getAdapter(@NotNull Class<TA> clazz){
        return clazz.cast(getModel());
    }
}
