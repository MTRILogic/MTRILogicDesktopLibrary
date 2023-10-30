package com.mtrilogic.abstracts;

import com.mtrilogic.classes.DefaultList;
import com.mtrilogic.interfaces.ListItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ListItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final ListItemListener<M> listener;

    private final DefaultListCellRenderer renderer;

    private boolean cellHasFocus;
    private boolean isSelected;
    private int index;
    private M model;

    protected abstract boolean onListItemRenderer(DefaultList<M> list, M value, int index, boolean isSelected, boolean cellHasFocus);

    public ListItem(@NotNull ListItemListener<M> listener){
        this(null, listener);
    }

    public ListItem(DefaultListCellRenderer renderer, @NotNull ListItemListener<M> listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemClick(e);
            }
        });
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onListItemRenderer(listener.getDefaultList(), (this.model = model), (this.index = index), (this.isSelected = isSelected), (this.cellHasFocus = cellHasFocus))) {
            return renderer.getListCellRendererComponent(list, model, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    public boolean isCellHasFocus() {
        return cellHasFocus;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public M getModel() {
        return model;
    }

    public int getIndex() {
        return index;
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }

    private void itemClick(@NotNull MouseEvent event){
        listener.onListItemClick(event, this);
    }
}
