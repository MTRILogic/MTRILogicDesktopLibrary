package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.Model;
import com.mtrilogic.abstracts.TableItem;
import com.mtrilogic.adapters.TableAdapter;
import com.mtrilogic.classes.DefaultTable;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TableItemListener<M extends Model> extends OnPrintLineListener {

    void onTableItemClick(@NotNull MouseEvent event, @NotNull TableItem<M> item);

    @NotNull DefaultTable<M> getDefaultTable();

    @NotNull TableAdapter<M> getAdapter();
}
