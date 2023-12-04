package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.ListAdapter;
import com.mtrilogic.classes.DefaultList;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface ListItemListener<M extends Model> {

    void onListItemClick(MouseEvent event, M model, int index);

    DefaultList<M> getDefaultList();

    ListAdapter<M> getAdapter();
}
