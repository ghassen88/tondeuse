package com.tondeuse.model;


public class Lawn {
    private final int maxX;
    private final int maxY;

    public Lawn(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}