package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.ListAdapter;
import com.mtrilogic.classes.DefaultList;
import com.mtrilogic.interfaces.ListItemListener;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ListItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    private final DefaultListCellRenderer renderer;
    private final ListItemListener<M> listener;

    protected abstract boolean onListItemRenderer(DefaultList<M> list, M model, int index, boolean isSelected, boolean cellHasFocus);

    public ListItem(ListItemListener<M> listener){
        this(null, listener);
    }

    public ListItem(DefaultListCellRenderer renderer, ListItemListener<M> listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        addMouseListener();
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

    protected void addMouseListener() {
        DefaultList<M> list = getDefaultList();
        list.addMouseListener(new MouseAdapter() {
            @Override
            // Ver NOTA en el método locationToIndex de la clase DefaultList
            public void mouseClicked(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                if (index >= 0) {
                    M model = getAdapter().getElementAt(index);
                    listener.onListItemClick(e, model, index);
                } /*/else {
                    if (!e.isShiftDown() && !isMenuShortcutKeyDown(e)) {
                        list.clearSelection();
                    }
                }*/
            }
        });
    }

    /*/private boolean isMenuShortcutKeyDown(InputEvent event) {
        return (event.getModifiersEx() & Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()) != 0;
    }*/
}
