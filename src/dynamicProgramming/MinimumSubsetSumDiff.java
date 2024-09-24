package com.company.dynamicProgramming;

/**
 * Return true if the given array can be divided into 2 sub-arrays whose diff is equal to given number
 *
 * This problem can be derived to subset sum problem, if we observed these conditions.
 * Say there are 2 sub-arrays whose sum is S1 and S2 and diff value is given as X. Then, we can say that
 *      abs(S1-S2) = X
 *      S1 + S2 = MainArraySum
 *      2*S1 = X+ MainArraySum
 *      S1 = (X+ MainArraySum)/2
 *  Now just check (X+ MainArraySum)/2 for subset sum.
 */
public class MinimumSubsetSumDiff {
}
