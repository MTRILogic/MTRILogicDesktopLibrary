package com.mtrilogic.tests.treemodel;

import com.mtrilogic.classes.DefaultTree;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class FamilyTree extends DefaultTree<Person> {

    public FamilyTree(Person graphNode) {
        super(new FamilyAdapter(graphNode));
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }

    public void showAncestor(boolean b) {
        Object newRoot = null;
        TreePath path = getSelectionModel().getSelectionPath();
        if (path != null) {
            newRoot = path.getLastPathComponent();
        }
        ((FamilyAdapter) getModel()).showAncestor(b, newRoot);
    }
}
