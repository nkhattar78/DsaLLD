package com.company.dynamicProgramming;

public class NumberOfUniqueBSTs {
    public static void mainFn() {
        int n = 6;
        System.out.println("Number of unique BSTs for size " + n + " is " +  numberOfUniqueBSTs(n));
    }

    private static int numberOfUniqueBSTs(int n) {
        int[] dpArray = new int[n+1];
        if(n==1||n==2) {
            return n;
        }
        dpArray[0] = 1;
        dpArray[1] = 1;
        dpArray[2] = 2;
        for (int i=3;i<=n;i++) {
            dpArray[i] = numberOfUniqueBSTsForSingleNum(i, dpArray);
        }
        return dpArray[n];
    }

    private static int numberOfUniqueBSTsForSingleNum(int n, int[] dpArray) {
        int count =0;
        for (int i = 0; i < n; i++) {
            count = count + (dpArray[i] * dpArray[n-1-i]);
        }
        return count;
    }
}
