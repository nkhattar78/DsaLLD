package com.company.arrays;

public class ContiguousSubArrayHavingMultipleOfGivenNum {
    static void fn() {
        int[] inputAr = {23,2,6,4,7};
        int k = 6;

        int remainder = inputAr[0]%k;
        int currentElemntIndex =1;
        int start = 0;
        while(start<inputAr.length-1) {
            remainder = remainder + (inputAr[currentElemntIndex] % k);
            currentElemntIndex++;
            if(remainder == k) {
                System.out.println("Sub Array found");
            }
            if (remainder>k) {
                remainder = remainder - (inputAr[start]%k);
                start++;
            }
        }
    }
}
