package dynamicProgramming;

public class SubsetSumCountMemoization {
    final static int [] ARRAY_NUMS = {1,2};
    final static int SUBSET_SUM = 3;
    static int[][] dp = new int[ARRAY_NUMS.length+1][SUBSET_SUM+1];
    static boolean[][] validated = new boolean[ARRAY_NUMS.length+1][SUBSET_SUM+1];

    public static void mainFn() {
        int subsetSumCount = subSetSumMemoization(ARRAY_NUMS, SUBSET_SUM, 0);
        System.out.println("subsetSumCount: " + subsetSumCount);
    }

    private static int subSetSumMemoization(int[] array, int subsetSum, int n) {
        if (subsetSum == 0) {
            return 1;
        }

        if (n == array.length && subsetSum != 0) {
            return 0;
        }

        if (validated[n][subsetSum] == true) {
            return dp[n][subsetSum];
        }

        validated[n][subsetSum] = true;

        if(array[n] > subsetSum) {
            dp[n][subsetSum] = subSetSumMemoization(array, subsetSum, n+1);
        } else {
            dp[n][subsetSum] = subSetSumMemoization(array, subsetSum - array[n], n+1) +
                    subSetSumMemoization(array, subsetSum, n+1);
        }
        return dp[n][subsetSum];
    }
}
