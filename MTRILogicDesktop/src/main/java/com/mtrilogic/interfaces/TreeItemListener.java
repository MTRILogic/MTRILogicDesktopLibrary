package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.NodeModel;
import com.mtrilogic.adapters.TreeAdapter;
import com.mtrilogic.classes.DefaultTree;
import org.jetbrains.annotations.NotNull;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TreeItemListener<NM extends NodeModel> {

    void onTreeItemClick(@NotNull MouseEvent event, NM model, int row);

    @NotNull DefaultTree<NM> getDefaultTree();

    @NotNull TreeAdapter<NM> getAdapter();
}
