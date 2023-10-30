package com.mtrilogic.abstracts;

import com.mtrilogic.classes.DefaultTable;
import com.mtrilogic.interfaces.TableItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class TableItem<M extends Model> extends SpringPanel implements TableCellRenderer {

    protected final TableItemListener<M> listener;
    protected final Class<M> clazz;

    private final DefaultTableCellRenderer renderer;

    private boolean isSelected;
    private boolean hasFocus;
    private int column;
    private int row;
    private M model;

    protected abstract boolean onTableItemRenderer(DefaultTable<M> table, M model, boolean isSelected, boolean hasFocus, int row, int column);

    public TableItem(@NotNull Class<M> clazz, @NotNull TableItemListener<M> listener){
        this(null, clazz, listener);
    }

    public TableItem(DefaultTableCellRenderer renderer, @NotNull Class<M> clazz, @NotNull TableItemListener<M> listener){
        if (renderer == null) {
            renderer = new DefaultTableCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        listener.getDefaultTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemClick(e);
            }
        });
    }

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (!onTableItemRenderer((listener.getDefaultTable()), (model = clazz.cast(value)), (this.isSelected = isSelected), (this.hasFocus = hasFocus), (this.row = row), (this.column = column))) {
            return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        } else {
            return this;
        }
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean hasFocus() {
        return hasFocus;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public M getModel() {
        return model;
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }

    void itemClick(@NotNull MouseEvent event){
        listener.onTableItemClick(event, this);
    }
}
