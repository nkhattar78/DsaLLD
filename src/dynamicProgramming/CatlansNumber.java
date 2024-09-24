package com.company.dynamicProgramming;

public class CatlansNumber {
    public static void mainFn() {
        int n = 10;
        int[] catlansNumArray = new int[n];
        fillCatlanArrayUsingDP(catlansNumArray);
        System.out.println("Catlan's number at position " + n + " is " + catlansNumArray[n-1] );
    }

    private static void fillCatlanArrayUsingDP(int[] catlansArray) {
        catlansArray[0] = 1;
        catlansArray[1] = 1;
        for (int i=2;i<catlansArray.length;i++) {
            for (int c=0; c<i;c++) {
                catlansArray[i] += catlansArray[c] * catlansArray[i-c-1];
            }
        }
    }
}
