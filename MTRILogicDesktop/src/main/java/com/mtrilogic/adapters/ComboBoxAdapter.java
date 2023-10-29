package com.mtrilogic.adapters;

import com.mtrilogic.abstracts.Model;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Vector;

@SuppressWarnings("unused")
public class ComboBoxAdapter<M extends Model> extends DefaultComboBoxModel<M> {

    private final Class<M> clazz;

    public ComboBoxAdapter(@NotNull Class<M> clazz) {
        super();
        this.clazz = clazz;
    }

    public ComboBoxAdapter(@NotNull M[] items, @NotNull Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    public ComboBoxAdapter(@NotNull Vector<M> items, @NotNull Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    @Override
    public M getSelectedItem() {
        return clazz.cast(super.getSelectedItem());
    }
}
