package org.example.OtherAlgorithms;

import java.util.Arrays;
public class CountInversions {
    public int countInversions(int[] arr) {
        int n = arr.length;
        int maxElement = Arrays.stream(arr).max().orElse(0);

        // Create and initialize BIT
        int[] bit = new int[maxElement + 1];

        // Count inversions
        int inversions = 0;
        for (int i = n - 1; i >= 0; i--) {
            inversions += query(bit, arr[i] - 1);
            update(bit, arr[i], 1);
        }

        return inversions;
    }

    private int query(int[] bit, int index) {
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & (-index);
        }
    }
}