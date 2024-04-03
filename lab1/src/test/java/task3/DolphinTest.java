package task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static task3.Invent.*;

public class DolphinTest {

    @Test
    void testDolphinCreateWithNullInvents() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Dolphin(null));
        assertThat(exception.getMessage()).isEqualTo("invents can't be null");
    }

    @Test
    void testDolphinThink() {
        Dolphin dolphin = new Dolphin(new HashSet<>());
        assertThat(dolphin.think()).isEqualTo("мы разумнее людей!");
    }


    static Stream<Arguments> provideDataForAddInvent() {
        return Stream.of(
                Arguments.of(List.of(FUN, SWIMMING, HAPPINESS), 3), Arguments.of(List.of(HAPPINESS, SWIMMING, HAPPINESS, FUN), 3));
    }

    @ParameterizedTest
    @MethodSource("provideDataForAddInvent")
    void testAddInvent(List<Invent> inventList, int exceptedCount) {
        Set<Invent> invents = new HashSet<>();
        Dolphin dolphin = new Dolphin(invents);
        for (Invent invent : inventList) {
            dolphin.addInvent(invent);
        }
        assertThat(invents.size()).isEqualTo(exceptedCount);
    }

    @ParameterizedTest
    @MethodSource("provideDataForAddInvent")
    void testGetInvents(List<Invent> inventList) {
        Set<Invent> invents = new HashSet<>(inventList);
        Dolphin dolphin = new Dolphin(invents);
        assertThat(dolphin.invents()).isEqualTo(invents);

    }


    @ParameterizedTest
    @MethodSource("provideDataForAddInvent")
    void testIsGoodInvent(List<Invent> inventList) {
        Dolphin dolphin = new Dolphin(new HashSet<>(inventList));
        assertThat(dolphin.isGoodInvent(FUN)).isEqualTo(true);
        assertThat(dolphin.isGoodInvent(WAR)).isEqualTo(false);
    }


}
