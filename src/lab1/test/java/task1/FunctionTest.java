package task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static task1.Function.arctg;

public class FunctionTest {
    private final double eps = 1e-6;

    static Stream<Arguments> provideDataForArctg() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(sqrt(3) / 3, PI / 6),
                Arguments.of(1, PI / 4));
    }


    @ParameterizedTest
    @ValueSource(doubles = {PI, -PI, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, -1.0 - 1e-15, 1.0 + 1e-15})
    void testArctgInvalidInput(Double x) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> arctg(x));
        assertThat(exception.getMessage()).isEqualTo("invalid X value");
    }

    @ParameterizedTest
    @MethodSource("provideDataForArctg")
    void testArctgPositiveArg(double x, double excepted) {
        assertEquals(excepted, arctg(x), eps);
    }

    @ParameterizedTest
    @MethodSource("provideDataForArctg")
    void testArctgNegative(double x, double excepted) {
        assertEquals(-excepted, arctg(-x), eps);
    }


}
