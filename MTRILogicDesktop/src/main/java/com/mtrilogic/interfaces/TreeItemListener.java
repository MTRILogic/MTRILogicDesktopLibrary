package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.ExpandableModel;
import com.mtrilogic.adapters.TreeAdapter;
import com.mtrilogic.classes.DefaultTree;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TreeItemListener<EM extends ExpandableModel> {

    void onTreeItemClick(@NotNull MouseEvent event, EM model, int row);

    @NotNull DefaultTree<EM> getDefaultTree();

    @NotNull TreeAdapter<EM> getAdapter();
}
