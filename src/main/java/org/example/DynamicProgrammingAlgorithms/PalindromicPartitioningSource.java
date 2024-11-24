package org.example.DynamicProgrammingAlgorithms;// Code taken from: https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/dynamicprogramming/PalindromicPartitioning.java

/**
 * @author [Syed] (https://github.com/roeticvampire)
 */
public class PalindromicPartitioningSource {

    public static int minimalpartitions(String word) {
        int len = word.length();
        
        int[] minCuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];

        int i, j, L; // different looping variables

        // Every substring of length 1 is a palindrome
        for (i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }

        /* L is substring length. Build the solution in bottom up manner by considering all substrings of length starting from 2 to n. */
        for (L = 2; L <= len; L++) {
            // For substring of length L, set different possible starting indexes
            for (i = 0; i < len - L + 1; i++) {
                j = i + L - 1; // Ending index
                
                if (L == 2) {
                    isPalindrome[i][j] = (word.charAt(i) == word.charAt(j));
                } else {
                    if (
                        (word.charAt(i) == word.charAt(j)) &&
                        isPalindrome[i + 1][j - 1]
                    ) {
                        isPalindrome[i][j] = true;
                    } else {
                        isPalindrome[i][j] = false;
                    }
                }
            }
        }

        //We find the minimum for each index
        for (i = 0; i < len; i++) {
            if (isPalindrome[0][i] == true) {
                minCuts[i] = 0;
            } else {
                minCuts[i] = Integer.MAX_VALUE;
                for (j = 0; j < i; j++) {
                    if (
                        isPalindrome[j + 1][i] == true &&
                        1 + minCuts[j] < minCuts[i]
                    ) {
                        minCuts[i] = 1 + minCuts[j];
                    }
                }
            }
        }

        // Return the min cut value for complete
        // string. i.e., str[0..n-1]
        return minCuts[len - 1];
    }
}

