package com.sonepar.mownow.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MowerTest {

    private static Stream<Arguments> providePositions() {
        return Stream.of(
                Arguments.of(new String[]{"1", "3"}, new Position(1, 3)),
                Arguments.of(new String[]{"5", "2"}, new Position(5, 2)),
                Arguments.of(new String[]{"4", "0"}, new Position(4, 0))

        );
    }

    @ParameterizedTest
    @MethodSource("providePositions")
    void buildPositionTest(final String[] line, Position position) {
        assertEquals(position, Mower.buildPosition(line));
    }

    @ParameterizedTest
    @ValueSource(strings = {"23", "1A", "2  4", "2 3 A"})
    void checkLineTest(final String line) {
        assertThrows(IllegalArgumentException.class, () -> Mower.checksLine(line, 2));
    }

}
