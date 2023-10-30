package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.ExpandableModel;
import com.mtrilogic.abstracts.TreeItem;
import com.mtrilogic.adapters.TreeAdapter;
import com.mtrilogic.classes.DefaultTree;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TreeItemListener<EM extends ExpandableModel> extends OnPrintLineListener {

    void onTreeItemClick(@NotNull MouseEvent event, @NotNull TreeItem<EM> item);

    @NotNull DefaultTree<EM> getDefaultTree();

    @NotNull TreeAdapter<EM> getAdapter();
}
