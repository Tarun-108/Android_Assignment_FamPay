package com.taruns.androidassignmentfampay.data.remote_models;

import java.util.List;

public class CardGroup {

    int id;
    boolean is_scrollable;
    String name, design_type;
    List<Card> cards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIs_scrollable() {
        return is_scrollable;
    }

    public void setIs_scrollable(boolean is_scrollable) {
        this.is_scrollable = is_scrollable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesign_type() {
        return design_type;
    }

    public void setDesign_type(String design_type) {
        this.design_type = design_type;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }


}
