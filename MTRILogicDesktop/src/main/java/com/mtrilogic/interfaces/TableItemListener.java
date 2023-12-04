package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.adapters.TableAdapter;
import com.mtrilogic.classes.DefaultTable;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TableItemListener<M extends Model> {

    void onTableItemClick(MouseEvent event, M model, int row, int column);

    DefaultTable<M> getDefaultTable();

    TableAdapter<M> getAdapter();
}
