package com.mtrilogic.abstracts;

import com.mtrilogic.classes.DefaultComboBox;
import com.mtrilogic.interfaces.ComboBoxItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ComboBoxItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final ComboBoxItemListener<M> listener;

    private final DefaultListCellRenderer renderer;

    private boolean cellHasFocus;
    private boolean isSelected;
    private int index;
    private M model;

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
            public void mouseClicked(MouseEvent e) {
                itemClick(e);
            }
        });
    }

    @Override
    public final Component getListCellRendererComponent(JList<? extends M> list, M model, int index, boolean isSelected, boolean cellHasFocus) {
        if (!onComboBoxItemRenderer(listener.getDefaultComboBox(), (this.model = model), (this.index = index), (this.isSelected = isSelected), (this.cellHasFocus = cellHasFocus))) {
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

    public int getIndex() {
        return index;
    }

    public M getModel() {
        return model;
    }

    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }

    private void itemClick(@NotNull MouseEvent event){
        listener.onComboBoxItemClick(event, this);
    }
}
