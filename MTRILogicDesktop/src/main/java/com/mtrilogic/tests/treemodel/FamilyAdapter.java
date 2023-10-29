package com.mtrilogic.tests.treemodel;

import com.mtrilogic.adapters.TreeAdapter;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;
import java.util.Vector;

public class FamilyAdapter extends TreeAdapter<Person> {
    private boolean showAncestors;
    private final Vector<TreeModelListener> treeModelListeners = new Vector<>();
    private Person rootPerson;

    public FamilyAdapter(Person root) {
        super(root, Person.class);
        showAncestors = false;
        rootPerson = root;
    }

    public void showAncestor(boolean b, Object newRoot) {
        showAncestors = b;
        Person oldRoot = rootPerson;
        if (newRoot != null) {
            rootPerson = (Person) newRoot;
        }
        fireTreeStructureChanged(oldRoot);
    }

    protected void fireTreeStructureChanged(Person oldRoot) {
        TreeModelEvent e = new TreeModelEvent(this, new Object[] { oldRoot });
        for (TreeModelListener tml : treeModelListeners) {
            tml.treeStructureChanged(e);
        }
    }

    public void addTreeModelListener(TreeModelListener l) {
        treeModelListeners.addElement(l);
    }

    public Person getChild(Object parent, int index) {
        Person p = (Person) parent;
        if (showAncestors) {
            /*/if ((index > 0) && (p.getFather() != null)) {
                return p.getMother();
            }*/
            return p.getFather();
        }
        return (Person) p.getChildAt(index);
    }

    public int getChildCount(Object parent) {
        Person p = (Person) parent;
        if (showAncestors) {
            int count = 0;
            if (p.getFather() != null) {
                count++;
            }
            /*/if (p.getMother() != null) {
                count++;
            }*/
            return count;
        }
        return p.getChildCount();
    }

    public int getIndexOfChild(Object parent, Object child) {
        Person p = (Person) parent;
        if (showAncestors) {
            //int count = 0;
            Person father = p.getFather();
            if (father != null) {
                //count++;
                if (father == child) {
                    return 0;
                }
            }
            /*/if (p.getMother() != child) {
                return count;
            }*/
            return -1;
        }
        return p.getIndexOfChild((Person) child);
    }

    public Person getRoot() {
        return rootPerson;
    }

    public boolean isLeaf(Object node) {
        Person p = (Person) node;
        if (showAncestors) {
            //return ((p.getFather() == null) && (p.getMother() == null));
            return p.getFather() == null;
        }
        return p.getChildCount() == 0;
    }

    public void removeTreeModelListener(TreeModelListener l) {
        treeModelListeners.removeElement(l);
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
        System.out.println("*** valueForPathChanged : " + path + " --> " + newValue);
    }
}