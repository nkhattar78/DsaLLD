package arrays;

public class FindOccurrenceOfElementGreaterThanNby4InSortedArray {
    static void fn() {
        //If the element occurrence is more than n/4 times then it must be present at either, n/4 or n/2 or 3n/4 position
        //So will check the first and last occurrence of the element at these positions. If last-first occurrence is greater than n/4 we get the answer.
        int[] inputArray = {1,2,2,3,4,5,6,6,7,8,10,11};

        //If we want to generalize it for n/k instead of n/4 then just replace the value of K here with the given number
        int k=4;
        int n = inputArray.length;
        System.out.println("n = " + n + " k = " + k);
        for (int i=1;i<=k-1;i++) {
            int element = inputArray[i*n/k];
            //check b/w o to n/4 for first iteration
            int start =   (i-1)*n/k;
            int end = i*n/k;
            int startPosition = findFirstOccurrenceFromTheRange(element,start,end, inputArray);
            //check b/w n/4 to n/2 for first iteration
            start =   i*n/k;
            end = ((i+1)*n/k) -1;
            int endPosition = findLastOccurrenceFromTheRange(element,start, end,inputArray);
            //Start and end position have the element, so to get the numbers b/w them need to add 1
            if (endPosition+1-startPosition>=n/k) {
                System.out.println("There exists an element " + element + " with occurrences more than or equal to n/4 times");
                return;
            }
        }
        System.out.println("There is no element in this input array whose occurrence is more than or equal to n/4 times");
    }

    static private int findFirstOccurrenceFromTheRange(int element, int start, int end, int[] array) {
        int mid = 0;
        if (array[start] == element) {
            return  start;
        }
        while(end-start>1) {
            mid = (start + end)/2;
            if (array[mid] != element) {
                start =mid;
            } else {
                end = mid;
            }
        }
        if (array[end]!= element){
            return  -1;
        }
        return end;
    }

    static  private int findLastOccurrenceFromTheRange(int element, int start, int end, int[] array) {
        int mid = 0;
        if(array[end] == element) {
            return end;
        }
        while(end-start>1) {
            mid = (start + end)/2;
            if (array[mid] != element) {
                end =mid;
            } else {
                start = mid;
            }
        }

        if (array[start]!= element){
            return  -1;
        }
        return start;
    }

    private static boolean isNumberPresentInSortedArrayRange(int numberToCheck, int start, int end, int[] array) {
        boolean result = false;
        if (numberToCheck<array[start] || numberToCheck>array[end]) {
            return result;
        }

        while(end-start>1) {
            if(numberToCheck == array[start] || numberToCheck == array[end]) {
                result = true;
                break;
            }
            int mid = (start + end)/2 ;
            if (numberToCheck>array[mid]) {
                start = mid;
            } else if (numberToCheck<array[mid]) {
                end = mid;
            } else {
                result = true;
                break;
            }
        }
        return  result;
    }
}
