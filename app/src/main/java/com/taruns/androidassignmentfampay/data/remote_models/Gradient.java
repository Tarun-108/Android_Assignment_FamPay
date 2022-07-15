package com.taruns.androidassignmentfampay.data.remote_models;

import java.util.List;

public class Gradient {

    private List<String> colors;
    private int angle;

    public Gradient(List<String> colors ){
        this.colors = colors;
        angle = 0;
    }
    public Gradient(List<String> colors, int angle ){
        this.colors = colors;
        this.angle = angle;
    }

    public List<String> getColors() {
        return colors;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

}