package com.company.dynamicProgramming;

/**
 * Given an integer N, the task is to obtain N, starting from 1 using minimum number of operations. The operations that can be performed in one step are as follows:
 * Multiply the number by 2.
 * Multiply the number by 3.
 * Add 1 to the number.
 *
 * 2 Approaches, one with DP one without DP
 * 1. Without DP
 *      Instead of 1->N start from N->1. Operations will become, subtract 1, divide by 2 and divide by 3.
 *      If N is divisible by 3, then divide N by 3
 *      else if N is divisible by 2, then divide by 2
 *      else subtract 1
 *    Count all the operations.
 *
 * 2. Using DP
 *  If minimum operations to obtains any number smaller than N is known, then minimum operations to obtain N can be calculated.
 *  Create look up table
 *      dp[i] = Minimum number of operations to obtain i from 1.
 *  So for any number x, minimum operations required to obtain x can be calulated as
 *  dp[x] = min(dp[x-1], dp[x/2], dp[x/3]) + 1
 */
public class MinOperationRequiredToReachNumber0toN {
    public static void mainFn() {
        MinOperationRequiredToReachNumber0toN.mainFn();
        int destination = 15;
        System.out.println("Minimum operations to reach 1 to " + destination + " are " + minOperationsWithoutDP(destination));
        System.out.println("Minimum operations to reach 1 to " + destination + " using DP algo are " + minOperationsWithDP(destination));
    }

    private static int minOperationsWithDP(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i=2;i<=n;i++) {
            dp[i] = Integer.MAX_VALUE;

            //This is to check is this path is available for the given number or not.
            if (i % 3 == 0) {
                int x = dp[i/3];
                if(dp[i] > x+1 ) {
                    dp[i] = x+1;
                }
            }

            if (i % 2 == 0) {
                int x = dp[i/2];
                if(dp[i] > x+1 ) {
                    dp[i] = x+1;
                }
            }

            int x = dp[i-1];
            if(dp[i] > x + 1 ) {
                dp[i] = x + 1;
            }
        }

        return dp[n];
    }

    private static int minOperationsWithoutDP(int n) {
        int minOperations = 0;
        while(n>1) {
            if (n%3 == 0) {
                n = n/3;
            } else if (n%2 == 0) {
                n = n/2;
            } else {
                n = n-1;
            }
            minOperations++;
        }
        return minOperations;
    }

}
