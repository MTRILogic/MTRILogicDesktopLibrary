package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.TableAdapter;
import com.mtrilogic.classes.DefaultTable;
import com.mtrilogic.interfaces.TableItemListener;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class TableItem<M extends Model> extends SpringPanel implements TableCellRenderer {

    private final DefaultTableCellRenderer renderer;
    private final TableItemListener<M> listener;
    private final Class<M> clazz;

    protected abstract boolean onTableItemRenderer(DefaultTable<M> table, M model, boolean isSelected, boolean hasFocus, int row, int column);

    public TableItem(Class<M> clazz, TableItemListener<M> listener){
        this(null, clazz, listener);
    }

    public TableItem(DefaultTableCellRenderer renderer, Class<M> clazz, TableItemListener<M> listener){
        if (renderer == null) {
            renderer = new DefaultTableCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        this.clazz = clazz;
        listener.getDefaultTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                DefaultTable<M> table = getDefaultTable();
                int row = table.rowAtPoint(event.getPoint());
                int column = table.columnAtPoint(event.getPoint());
                M model = getAdapter().getValueAt(row, column);
                listener.onTableItemClick(event, model, row, column);
            }
        });
    }

    @Override
    public final Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (!onTableItemRenderer(getDefaultTable(), clazz.cast(value), isSelected, hasFocus, row, column)) {
            return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        } else {
            return this;
        }
    }

    protected DefaultTable<M> getDefaultTable(){
        return listener.getDefaultTable();
    }

    protected TableAdapter<M> getAdapter(){
        return listener.getAdapter();
    }
}
