package com.mtrilogic.classes;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ListAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
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
}
