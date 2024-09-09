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
}
