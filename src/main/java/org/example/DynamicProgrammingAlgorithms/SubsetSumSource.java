package org.example.DynamicProgrammingAlgorithms;// Code taken from: https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/dynamicprogramming/SubsetSum.java

public class SubsetSumSource {
	
    /**
     * Test if a set of integers contains a subset that sum to a given integer.
     *
     * @param arr the array contains integers.
     * @param sum target sum of subset.
     * @return {@code true} if subset exists, otherwise {@code false}.
     */
    public static boolean subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] isSum = new boolean[n + 2][sum + 1];

        isSum[n + 1][0] = true;
        for (int i = 1; i <= sum; i++) {
            isSum[n + 1][i] = false;
        }

        for (int i = n; i > 0; i--) {
            isSum[i][0] = true;
            for (int j = 1; j <= arr[i - 1] - 1; j++) {
                if (j <= sum) {
                    isSum[i][j] = isSum[i + 1][j];
                }
            }
            for (int j = arr[i - 1]; j <= sum; j++) {
                isSum[i][j] = (isSum[i + 1][j] || isSum[i + 1][j - arr[i - 1]]);
            }
        }

        return isSum[1][sum];
    }
}
