package com.sonepar.mownow.models;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position addX(int orientationWeight, int limit) {
        this.x = x + orientationWeight;
        if (this.x > limit) {
            this.x = limit;
        } else if (this.x == -1) {
            this.x = 0;
        }
        return this;
    }

    public Position addY(int orientationWeight, int limit) {
        this.y = y + orientationWeight;
        if (this.y > limit) {
            this.y = limit;
        } else if (this.y == -1) {
            this.y = 0;
        }
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
