package org.example.DynamicProgrammingAlgorithms;// Code taken from: https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/dynamicprogramming/MinimumSumPartition.java

public class MinimumSumPartitionSource {

    public static int subSet(int[] arr) {
        int n = arr.length;
        int sum = getSum(arr);
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }

        // fill dp array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] < j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else if (arr[i - 1] == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // fill the index array
        int[] index = new int[sum];
        int p = 0;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n][i]) {
                index[p++] = i;
            }
        }

        return getMin(index, sum);
    }

    /**
     * Calculate sum of array elements
     *
     * @param arr the array
     * @return sum of given array
     */
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int temp : arr) {
            sum += temp;
        }
        return sum;
    }

    public static int getMin(int[] arr, int sum) {
        if (arr.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int temp : arr) {
            min = Math.min(min, sum - 2 * temp);
        }
        return min;
    }
}
