package com.mtrilogic.abstracts;

@SuppressWarnings("unused")
public abstract class Model {

    private boolean enabled;
    private int type;
    private long id;

    public Model() {}

    public Model(long id, int type, boolean enabled){
        this.enabled = enabled;
        this.type = type;
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public int getType() {
        return type;
    }

    public final long getId() {
        return id;
    }
}
