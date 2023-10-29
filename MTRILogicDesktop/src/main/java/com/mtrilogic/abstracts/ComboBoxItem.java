package com.mtrilogic.abstracts;

import com.mtrilogic.interfaces.ComboBoxItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ComboBoxItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final DefaultListCellRenderer renderer;
    protected final ComboBoxItemListener listener;

    protected abstract boolean onComboBoxItemRenderer(JList<? extends Model> list, M value, int index, boolean isSelected, boolean cellHasFocus);

    public ComboBoxItem(@NotNull ComboBoxItemListener listener) {
        this(null, listener);
    }

    public ComboBoxItem(DefaultListCellRenderer renderer, @NotNull ComboBoxItemListener listener) {
        if (renderer == null) {
            renderer = new DefaultListCellRenderer();
        }
        this.renderer = renderer;
        this.listener = listener;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                listener.onItemClick(e);
            }
        });
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M value, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onComboBoxItemRenderer(list, value, index, isSelected, cellHasFocus)) {
            return renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }
}
