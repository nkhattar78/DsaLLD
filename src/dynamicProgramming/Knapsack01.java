package com.company.dynamicProgramming;

public class Knapsack01 {
    static final int KNAPSACK_CAPACITY = 4;
    static final int NO_OF_WEIGHTS = 3;
    static int[][] dp = new int[KNAPSACK_CAPACITY+1][NO_OF_WEIGHTS+1];
    public static void mainFn() {
        int weights[] = {1,2,3};
        int values[] = {6,10,12};

        int value = maxValueInKnapsack01Recursive(weights, values, weights.length-1, KNAPSACK_CAPACITY);

        System.out.println("Sack value: " + value);

        for (int i =0;i<=KNAPSACK_CAPACITY;i++) {
            for (int j =0;j<=NO_OF_WEIGHTS; j++) {
                dp[i][j] = -1;
            }
        }
        maxValueInKnapsack01Memoization(weights, values, weights.length, KNAPSACK_CAPACITY);
        value= dp[KNAPSACK_CAPACITY][NO_OF_WEIGHTS];
        System.out.println("Sack value using memoization technique: " + value);
    }

    private static int maxValueInKnapsack01Memoization(int[] weights, int [] values, int n, int sackRemainingCapacity) {
        if (n == 0 || sackRemainingCapacity <= 0) {
            return 0;
        }

        if (dp[sackRemainingCapacity][n] != -1) {
            return dp[sackRemainingCapacity][n];
        } else {
            if (weights[n-1] > sackRemainingCapacity) {
                dp[sackRemainingCapacity][n] = maxValueInKnapsack01Memoization(weights, values, n-1, sackRemainingCapacity);
            } else {
                dp[sackRemainingCapacity][n] = Math.max(
                        values[n-1] + maxValueInKnapsack01Memoization(weights, values, n-1, sackRemainingCapacity-weights[n-1]),
                        maxValueInKnapsack01Memoization(weights, values, n-1, sackRemainingCapacity));
            }
        }
        return dp[sackRemainingCapacity][n];
    }

    private static int maxValueInKnapsack01Recursive(int[] weights, int [] values, int n, int sackRemainingCapacity) {
        if (n < 0 || sackRemainingCapacity == 0) {
            return 0;
        }
        if(weights[n] > sackRemainingCapacity) {
            return maxValueInKnapsack01Recursive(weights, values, n-1, sackRemainingCapacity);
        } else {
            return Math.max( values[n] +  maxValueInKnapsack01Recursive(weights, values, n-1,  sackRemainingCapacity- weights[n]),
                    maxValueInKnapsack01Recursive(weights, values, n-1, sackRemainingCapacity));
        }
    }

}
