package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Math.E;
import static java.lang.Math.exp;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LnFunctionTest {

    private static final double PRECISION = 0.00001;

    private final LnFunction lnFunction = new LnFunction();

    private static Stream<Arguments> provideArgsForLn() {
        return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(E, 1),
                Arguments.of(exp(1.5), 1.5),
                Arguments.of(exp(2), 2),
                Arguments.of(exp(-1), -1),
                Arguments.of(exp(-2), -2),
                Arguments.of(exp(-4), -4),
                Arguments.of(exp(3), 3),
                Arguments.of(-0.01, Double.NaN),
                Arguments.of(-3, Double.NaN)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForLn")
    void positiveArgsTest(double x, double expected) {

        assertEquals(expected, lnFunction.calculate(x), PRECISION);
    }

    @Test
    void specialValuesTest() {
        assertEquals(Double.NaN, lnFunction.calculate(Double.NaN));
        assertEquals(Double.POSITIVE_INFINITY, lnFunction.calculate(Double.POSITIVE_INFINITY));
        assertEquals(Double.POSITIVE_INFINITY, lnFunction.calculate(Double.NEGATIVE_INFINITY));
        assertEquals(Double.NEGATIVE_INFINITY, lnFunction.calculate(0));
    }
}
