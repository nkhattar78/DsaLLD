package com.company.dynamicProgramming;

public class SubsetSumExists {
    final static int [] ARRAY_NUMS = {0,2,3,4};
    final static int SUBSET_SUM = 5;
    static int[][] dp = new int[ARRAY_NUMS.length+1][SUBSET_SUM+1];

    public static void mainFn() {
        boolean isSubsetSum = subsetSumRecursive(ARRAY_NUMS, SUBSET_SUM, ARRAY_NUMS.length);
        System.out.println("isSubsetSum: " + isSubsetSum);


        for (int i = 0; i<= ARRAY_NUMS.length;i++) {
            for (int j = 0; j<=SUBSET_SUM; j++) {
                dp[i][j] = -1;
            }
        }
        subSetSumMemoization(ARRAY_NUMS, SUBSET_SUM, ARRAY_NUMS.length);
    }

    private static int subSetSumMemoization(int[] array, int subsetSum, int n) {
        if (subsetSum == 0) {
            return 1;
        }

        if (n==0 && subsetSum != 0) {
            return 0;
        }

        if (dp[n][subsetSum] != -1) {
            return dp[n][subsetSum];
        } else {
            if(array[n-1] > subsetSum) {
                dp[n][subsetSum] = subSetSumMemoization(array, subsetSum, n-1);
            } else {
                if((subSetSumMemoization(array, subsetSum - array[n-1], n-1) == 1) ||
                                (subSetSumMemoization(array, subsetSum, n-1) == 1)) {
                    dp[n][subsetSum] =  1;
                }
            }
        }
        return dp[n][subsetSum];
    }

    private static boolean subsetSumRecursive(int[] array, int subsetSum, int n) {
        if (subsetSum == 0) {
            return true;
        }
        if (n==0 && subsetSum != 0) {
            return false;
        }

        if(array[n-1] > subsetSum) {
            return subsetSumRecursive(array, subsetSum, n-1);
        } else {
            return subsetSumRecursive(array, subsetSum - array[n-1], n-1) ||
                    subsetSumRecursive(array, subsetSum, n-1);
        }
    }
}
