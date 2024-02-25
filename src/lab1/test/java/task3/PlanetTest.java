package task3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static task3.Invent.*;

public class PlanetTest {


    @Test
    void testPlanetCreateWithNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet(null, Set.of()));
        assertThat(exception.getMessage()).isEqualTo("planet name can't be null");
    }

    @Test
    void testPlanetCreateWithNullCreatures() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Planet("test", null));
        assertThat(exception.getMessage()).isEqualTo("creatures can't be null");
    }

    @Test
    void testAddNullCreature() {
        Planet planet = new Planet("test", Set.of());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> planet.addCreature(null));
        assertThat(exception.getMessage()).isEqualTo("creature can't be null");
    }

    @Test
    void testRemoveNullCreature() {
        Planet planet = new Planet("test", Set.of());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> planet.removeCreature(null));
        assertThat(exception.getMessage()).isEqualTo("creature can't be null");
    }


    static Stream<Arguments> provideDataForTest() {
        return Stream.of(
                Arguments.of(Set.of(new Dolphin(Set.of(HAPPINESS, SWIMMING)), new Dolphin(Set.of()), new People(Set.of(NEW_YORK)), new People(Set.of(WHEEL, WAR)))));
    }

    @ParameterizedTest
    @MethodSource("provideDataForTest")
    void testGetCreatures(Set<Creature> creatures) {
        Set<Creature> creatureSet = new HashSet<>(creatures);
        Planet planet = new Planet("Земля", creatureSet);
        assertThat(planet.getCreatures()).isEqualTo(creatures);
    }


    @ParameterizedTest
    @MethodSource("provideDataForTest")
    void testAddCorrectCreature(Set<Creature> creatures) {
        Set<Creature> creatureSet = new HashSet<>();
        Planet planet = new Planet("Земля", creatureSet);
        for (Creature creature : creatures) {
            planet.addCreature(creature);
        }
        assertThat(creatureSet.size()).isEqualTo(creatures.size());
        assertThat(creatureSet).isEqualTo(creatures);
    }

    @ParameterizedTest
    @MethodSource(("provideDataForTest"))
    void testRemoveCorrectCreature(Set<Creature> creatures) {
        Set<Creature> creatureSet = new HashSet<>(creatures);
        Planet planet = new Planet("Земля", creatureSet);
        for (Creature creature : creatures) {
            planet.removeCreature(creature);
        }
        assertThat(creatureSet).isEmpty();
    }


    static Stream<Arguments> provideDataForTestConflict() {
        People people = Mockito.mock(People.class);
        when(people.invents()).thenReturn(Set.of());
        Dolphin dolphin = Mockito.mock(Dolphin.class);
        when(dolphin.invents()).thenReturn(Set.of());
        return Stream.of(
                Arguments.of(Set.of(new Dolphin(Set.of(HAPPINESS, SWIMMING)), new Dolphin(Set.of()), new People(Set.of(NEW_YORK)), new People(Set.of(WHEEL, WAR))),
                        Set.of(HAPPINESS, NEW_YORK, SWIMMING), "дельфины правы!"),
                Arguments.of(Set.of(dolphin, new People(Set.of(WAR, WHEEL))), Set.of(HAPPINESS, NEW_YORK, WHEEL), "люди правы!"),
                Arguments.of(Set.of(people, new Dolphin(Set.of(HAPPINESS, SWIMMING)), new Dolphin(Set.of(FUN))), Set.of(FUN, WAR), "дельфины правы!"),
                Arguments.of(Set.of(dolphin, people), Set.of(), "дельфины и люди правы!"));
    }

    @ParameterizedTest
    @MethodSource("provideDataForTestConflict")
    void testConflict(Set<Creature> creatures, Set<Invent> invents, String excepted) {
        Planet planet = new Planet("Земля", creatures);
        assertThat(planet.conflict(invents)).isEqualTo(excepted);
    }

}
