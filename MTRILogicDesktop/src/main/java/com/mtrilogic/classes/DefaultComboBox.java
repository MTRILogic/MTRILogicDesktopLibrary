package com.mtrilogic.classes;

import com.mtrilogic.abstracts.ComboBoxItem;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;

import javax.swing.*;
import java.util.Vector;

@SuppressWarnings("unused")
public class DefaultComboBox<M extends Model> extends JComboBox<M> {

    private final Class<M> clazz;

    public DefaultComboBox(ComboBoxAdapter<M> adapter, Class<M> clazz) {
        super(adapter);
        this.clazz = clazz;
    }

    public DefaultComboBox(M[] items, Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    public DefaultComboBox(Vector<M> items, Class<M> clazz) {
        super(items);
        this.clazz = clazz;
    }

    public DefaultComboBox(Class<M> clazz) {
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

    public void setAdapter(ComboBoxAdapter<M> adapter){
        setModel(adapter);
    }

    public ComboBoxItem<M> getItem(Class<ComboBoxItem<M>> clazz){
        return clazz.cast(getRenderer());
    }

    public void setItem(ComboBoxItem<M> item){
        setRenderer(item);
    }
}
