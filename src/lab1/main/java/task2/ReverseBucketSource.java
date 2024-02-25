package task2;

import java.util.List;

public class ReverseBucketSource {
    private final int numberOfElements;
    private final int maxArrayValue;
    private final int[] elements;

    private final List<List<Integer>> buckets;

    public ReverseBucketSource(List<List<Integer>> buckets) {
        if (buckets == null || buckets.isEmpty()) {
            throw new IllegalArgumentException("invalid input buckets size");
        }
        this.buckets = buckets;
        this.numberOfElements = buckets.size();
        this.elements = new int[numberOfElements];
        this.maxArrayValue = buckets.stream().mapToInt(list -> list.stream().mapToInt(Integer::intValue).max().orElse(Integer.MIN_VALUE)).max().getAsInt();
    }

    private int hash(int value) {
        return (int) ((double) value / (maxArrayValue + 1) * numberOfElements);
    }

    private List<Integer> delete(int index, int value) {
        List<Integer> buckerList = buckets.get(index);
        if (buckerList.isEmpty()) {
            buckerList.add(value);
        } else {
            buckerList.remove(value);
        }
        return buckerList;
    }


    public int[] reverseBucketSort() {
        int i = 0;
        for (List<Integer> list : buckets) {
            for (Integer value : list) {
                int index = hash(value);
                buckets.set(index, delete(index, value));
                elements[i] = value;
                i++;
            }
        }
        return elements;
    }
}
