package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;

import javax.swing.*;
import java.util.Vector;

@SuppressWarnings("unused")
public class ComboBoxAdapter<M extends Model> extends DefaultComboBoxModel<M> {

    private final Class<M> clazz;

    public ComboBoxAdapter(Class<M> clazz) {
        super();
        this.clazz = clazz;
    }

    public ComboBoxAdapter(M[] items, Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    public ComboBoxAdapter(Vector<M> items, Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    @Override
    public M getSelectedItem() {
        return clazz.cast(super.getSelectedItem());
    }
}
