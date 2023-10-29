package com.mtrilogic.abstracts;

import com.mtrilogic.interfaces.ListItemListener;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public abstract class ListItem<M extends Model> extends SpringPanel implements ListCellRenderer<M> {

    protected final DefaultListCellRenderer renderer;
    protected final ListItemListener listener;

    /**
     * Generates a SpringPanel based on the given parameters
     *
     * @param  list            the JList of the model
     * @param  value           the value of the model
     * @param  index           the index of the model
     * @param  isSelected     indicates if the cell is selected
     * @param  cellHasFocus    indicates if the cell has focus
     * @return                 the generated SpringPanel based on the given parameters
     */
    protected abstract boolean onListItemRenderer(JList<? extends Model> list, M value, int index, boolean isSelected, boolean cellHasFocus);

    public ListItem(@NotNull ListItemListener listener){
        this(null, listener);
    }

    public ListItem(DefaultListCellRenderer renderer, @NotNull ListItemListener listener) {
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
        if (!onListItemRenderer(list, value, index, isSelected, cellHasFocus)){
            return renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        } else {
            return this;
        }
    }

    /**
     * Prints the given string as a line
     *
     * @param  line  The string to be printed as a line.
     */
    protected void printLine(@NotNull String line){
        listener.onPrintLine(line);
    }
}
