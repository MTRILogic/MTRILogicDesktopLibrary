package com.mtrilogic.abstracts;

import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;
import com.mtrilogic.interfaces.ComboBoxItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ComboBoxItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    private final ComboBoxItemListener<M> listener;
    private final DefaultListCellRenderer renderer;

    protected abstract boolean onComboBoxItemRenderer(DefaultComboBox<M> list, M model, int index, boolean isSelected, boolean cellHasFocus);

    public ComboBoxItem(@NotNull ComboBoxItemListener<M> listener) {
        this(null, listener);
    }

    public ComboBoxItem(DefaultListCellRenderer renderer, @NotNull ComboBoxItemListener<M> listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        listener.getDefaultComboBox().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                int index = getDefaultComboBox().getSelectedIndex();
                M model = getAdapter().getElementAt(index);
                listener.onComboBoxItemClick(event, model, index);
            }
        });
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onComboBoxItemRenderer(getDefaultComboBox(), model, index, isSelected, cellHasFocus)) {
            return renderer.getListCellRendererComponent(list, model, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    protected DefaultComboBox<M> getDefaultComboBox(){
        return listener.getDefaultComboBox();
    }

    protected ComboBoxAdapter<M> getAdapter(){
        return listener.getAdapter();
    }
}
