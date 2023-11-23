package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ListItem;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ListAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultList<M extends Model> extends JList<M> {

    public DefaultList(@NotNull ListAdapter<M> adapter) {
        super(adapter);
    }

    public DefaultList(@NotNull M[] items) {
        super(items);
    }

    public DefaultList(@NotNull Vector<M> items) {
        super(items);
    }

    public DefaultList() {
        super();
    }

    public ListAdapter<M> getAdapter(){
        return (ListAdapter<M>) getModel();
    }

    public void setAdapter(@NotNull ListAdapter<M> adapter){
        setModel(adapter);
    }

    public ListItem<M> getItem(Class<ListItem<M>> clazz){
        return clazz.cast(getCellRenderer());
    }

    public void setItem(@NotNull ListItem<M> item){
        setCellRenderer(item);
    }

    // NOTA: Ayuda a evitar que el último item se seleccione cuando se da click a un espacio en blanco
    // https://stackoverflow.com/questions/11138665/how-to-prevent-jlist-from-making-selection-outside-cell-bounds
    @Override
    public int locationToIndex(Point location) {
        int index = super.locationToIndex(location);
        if (index != -1 && !getCellBounds(index, index).contains(location)) {
            return -1;
        }
        else {
            return index;
        }
    }
}
