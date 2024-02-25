package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    private final int numberOfElements;
    private final int maxArrayValue;
    private final int[] elements;

    private final List<List<Integer>> buckets;

    public BucketSort(int[] elements) {
        if (elements == null || elements.length == 0) {
            throw new IllegalArgumentException("invalid input array size");
        }
        this.elements = elements;
        this.numberOfElements = elements.length;
        this.maxArrayValue = Arrays.stream(elements).max().getAsInt();
        this.buckets = initBuckets(numberOfElements);
    }


    private List<List<Integer>> initBuckets(int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
        return buckets;
    }


    private int hash(int value) {
        return (int) ((double) value / (maxArrayValue + 1) * numberOfElements);
    }

    private List<Integer> insert(int index, int value) {
        List<Integer> buckerList = buckets.get(index);
        if (buckerList.isEmpty()) {
            buckerList.add(value);
        } else {
            int i = 0;
            for (; i < buckerList.size(); i++) {
                if (buckerList.get(i) < value) continue;
                if (buckerList.get(i) >= value) break;
            }
            buckerList.add(i, value);
        }
        return buckerList;
    }

    private List<Integer> delete(int index, Integer value) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> bucketList = buckets.get(index);
        if (bucketList.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            bucketList.remove(value);
        }
        return bucketList;
    }


    public List<List<Integer>> bucketSort() {
        for (int element : elements) {
            int index = hash(element);
            buckets.set(index, insert(index, element));
        }
        return buckets;
    }

    public List<List<Integer>> cleanBucketSort() {
        for (int element : elements) {
            int index = hash(element);
            buckets.set(index, delete(index, element));
        }
        return buckets;
    }


}
