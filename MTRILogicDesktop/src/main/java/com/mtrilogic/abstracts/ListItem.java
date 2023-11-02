package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.ListAdapter;
import com.mtrilogic.classes.DefaultList;
import com.mtrilogic.interfaces.ListItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ListItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    private final DefaultListCellRenderer renderer;
    private final ListItemListener<M> listener;

    protected abstract boolean onListItemRenderer(DefaultList<M> list, M model, int index, boolean isSelected, boolean cellHasFocus);

    public ListItem(@NotNull ListItemListener<M> listener){
        this(null, listener);
    }

    public ListItem(DefaultListCellRenderer renderer, @NotNull ListItemListener<M> listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        listener.getDefaultList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = getDefaultList().locationToIndex(e.getPoint());
                M model = getAdapter().getElementAt(index);
                listener.onListItemClick(e, model, index);
            }
        });
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onListItemRenderer(getDefaultList(), model, index, isSelected, cellHasFocus)) {
            return renderer.getListCellRendererComponent(list, model, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    protected DefaultList<M> getDefaultList(){
        return listener.getDefaultList();
    }

    protected ListAdapter<M> getAdapter(){
        return listener.getAdapter();
    }
}
