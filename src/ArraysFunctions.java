import javax.swing.*;

public class ArraysFunctions {
    void maxSubArray(){

        /*
        Pseudo Code
        Initialize:
            max_so_far = INT_MIN
            max_ending_here = 0

        Loop for each element of the array

          (a) max_ending_here = max_ending_here + a[i]
          (b) if(max_so_far < max_ending_here)
                    max_so_far = max_ending_here
          (c) if(max_ending_here < 0)
                    max_ending_here = 0
        return max_so_far
         */


        System.out.println("Max Sub Array");
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        int max = Integer.MIN_VALUE;

        int subArraySum = 0;

        for (int i = 0; i< arr.length; i++) {
            subArraySum = subArraySum + arr[i];

            if (max < subArraySum) {
                max = subArraySum;
            }

            if (subArraySum <0) {
                subArraySum = 0;
            }
        }

        System.out.println("Value of maximum sub-array is: " + max);
    }

    void printMaxSubArray(){
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int startIndex =-1 // Taking startIndex as -1 to cover the case when first element is part of subArray.
                , endIndex =0, max = Integer.MIN_VALUE, subArraySum = 0;

        for (int i =0; i<arr.length;i++) {
            subArraySum = subArraySum + arr[i];
            if (max < subArraySum) {
                max = subArraySum;
                endIndex = i;
            }
            if (subArraySum <0) {
                subArraySum = 0;
                startIndex =i;
            }
        }
        System.out.println("Max Subarray value is: " + max);
        System.out.print("Max Subarray elements are: " );
        printArray(arr, startIndex+1, endIndex);
    }

    void printArray(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex;i<=endIndex;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    Boolean searchInSortedArray(int[] arr, int elementToFind ) {
        boolean isElementPresent  = false;

        int startIndex =0;
        int endIndex  = arr.length;

        while(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex)/2;
            if (elementToFind == arr[midIndex]) {
                System.out.println("Element " + elementToFind + " is present in array at index " + midIndex);
                isElementPresent = true;
                break;
            } else{
                if (elementToFind > arr[midIndex] ) {
                    startIndex = midIndex +1;
                } else {
                    endIndex = endIndex -1;
                }
            }
        }
        if(!isElementPresent) {
            System.out.println("Element " +  elementToFind + " is not present in array");
        }
        return isElementPresent;
    }

    boolean doesElementExistsInSortedArray(int[]arr, int elementToFind, int startIndex, int endIndex) {
        boolean isElementPresent = false;

        while(startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex)/2;
            if (elementToFind == arr[midIndex]) {
                isElementPresent = true;
                break;
            } else{
                if (elementToFind > arr[midIndex] ) {
                    startIndex = midIndex +1;
                } else {
                    endIndex = endIndex -1;
                }
            }
        }

