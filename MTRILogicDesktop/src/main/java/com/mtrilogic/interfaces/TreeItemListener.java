package com.mtrilogic.interfaces;

import com.mtrilogic.abstracts.NodeModel;
import com.mtrilogic.adapters.TreeAdapter;
import com.mtrilogic.classes.DefaultTree;

import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public interface TreeItemListener<NM extends NodeModel> {

    void onTreeItemClick(MouseEvent event, NM model, int row);

    DefaultTree<NM> getDefaultTree();

    TreeAdapter<NM> getAdapter();
}
