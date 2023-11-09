package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ComboBoxItem;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultComboBox<M extends Model> extends JComboBox<M> {

    private final Class<M> clazz;

    public DefaultComboBox(@NotNull ComboBoxAdapter<M> adapter, @NotNull Class<M> clazz) {
        super(adapter);
        this.clazz = clazz;
    }

    public DefaultComboBox(@NotNull M[] items, @NotNull Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    public DefaultComboBox(@NotNull Vector<M> items, @NotNull Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    public DefaultComboBox(@NotNull Class<M> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public M getSelectedItem() {
        return clazz.cast(super.getSelectedItem());
    }

    public ComboBoxAdapter<M> getAdapter(){
        return (ComboBoxAdapter<M>) getModel();
    }

    public void setAdapter(@NotNull ComboBoxAdapter<M> adapter){
        setModel(adapter);
    }

    public ComboBoxItem<M> getItem(Class<ComboBoxItem<M>> clazz){
        return clazz.cast(getRenderer());
    }

    public void setItem(@NotNull ComboBoxItem<M> item){
        setRenderer(item);
    }
}