        return  isElementPresent;
    }

    /**
     * @Category BinarySearch
     */
    void searchInRotatedSortedArray() {
        /*
        As the array is rotated, we can clearly notice that for every index, one of the 2 halves will always be sorted.
        for example arr = {4,5,6,7,8,9,10,1,2,3}, first half of the array is sorted.

        So, to efficiently search for a target value using this observation, we will follow a simple two-step process.

        First, we identify the sorted half of the array.
        Once found, we determine if the target is located within this sorted half.
        If not, we eliminate that half from further consideration.
        Conversely, if the target does exist in the sorted half, we eliminate the other half.*/
        int[] arr = {4,5,6,7,8,9,10,1,2,3};
        int elementToFind = 9;
        boolean isElementPresent  = false;
        int startIndex=0, endIndex=arr.length-1;
        int length =  arr.length;

        while (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex)/2;
            if (elementToFind == arr[midIndex]) {
                isElementPresent = true;
                break;
            }

            if (arr[startIndex] < arr[midIndex-1]) { //In case first half is sorted{
                if (elementToFind >=arr[startIndex] && elementToFind <=arr[midIndex-1]) { // in case element is present in sorted array
                    endIndex = midIndex-1;
                } else { // Element is not present in sorted array
                    startIndex = midIndex +1;
                }
            } else { //In case 2nd half is sorted
                if (elementToFind >= arr[midIndex+1] && elementToFind <= arr[endIndex]) { // in case element is present in sorted array
                    startIndex = midIndex +1;
                } else { // in case element is not present in sorted array
                    endIndex = midIndex-1;
                }
            }
        }

        if (!isElementPresent) {
            System.out.println("Element " + elementToFind + " doesn't exist in array");
        } else {
            System.out.println("Element " + elementToFind + " exists in array");
        }

    }

    /**
     * @Category BinarySearch
     */
    void findMinElementInSortedRotatedArray() {
        int[] arr = {7,8,9,0,1,2,3,4,5,6};
        int startIndex =0, endIndex = arr.length, midIndex = 0;
        int min = Integer.MAX_VALUE;

        while (startIndex <endIndex) {
            midIndex = (startIndex + endIndex)/2;
            if (arr[startIndex] < arr[midIndex]) { // In case first half is sorted
                if (min > arr[startIndex]) {
                    min = arr[startIndex];
                }
                startIndex = midIndex +1;
            } else { // in case second half is sorted
                if (min > arr[midIndex +1] ) {
                    min = arr[midIndex +1];
                }
                endIndex = midIndex;
            }
        }

        System.out.println("Mid element in the given array is: " + min);
    }

    /**
     *
     * @Category 2-pointer
     */
    void containerWithMostWater(int [] arr) {
        //int arr[] = {1,2,3,4,5,6,7};
        if ((arr.length == 1) || (arr.length == 0)) {
            System.out.println("Zero litres");
            return;
        }
        if (arr.length == 2) {
            int water = Math.min(arr[0], arr[1]);
            System.out.println("Water stored is " + water + " and stored in bars with height as " + arr[0] + " and " + arr[1]);
            return;
        }

        int waterStored = 0;
        int maxWaterStored =0;
        int waterBar1Ht = 0, waterBar2Ht = 0;


        for (int i=0;i<arr.length-1;i++) {
            waterStored = Math.min(arr[i], arr[i+1]);
            if (waterStored > maxWaterStored) {
                maxWaterStored = waterStored;
                waterBar1Ht = arr[i];
                waterBar2Ht = arr[i+1];
            }
        }
        System.out.println("Water stored is " + maxWaterStored + " and stored in bars with height as " + waterBar1Ht + " and " + waterBar2Ht);
    }

    /**
     * @Category 2-pointer
     */
    int removeDuplicates(int[] arr) {
        int arrayNewLength = arr.length;
        int [] freqAr = new int[10];

        int uniqueNumPtr =0, arrCounter =0;

        while (arrCounter < arr.length) {
            freqAr[arr[arrCounter]]++;
            if (freqAr[arr[arrCounter]] == 1) {
                arr[uniqueNumPtr] = arr [arrCounter];
                uniqueNumPtr++;
            }
            arrCounter++;
        }
        for (int i=uniqueNumPtr;i<arr.length;i++) {
            arr[i] = -1;
        }
        return uniqueNumPtr;
    }

    int removeDuplicatesFromSortedArray(int[] arr) {
        int uniqueNumPtr =0, arrCounter =0;


        while (arrCounter < arr.length) {
            int repeatedCounter = arrCounter+1;

            // Checking if there are repeated numbers, if yes Keep moving to the last repeated number
            while( ( (arrCounter+1) < arr.length) && (arr[arrCounter] == arr[arrCounter+1])) {
                arrCounter++;
            }

            //Copy the number from arrCounter to uniquenumPtr index and then increment the both
            arr[uniqueNumPtr] = arr[arrCounter];
            uniqueNumPtr++;
            arrCounter++;
        }

        for (int i=uniqueNumPtr;i<arr.length;i++) {
            arr[i] = -1;
        }

        return uniqueNumPtr;
    }

    static void printArray(int[] arr) {
        for (int i=0;i <arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }



    /*
    This function creates a frequency array type array but will store the last index of that element instead of frequency
    This is used in Partition label function
     */
    static int[] getCharLastIndexArray(String str) {
        int[] charIndexArray = new int[26];

        for (int i=0;i <str.length();i++) {
            char ch = str.charAt(i);
            charIndexArray[ch - 'a'] = i;
        }

        return charIndexArray;
    }

    /**
     * @Category BinarySearch
     */
    int findFirstOccurrenceInSortedArrayWithDuplicates(int[] arr, int element) {
        int index = -1;
        int first = 0, last = arr.length-1, mid = (first + last)/2;
        while (first <= last) {
            if (element == arr[mid] && (mid == 0 || arr[mid-1] != element)) {
                return mid;
            }

            //@IMPORTANT!! Checking element greater than middle is must in IF check so that ELSE will have 1st half.
            // In case middle element is same as element to find, we need to search in first half as we need to find first occurrence
            if (element >arr [mid]) {
                first = mid+1;
            } else {
                last = mid-1;
            }
            mid = (first + last)/2;
        }
        return index;
    }

    /**
     * @Category BinarySearch
     */
    int findLastOccurrenceInSortedArrayWithDuplicates(int[] arr, int element) {
        int index = -1;
        int first = 0, last = arr.length-1, mid = (first + last)/2;
        while (first <= last) {
            if (element == arr[mid] && (mid == arr.length-1 || arr[mid+1] != element)) {
                return mid;
            }

            //@IMPORTANT!! Checking element smaller than middle is must in IF check so that ELSE will have 2nd half.
            // In case middle element is same as element to find, we need to search in 2nd half as we need to find last occurrence
            if (element < arr [mid]) {
                last = mid-1;
            } else {
                first = mid+1;
            }
            mid = (first + last)/2;
        }
        return index;
    }

    /**
     * @Category BinarySearch
     */
    int numberOfOccurrenceInSortedArrayWithDuplicates(int[] arr, int element) {
        int startIndex = findFirstOccurrenceInSortedArrayWithDuplicates(arr, element);
        int lastIndex = findLastOccurrenceInSortedArrayWithDuplicates(arr, element);

        return (lastIndex - startIndex ) +1;
    }

    /**
     * @Category BinarySearch
     */
    int findSmallestElementInRotatedSortedArray(int[] arr) {
        int result =-1;
        int first = 0, last = arr.length-1, mid = (first + last)/2;

        //@IMPORTANT!!: If we are not changing first as mid-1 and last as mid+1, then can check for less than and not required first <=last
        while (first <last) {
            if ((first == mid)&& (arr[first] > arr[last])) {
                result = arr[last];
                System.out.println("smallest element is: " + arr[last] + " whose index is "+ last);
                return result;
            }

            // This means first half is sorted
            //@IMPORTANT!!: Here can't do first = mid-1 or last = mid +1 because transition can be on mid index.
            if (arr[first] < arr[mid]) {
                first = mid;
            } else {
                last = mid;
            }
            mid = (first + last)/2;
        }

        return result;
    }

    /**
     * @Category BinarySearch
     */
    int sqRoot(int number) {

        if (number == 1)
            return 1;

        int start = 1, end = number/2, mid = (start + end)/2;

        while (start <= end) {
            if (mid * mid == number)
                return mid;

            if ( (number > (mid -1)* (mid -1)) && (number < (mid)* (mid)))
                return mid-1;

            if ( (number > (mid)* (mid)) && (number < (mid+1)* (mid+1)))
                return mid;

            if (number > mid * mid)
                start = mid +1;
            else
                end = mid -1;

            mid = (start + end)/2;
        }

        return -1;
    }

    /**
     * @Category BinarySearch
     */
    boolean checkForTargetedSumInSortedArray(int[] arr, int sum) {
        int start =0, end = arr.length-1, mid = (start + end)/2;

        while (start < end) {
            if (arr[start] + arr[end] == sum) {
                System.out.println("Targeted sum " + sum + " found with elements as " + arr[start] + " and " + arr[end]);
                return true;
            }
            if (arr[start] + arr[mid] == sum) {
                System.out.println("Targeted sum " + sum + " found with elements as " + arr[start] + " and " + arr[mid]);
                return true;
            }
            if (arr[mid] + arr[end] == sum) {
                System.out.println("Targeted sum " + sum + " found with elements as " + arr[mid] + " and " + arr[end]);
                return true;
            }

            if (sum < 2*arr[mid]) {
                end = mid-1;
            } else {
                start =mid+1;
            }
            mid = (start + end)/2;
        }

        return  false;
    }

    /**
     * @Category BinarySearch
     */
    int closestToGivenElementInSortedArray(int[] arr,int element) {
        int result = -1;

        int start = 0, end = arr.length -1, mid = (start +end)/2;
        if (element < arr[0]) {
            System.out.println("Element " + arr[0] + " is closest to given element " + element + " and is found at index " + 0);
            return arr[0];
        }


        if (element > arr[end]) {
            System.out.println("Element " + arr[end] + " is closest to given element " + element + " and is found at index " + end);
            return arr[end];
        }

        while (start <= end) {
             if (element == arr[mid]) {
                 System.out.println("Element " + arr[mid] + " is closest to given element " + element + " and is found at index " + mid);
                 return arr[mid];
             }

            //Checking if element is between mid and mid+1 index
            if (mid !=arr.length-1) {
                if (element>= arr[mid] && element <= arr[mid+1]) {
                    if((element - arr[mid]) > (arr[mid+1] - element)) {
                        System.out.println("Element " + arr[mid+1] + " is closest to given element " + element + " and is found at index " + (mid+1));
                        return arr[mid+1];
                    } else {
                        System.out.println("Element " + arr[mid] + " is closest to given element " + element + " and is found at index " + mid);
                        return arr[mid];
                    }
                }
            }

            if (mid != 0) {
                //Checking if element is between mid and mid-1 index
                if (element>= arr[mid-1] && element <= arr[mid]) {
                    if((element - arr[mid-1]) > (arr[mid] - element)) {
                        System.out.println("Element " + arr[mid] + " is closest to given element " + element + " and is found at index " + mid);
                        return arr[mid];
                    } else {
                        System.out.println("Element " + arr[mid-1] + " is closest to given element " + element + " and is found at index " + (mid - 1));
                        return arr[mid-1];
                    }
                }
            }

            if (element > arr[mid])
                start = mid;
            else
                end = mid;

            mid = (start + end)/2;
        }

        return result;
    }

}
