package com.taruns.androidassignmentfampay.data.remote_models;

import java.util.List;

public class FormattedDescription {

    private String text;
    private List<Entities> entities;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Entities> getEntities() {
        return entities;
    }

    public void setEntities(List<Entities> entities) {
        this.entities = entities;
    }

}
