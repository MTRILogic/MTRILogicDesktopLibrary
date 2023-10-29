package com.mtrilogic.abstracts;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public abstract class Page extends Model{

    private String title;

    public Page(){
        super();
        title = "Page" + id;
    }

    public Page(String title){
        super();
        this.title = title;
    }

    public final void setTitle(@NotNull String title) {
        this.title = title;
    }

    public final String getTitle() {
        return title;
    }
}
