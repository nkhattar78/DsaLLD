package com.company.arrays;

public class RemoveDuplicatesFromSortedArray {

    public void mainFn(){
        int[] array = {1,1,1,2,2,3,3,3,4,5,5,6};
        //int[] array = {1,1,1,1,2,2,2,3,4};
        int uniqueNumCounter =0, arrayCounter =1;
        if (array.length==0 || array.length == 1) {
            System.out.println("Array length is 0 or 1");
        } else {
            for (; arrayCounter<array.length; arrayCounter++) {
                //If the adjacent numbers are same then run the loop till don't find the unique number
                if (array[uniqueNumCounter] == array[arrayCounter]) {
                    for (int i = arrayCounter + 1; i<array.length;i++) {
                        if (array[i] == array[arrayCounter]) {
                            arrayCounter++;
                        } else {
                            //Once unique number is found, increment uniqueNumCounter and add in that element.
                            array[++uniqueNumCounter] = array[i];
                            break;
                        }
                    }
                } else {
                    uniqueNumCounter++;
                }
            }
        }
        printOutput(array, uniqueNumCounter +1);
    }

    private void printOutput(int[] array, int counter) {
        System.out.println("Unique elements: " + counter);
        for(int i=0; i< counter; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
