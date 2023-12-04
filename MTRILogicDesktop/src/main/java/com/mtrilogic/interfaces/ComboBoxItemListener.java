package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ComboBoxItemListener<M extends Model> {

    void onComboBoxItemClick(MouseEvent event, M model, int index);

    DefaultComboBox<M> getDefaultComboBox();

    ComboBoxAdapter<M> getAdapter();
}
