package com.company.arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinDivisionsToGetArraySumAsHalf {
    static void fn() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] inputArray = {2,4,10,40};
        int sum = 0;
        int count =0;

        for (int i=0;i<inputArray.length;i++) {
            sum += inputArray[i];
            pq.add(inputArray[i]);
        }

        System.out.println("Original sum: " + sum);
        int newsum = sum;
        while(newsum>sum/2) {
            int topElement = pq.poll();
            newsum = newsum - topElement + topElement/2;
            pq.add(topElement/2);
            count++;
            System.out.println("Element taken: " + topElement + " New sum: " + newsum);
        }

        System.out.println("Number of divide operations required to reduce the array sum minimum by 2 are " + count);
    }
}
