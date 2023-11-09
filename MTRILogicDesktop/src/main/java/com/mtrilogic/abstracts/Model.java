package com.mtrilogic.abstracts;

@SuppressWarnings("unused")
public abstract class Model {

    private static long idx;

    protected final long id;
    private final int type;

    public Model(){
        this(0);
    }

    public Model(int type) {
        this.type = type;
        this.id = idx++;
    }

    public int getType() {
        return type;
    }

    public final long getId() {
        return id;
    }
}
