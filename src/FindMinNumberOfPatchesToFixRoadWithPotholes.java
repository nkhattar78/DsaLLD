package com.company;

public class FindMinNumberOfPatchesToFixRoadWithPotholes {
    static void fn(){
        //Assume  0 represent pothole and 1 assume good segment
        int[] road= {0,1,0,0,0,0,1,0};
        int singleFix = 3; //SingleFix represent how many segments singleFix will pix in one time
        int segmentsCount =0;
        int roadCounter=0;
        //Scan the road from left to right, as soon as find the pothole fix it and advance the counter by 3 as single fix will fix 3 segments at a time
        while (roadCounter <= road.length-1) {
            if (road[roadCounter] == 0) {
                segmentsCount++;
                roadCounter = roadCounter + singleFix;
            } else {
                roadCounter++;
            }
        }
        System.out.println("Minimum nUmber of segments required to fix the road is: " + segmentsCount);
    }
}
