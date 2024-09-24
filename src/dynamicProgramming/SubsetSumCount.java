package dynamicProgramming;

public class SubsetSumCount {
    final static int [] ARRAY_NUMS = {2,1,3};
    final static int SUBSET_SUM = 3;
    static int[][] dp = new int[ARRAY_NUMS.length+1][SUBSET_SUM+1];

    public static void mainFn() {
        int subsetSumCount = subSetSumCountMemoization(ARRAY_NUMS, SUBSET_SUM, ARRAY_NUMS.length);
        System.out.println("isSubsetSum: " + subsetSumCount);
        subSetSumCountMemoization(ARRAY_NUMS, SUBSET_SUM, ARRAY_NUMS.length);
    }

    private static int subSetSumCountMemoization(int[] array, int subsetSum, int n) {
        dp[0][0] = 1;
        //If number of elements is 0 and sum is non-zero then subsetSum can not exist and so will remain 0
        for (int i = 1; i<= SUBSET_SUM; i++) {
            dp[0][i]= 0;
        }

        // If sum is 0 then we can always assume that subset sum exists as that subset will be empty.
        for (int i =1; i<=ARRAY_NUMS.length;i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<= ARRAY_NUMS.length; i++) {
            for (int j =1; j<= SUBSET_SUM; j++) {
                if(array[i-1] > subsetSum) {
                    dp[i][j] = dp[i-1][j];
                } else {
//                    dp[i][j] = dp[i-1][j] +
                }
            }
        }
        return dp[n][subsetSum];
    }


}
