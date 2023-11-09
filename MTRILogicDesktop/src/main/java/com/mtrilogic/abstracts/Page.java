package com.mtrilogic.abstracts;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public abstract class Page extends Model{

    private String title, tag;

    public Page(int type){
        super(type);
        title = "Page " + id;
        tag = "page:" + ":" + type + ":" + id;
    }

    public Page(int type, String title, String tag){
        super(type);
        this.title = title;
        this.tag = tag;
    }

    public final void setTitle(@NotNull String title) {
        this.title = title;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTag(@NotNull String tag) {
        this.tag = tag;
    }

    public final String getTag() {
        return tag;
    }
}
