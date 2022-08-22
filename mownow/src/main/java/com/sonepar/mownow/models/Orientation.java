package com.sonepar.mownow.models;

import java.util.List;
import java.util.Optional;

public enum Orientation {

    NORTH("N", 1, 1, "Y"),
    EAST("E", 2, 1, "X"),
    SOUTH("S", 3, -1, "Y"),
    WEST("W", 4, -1, "X");
    String code;
    int value;
    String position;
    int weight;

    Orientation(String code, int value, int weight, String position) {
        this.code = code;
        this.value = value;
        this.weight = weight;
        this.position = position;
    }

    public static Optional<Orientation> getByValue(int value) {
        List<Orientation> values = List.of(values());
        return values.stream()
                .filter(Orientation -> Orientation.value == value)
                .findFirst();
    }

    public static Optional<Orientation> getByCode(String code) {
        List<Orientation> values = List.of(values());
        return values.stream()
                .filter(Orientation -> Orientation.code.equals(code))
                .findFirst();
    }

    public int getWeight() {
        return weight;
    }

    public Orientation left() {
        int value = Math.abs(this.value - 1);
        return getByValue(value == 0 ? 4 : value)
                .orElse(this);
    }

    public Orientation right() {
        int value = (this.value + 1);
        return getByValue(value == 5 ? 1 : value)
                .orElse(this);
    }


    public String getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return code;
    }
}
