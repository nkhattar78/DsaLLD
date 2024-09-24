package dynamicProgramming;

/**
 * Problem Statement
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if the length of the rod is 8 and the values of different pieces are given as the following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 * Solution: This is exactly same as unbounded knapsack problem as we can cut multiple pieces of same size if length permits.
 *
 * Here choice diagram is like this:
 * 1. If the rodLength is smaller than length index then that length index can't be considered,
 *      just call the recursive function with next element
 * 2. If the rodLength is greater than length index then take the max of these 2 cases
 *    a. This length index is not considered
 *        In this case also call the recursive function with next element
 *    b. This length index is considered
 *         Increase the price, decrease the total length BUT call the recursive function with same element as one element can be called multiple times.
 */
public class CuttingRod {
        static final int[] LENGTH ={1,2,3,4};
        static final int[] PRICE = {1,5,8,9};
    static final int ROD_LENGTH = 4;
//    static final int[] LENGTH ={1,2,3,4,5,6,7,8};
//    static final int[] PRICE = {1,5,8,9,10,17,18,20};
//    static final int ROD_LENGTH = 8;
    static int dp[][] = new int[LENGTH.length+1][ROD_LENGTH +1];

    public static void mainFn() {
        System.out.println("Max price received by rod cutting is: " + maxPriceRecursive(0, ROD_LENGTH, 0));
        for (int i =0; i<=LENGTH.length;i++) {
            for (int j=0; j<= ROD_LENGTH; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Max price received by rod cutting using memoization technique is: " + maxPriceMemoization(0, ROD_LENGTH, 0));
    }

    private static int maxPriceMemoization(int index, int remainingLength, int price) {
        //Return the price calculated so far
        if (remainingLength == 0 || index == LENGTH.length) {
            return price;
        }
        if (dp[index][remainingLength] != -1) {
            return dp[index][remainingLength];
        }

        if (LENGTH[index] > remainingLength) {
            dp[index][remainingLength] = maxPriceMemoization(index + 1, remainingLength, price);
        } else {
            dp[index][remainingLength] = Math.max(
                    maxPriceMemoization(index, remainingLength - LENGTH[index], price + PRICE[index]),
                    maxPriceMemoization(index + 1, remainingLength, price));
        }
        return dp[index][remainingLength];
    }

    private static int maxPriceRecursive(int index, int remainingLength, int price) {
        //Return the price calculated so far
        if (remainingLength == 0 || index == LENGTH.length) {
            return price;
        }

        if (LENGTH[index] > remainingLength) {
            return maxPriceRecursive(index +1, remainingLength, price);
        }
        return Math.max(
                maxPriceRecursive(index, remainingLength-LENGTH[index], price + PRICE[index]),
                maxPriceRecursive(index + 1, remainingLength, price));
    }


}
