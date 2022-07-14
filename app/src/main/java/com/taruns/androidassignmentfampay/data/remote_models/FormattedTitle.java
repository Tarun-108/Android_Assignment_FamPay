package com.taruns.androidassignmentfampay.data.remote_models;

import java.util.List;


public class FormattedTitle {
    private String text;
    private String align;
    private List<Entities> entities;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public List<Entities> getEntities() {
        return entities;
    }

    public void setEntities(List<Entities> entities) {
        this.entities = entities;
    }
}