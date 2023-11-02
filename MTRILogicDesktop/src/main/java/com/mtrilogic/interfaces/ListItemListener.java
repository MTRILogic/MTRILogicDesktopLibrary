package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ListAdapter;
import com.mtrilogic.classes.DefaultList;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ListItemListener<M extends Model> {

    void onListItemClick(@NotNull MouseEvent event, M model, int index);

    @NotNull DefaultList<M> getDefaultList();

    @NotNull ListAdapter<M> getAdapter();
}
