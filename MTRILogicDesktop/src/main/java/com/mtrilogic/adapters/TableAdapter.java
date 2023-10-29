package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

@SuppressWarnings("unused")
public class TableAdapter<M extends Model> extends DefaultTableModel {

    private final Class<M> clazz;

    public TableAdapter(@NotNull Class<M> clazz) {
        this.clazz = clazz;
    }

    public TableAdapter(int rowCount, int columnCount, @NotNull Class<M> clazz) {
        super(rowCount, columnCount);
        this.clazz = clazz;
    }

    public TableAdapter(@NotNull Vector<String> columnNames, int rowCount, @NotNull Class<M> clazz) {
        super(columnNames, rowCount);
        this.clazz = clazz;
    }

    public TableAdapter(@NotNull String[] columnNames, int rowCount, @NotNull Class<M> clazz) {
        super(columnNames, rowCount);
        this.clazz = clazz;
    }

    public TableAdapter(@NotNull Vector<Vector<M>> items, @NotNull Vector<String> columnNames, @NotNull Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    public TableAdapter(@NotNull M[][] items, @NotNull String[] columnNames, @NotNull Class<M> clazz) {
        super(items, columnNames);
        this.clazz = clazz;
    }

    @Override
    public M getValueAt(int row, int column) {
        return clazz.cast(super.getValueAt(row, column));
    }
}
