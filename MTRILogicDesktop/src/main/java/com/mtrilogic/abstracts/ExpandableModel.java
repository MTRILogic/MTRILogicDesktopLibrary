package com.mtrilogic.abstracts;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;

@SuppressWarnings("unused")
public abstract class ExpandableModel extends Model implements MutableTreeNode {

    protected final DefaultMutableTreeNode node;

    public ExpandableModel() {
        super();
        node = new DefaultMutableTreeNode();
    }

    public ExpandableModel(DefaultMutableTreeNode node) {
        super();
        this.node = node;
    }

    @Override
    public final void insert(MutableTreeNode child, int index) {
        node.insert(child, index);
    }

    @Override
    public final void remove(int index) {
        node.remove(index);
    }

    @Override
    public final void remove(MutableTreeNode node) {
        this.node.remove(node);
    }

    @Override
    public final void setUserObject(Object object) {
        node.setUserObject(object);
    }

    @Override
    public final void removeFromParent() {
        node.removeFromParent();
    }

    @Override
    public final void setParent(MutableTreeNode newParent) {
        node.setParent(newParent);
    }

    @Override
    public final TreeNode getChildAt(int childIndex) {
        return node.getChildAt(childIndex);
    }

    @Override
    public final int getChildCount() {
        return node.getChildCount();
    }

    @Override
    public final TreeNode getParent() {
        return node.getParent();
    }

    @Override
    public final int getIndex(TreeNode node) {
        return node.getIndex(node);
    }

    @Override
    public final boolean getAllowsChildren() {
        return node.getAllowsChildren();
    }

    @Override
    public final boolean isLeaf() {
        return node.isLeaf();
    }

    @Override
    public final Enumeration<? extends TreeNode> children() {
        return node.children();
    }

    public DefaultMutableTreeNode getNode() {
        return node;
    }
}
