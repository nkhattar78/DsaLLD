package com.company.dynamicProgramming;

public class Knapsack01TopDown {
    static final int KNAPSACK_CAPACITY = 4;
    static final int NO_OF_WEIGHTS = 3;
    static int[][] dp = new int[NO_OF_WEIGHTS+1][KNAPSACK_CAPACITY+1];
    public static void mainFn() {
        int weights[] = {1,2,3};
        int values[] = {6,10,12};

        //If bag capacity is 0 then max value will also be 0
        for(int i =0; i<=NO_OF_WEIGHTS; i++) {
            dp[i][0] = 0;
        }

        //If number of weights are 0 then also max value will also be 0
        for(int i =0; i<=KNAPSACK_CAPACITY; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1;i<=NO_OF_WEIGHTS; i++) {
            for (int w=1; w<=KNAPSACK_CAPACITY;w++) {
                /** If current required weight is smaller than current weight index then it means current weight index can't be chosen.*/
                if(w < weights[i-1]) {
                    dp[i][w] = dp[i-1][w];
                } else {
                    /** Take maximum of:
                     * 1. If the current weight is not taken
                     * 2. If current weight is considered. If considered then increase the value and decrease the weight taken*/
                    dp[i][w] = Math.max(dp[i-1][w], values[i-1] + dp[i-1][w-weights[i-1]]);
                }
            }
        }

        System.out.println("Max value: " + dp[NO_OF_WEIGHTS][KNAPSACK_CAPACITY]);
    }
}
