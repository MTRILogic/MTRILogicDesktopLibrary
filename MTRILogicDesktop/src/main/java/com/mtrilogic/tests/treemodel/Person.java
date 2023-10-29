package com.mtrilogic.tests.treemodel;

import com.mtrilogic.abstracts.ExpandableModel;

@SuppressWarnings("unused")
public class Person extends ExpandableModel {/*  ww  w . j a v  a2s  . com*/
    private Person father;
    //private Person mother;
    private final String name;

    public Person(String name) {
        super();
        this.name = name;
        //father = mother = null;
    }

    public static void linkFamily(Person pa, Person ma, Person[] kids) {
        for (Person kid : kids) {
            pa.getNode().add(kid);
            //ma.getNode().add(kid);
            kid.father = pa;
            //kid.mother = ma;
        }
        System.out.println("PA: " + pa.node + " MA: " + ma.node);
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public Person getFather() {
        return father;
    }

    /*/public Person getMother() {
        return mother;
    }*/

    public int getIndexOfChild(Person kid) {
        return node.getIndex(kid);
    }
}
