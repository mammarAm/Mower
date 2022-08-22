package com.sonepar.mownow.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @ParameterizedTest
    @MethodSource("providePositionsX")
    void addXTest(final Position before, final Position after, final int weight) {
        assertEquals(after, before.addX(weight, 5));
    }

    @ParameterizedTest
    @MethodSource("providePositionsY")
    void addYTest(final Position before, final Position after, final int weight) {
        assertEquals(after, before.addY(weight, 5));
    }

    private static Stream<Arguments> providePositionsX() {
        return Stream.of(
                Arguments.of(new Position(1, 3), new Position(2, 3), 1),
                Arguments.of(new Position(1, 3), new Position(0, 3), -1),
                Arguments.of(new Position(0, 3), new Position(0, 3), -1),
                Arguments.of(new Position(5, 3), new Position(5, 3), 1),
                Arguments.of(new Position(4, 3), new Position(5, 3), 1)
        );
    }
        private static Stream<Arguments> providePositionsY() {
            return Stream.of(
                    Arguments.of(new Position(3,1), new Position(3,2) ,1),
                    Arguments.of(new Position(3,1), new Position(3,0) ,-1),
                    Arguments.of(new Position(3,0), new Position(3,0) ,-1),
                    Arguments.of(new Position(3,5), new Position(3,5) ,1),
                    Arguments.of(new Position(3,4), new Position(3,5) ,1)
            );
    }

}
