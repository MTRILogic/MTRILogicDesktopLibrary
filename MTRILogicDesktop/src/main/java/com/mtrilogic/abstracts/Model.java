package com.mtrilogic.abstracts;

@SuppressWarnings("unused")
public abstract class Model {

    private static long idx;

    protected final long id;

    public Model(){
        this.id = idx++;
        System.out.println(id);
    }

    public final long getId() {
        return id;
    }
}
