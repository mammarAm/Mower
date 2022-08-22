package com.sonepar.mownow.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrientationTest {

    @ParameterizedTest
    @CsvSource({"EAST, NORTH", "NORTH, WEST", "WEST, SOUTH", "SOUTH, EAST"})
    void leftTest(final Orientation before, final Orientation after) {
        assertEquals(after, before.left());
    }


    @ParameterizedTest
    @CsvSource({"EAST, SOUTH", "SOUTH, WEST", "WEST, NORTH", "NORTH, EAST"})
    void rightTest(final Orientation before, final Orientation after) {
        assertEquals(after, before.right());
    }

    @ParameterizedTest
    @CsvSource({"1, NORTH", "2, EAST", "3, SOUTH", "4, WEST"})
    void getByValueTest(final int value, final Orientation orientation) {
        assertEquals(Optional.of(orientation), Orientation.getByValue(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 5, 500})
    void getByValueEmptyTest(final int value) {
        assertEquals(Optional.empty(), Orientation.getByValue(value));
    }

    @ParameterizedTest
    @CsvSource({"N, NORTH", "E, EAST", "S, SOUTH", "W, WEST"})
    void getByCodeTest(final String code, final Orientation orientation) {
        assertEquals(Optional.of(orientation), Orientation.getByCode(code));
    }

    @ParameterizedTest
    @ValueSource(strings= {" NORTH", "test", " ", ""})
    void getByCodeEmptyTest(final String code) {
        assertEquals(Optional.empty(), Orientation.getByCode(code));
    }
}
