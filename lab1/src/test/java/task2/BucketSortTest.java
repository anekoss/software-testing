package task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BucketSortTest {


    @Test
    public void testNullInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BucketSort(null).bucketSort());
        assertThat(exception.getMessage()).isEqualTo("invalid input array size");
    }

    @Test
    public void testEmptyInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BucketSort(new int[0]).bucketSort());
        assertThat(exception.getMessage()).isEqualTo("invalid input array size");
    }

    @ParameterizedTest
    @MethodSource("provideReferenceDataForBucketSort")
    void testBucketSort(int[] elements, List<List<Integer>> excepted) {
        assertThat(new BucketSort(elements).bucketSort()).isEqualTo(excepted);
    }


    @ParameterizedTest
    @MethodSource("provideDataForBucketSort")
    void testCleanBucketSort(int[] elements, List<List<Integer>> excepted) {
        BucketSort bucketSort = new BucketSort(elements);
        assertThat(bucketSort.bucketSort()).isEqualTo(excepted);
        List<List<Integer>> buckets = bucketSort.cleanBucketSort();
        for (List<Integer> list : buckets) {
            assertThat(list).isEmpty();
        }
    }


    static Stream<Arguments> provideDataForBucketSort() {
        return Stream.of(
                Arguments.of(
                        new int[]{743, 696, 748, 601, 766, 954, 249, 298, 471, 207, 234, 726, 87, 533, 702, 13, 820, 3,
                                389, 856, 289, 199, 69, 727, 445, 663, 720, 44, 761, 162},
                        List.of(List.of(3, 13), List.of(44), List.of(69, 87), List.of(), List.of(), List.of(162), List.of(199, 207),
                                List.of(234, 249), List.of(), List.of(289, 298), List.of(), List.of(), List.of(389),
                                List.of(445), List.of(471), List.of(), List.of(533), List.of(), List.of(601), List.of(), List.of(663),
                                List.of(696), List.of(702, 720, 726, 727), List.of(743, 748, 761), List.of(766), List.of(820), List.of(856), List.of(), List.of(), List.of(954))));
    }

    static Stream<Arguments> provideReferenceDataForBucketSort() {
        return Stream.of(
                Arguments.of(
                        new int[]{743, 696, 748, 601, 766, 954, 249, 298, 471, 207, 234, 726, 87, 533, 702, 13, 820, 3,
                                389, 856, 289, 199, 69, 727, 445, 663, 720, 44, 761, 162},

                        List.of(List.of(3, 13), List.of(44), List.of(69, 87), List.of(), List.of(162), List.of(199),
                                List.of(207), List.of(234, 249), List.of(289, 298), List.of(), List.of(), List.of(389),
                                List.of(), List.of(445), List.of(471), List.of(533), List.of(601), List.of(663),
                                List.of(696), List.of(702, 720, 726, 727), List.of(743, 748, 761, 766), List.of(), List.of(820), List.of(856), List.of(), List.of(), List.of(954), List.of())));
    }
}
