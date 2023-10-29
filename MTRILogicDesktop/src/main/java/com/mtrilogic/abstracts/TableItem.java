package com.mtrilogic.abstracts;

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


    protected final DefaultTableCellRenderer renderer;
    protected final TableItemListener listener;
    protected final Class<M> clazz;

    protected abstract boolean onTableItemRenderer(JTable table, M value, boolean isSelected, boolean hasFocus, int row, int column);

    public TableItem(@NotNull Class<M> clazz, @NotNull TableItemListener listener){
        this(null, clazz, listener);
    }

    public TableItem(DefaultTableCellRenderer renderer, @NotNull Class<M> clazz, @NotNull TableItemListener listener){
        if (renderer == null) {
            renderer = new DefaultTableCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.onItemClick(e);
            }
        });
    }

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (!onTableItemRenderer(table, clazz.cast(value), isSelected, hasFocus, row, column)){
            return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        } else {
            return this;
        }
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }
}
