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

public class PeopleTest {

    @Test
    void testPeopleCreateWithNullInvents() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new People(null));
        assertThat(exception.getMessage()).isEqualTo("invents can't be null");
    }

    @Test
    void testPeopleThink() {
        People People = new People(new HashSet<>());
        assertThat(People.think()).isEqualTo("мы разумнее дельфинов!");
    }


//    static Stream<Arguments> provideDataForAddInvent() {
//        return Stream.of(
//                Arguments.of(List.of(FUN, SWIMMING, HAPPINESS), 3), Arguments.of(List.of(HAPPINESS, SWIMMING, HAPPINESS, FUN), 3));
//    }

    static Stream<Arguments> provideDataForAddInvent() {
        return Stream.of(
                Arguments.of(List.of(NEW_YORK, WHEEL, WAR), 3), Arguments.of(List.of(NEW_YORK, NEW_YORK, WHEEL, WAR), 3));
    }


    @ParameterizedTest
    @MethodSource("provideDataForAddInvent")
    void testAddInvent(List<Invent> inventList, int exceptedCount) {
        Set<Invent> invents = new HashSet<>();
        People People = new People(invents);
        for (Invent invent : inventList) {
            People.addInvent(invent);
        }
        assertThat(invents.size()).isEqualTo(exceptedCount);
    }

    @ParameterizedTest
    @MethodSource("provideDataForAddInvent")
    void testGetInvents(List<Invent> inventList) {
        Set<Invent> invents = new HashSet<>(inventList);
        People People = new People(invents);
        assertThat(People.invents()).isEqualTo(invents);

    }


    @ParameterizedTest
    @MethodSource("provideDataForAddInvent")
    void testIsGoodInvent(List<Invent> inventList) {
        People People = new People(new HashSet<>(inventList));
        assertThat(People.isGoodInvent(FUN)).isEqualTo(false);
        assertThat(People.isGoodInvent(WAR)).isEqualTo(true);
    }


}
