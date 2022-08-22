package com.sonepar.mownow.models;


import java.util.List;

public class Mower {

    public static final String ORIENT_A = "A";
    public static final String ORIENT_D = "D";
    public static final String ORIENT_G = "G";
    public static final String SEPARATOR_BLANK = " ";
    public static final String SEPARATOR_EMPTY = "";
    private final String instructionsLine;
    private final Position upperCorner;
    private Position position;
    private Orientation orientation;

    public Mower(String upperCornerLine, String informationLine, String instructionsLine) {

        this.upperCorner = buildPosition(checksLine(upperCornerLine, 2));
        this.position = buildPosition(checksLine(informationLine, 3));
        this.orientation = buildOrientation(checksLine(informationLine, 3));
        this.instructionsLine = instructionsLine;
    }

    public Mower orient() {
        List.of(instructionsLine.split(SEPARATOR_EMPTY))
                .forEach(this::orient);
        return this;
    }

    private void orient(String direction) {
        switch (direction) {
            case ORIENT_A -> this.position = this.advance();
            case ORIENT_G -> this.orientation = this.orientation.left();
            case ORIENT_D -> this.orientation = this.orientation.right();
        }
    }

    private Position advance() {
        return switch (orientation.getPosition()) {
            case "X" -> this.position.addX(orientation.getWeight(), upperCorner.getX());
            case "Y" -> this.position.addY(orientation.getWeight(), upperCorner.getY());
            default -> this.position;
        };

    }

    private Orientation buildOrientation(String[] split) {
        return Orientation.getByCode(split[2])
                .orElseThrow(() -> new IllegalArgumentException("error to parse a file"));
    }

    static String[] checksLine(String line, int length) {
        String[] split = line.split(SEPARATOR_BLANK);
        if (split.length != length) {
            throw new IllegalArgumentException("error to parse a file");
        }
        return split;
    }

    static Position buildPosition(String[] positions) {
        int x = Integer.parseInt(positions[0]);
        int y = Integer.parseInt(positions[1]);
        return new Position(x, y);
    }

    @Override
    public String toString() {
        return position + " " + orientation;
    }
}
