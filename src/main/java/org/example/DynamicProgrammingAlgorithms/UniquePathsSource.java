package org.example.DynamicProgrammingAlgorithms;// Code taken from: https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/dynamicprogramming/UniquePaths.java
// Few modifications done to ensure it returns an int and not a boolean 

/** Author : Siddhant Swarup Mallick
 * Github : https://github.com/siddhant2002
 */

import java.util.*;

public class UniquePathsSource {

    public static int uniquePathsDP(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
        // return true if predicted answer matches with expected answer
    }

    // The above method runs in O(n) time
    public static int uniquePathsNaive(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
        // return true if predicted answer matches with expected answer
    }
    // The above mthod takes O(m*n) time
}
