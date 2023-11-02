package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ComboBoxItemListener<M extends Model> {

    void onComboBoxItemClick(@NotNull MouseEvent event, M model, int index);

    @NotNull DefaultComboBox<M> getDefaultComboBox();

    @NotNull ComboBoxAdapter<M> getAdapter();
}
