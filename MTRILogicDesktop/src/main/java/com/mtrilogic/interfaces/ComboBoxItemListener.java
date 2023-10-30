package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.ComboBoxItem;
import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ComboBoxAdapter;
import com.mtrilogic.classes.DefaultComboBox;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ComboBoxItemListener<M extends Model> extends OnPrintLineListener {

    void onComboBoxItemClick(@NotNull MouseEvent event, @NotNull ComboBoxItem<M> item);

    @NotNull DefaultComboBox<M> getDefaultComboBox();

    @NotNull ComboBoxAdapter<M> getAdapter();
}
