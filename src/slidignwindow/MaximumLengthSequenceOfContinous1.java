package com.company.slidignwindow;

/** Problem statement
 * For example, consider array { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }.
 * The index to be replaced is 7 to get a continuous sequence of length 6 containing all 1’s.
 *
 */
public class MaximumLengthSequenceOfContinous1 {
    public static void mainFn() {
        int[] array = { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 };
        //int[] array = { 1,0,1,0,1,1};
        getIndexToBeReplaced(array);

    }

    private static int getIndexToBeReplaced(int[] array){
        int maxIndex=0;

        int zeroCount =0;
        int maxOnes =0;
        int last0Index = 0;
        int left =0;

        for (int i=0;i<array.length;i++) {
            if (array[i] ==0) {
                zeroCount++;
                last0Index = i;
            }
            if (zeroCount ==2) {
                while (array[left] !=0) {
                    left++;
                }
                left++;
                zeroCount=1;
            }
            if (i-left+1 > maxOnes) {
                maxOnes = i-left+1;
                maxIndex = last0Index;
            }

        }

        System.out.println("Max 1's found: " + maxOnes + ". Index to convert 1 to get these max 1's is: " + maxIndex);
        return maxIndex;
    }
}
