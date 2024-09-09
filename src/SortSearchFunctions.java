import java.util.HashMap;

public class SortSearchFunctions {
    void commonElementInThreeSortedArrays(){
        /*
        2 approaches:
        1. Find the minimum length of array. Check if its eleements are presnet in other arrays using binary search
        2. Create a hashmap for array elements. If the hashmap entry contains 3 as value then it means that the element is present in all three arrays
         */

        int[] A = {1, 5, 10, 20, 30};
        int[] B = {5, 13, 15, 20};
        int[] C = {5, 20};
        int[] minLengthArray = {};
        int minLength = Integer.MAX_VALUE;
        ArraysFunctions arraysFunctions = new ArraysFunctions();

        if (minLength > A.length){
            minLength = A.length;
            minLengthArray = A;
        }


        if (minLength > B.length) {
            minLength = B.length;
            minLengthArray = B;
        }

        if (minLength > C.length) {
            minLength = C.length;
            minLengthArray = C;
        }

        for (int i =0;i<minLength;i++) {
            if( (arraysFunctions.searchInSortedArray(A, minLengthArray[i])) && (arraysFunctions.searchInSortedArray(B, minLengthArray[i])) )
                System.out.println("Element " + minLengthArray[i] + " is present in all the three arrays");
        }
    }

    void findElementInArrayWithDiffAs1InAdjacentElements() {
        /*
        We know that adjacent elements can max be more than 1 the previous element.
        So instead of checking next element we can skip elementToFind - currentElement.
         */
        int[] arr = {1,2,3,4,3,4,5,4,3,4,5,6,7,6,7,8,9};
        int elementToFind = 8;
        int currentElementIndex = 0;
        boolean isElementFound = false;

        while (currentElementIndex >=0 && currentElementIndex < arr.length) {
            if (elementToFind == arr[currentElementIndex]) {
                System.out.println("Element " + elementToFind + " found in array");
                isElementFound = true;
                break;
            }
            int diff = elementToFind - arr[currentElementIndex];
            currentElementIndex = currentElementIndex + diff;
        }

        if(!isElementFound) {
            System.out.println("Element " + elementToFind + " is NOT found in array");
        }
    }

    void findElementInArrayWithDiffAtMaxXInAdjacentElements() {
        /*
        This is an extension of findElementInArrayWithDiffAs1InAdjacentElements
         */
        int[] arr = {10,20,40,50,30,50,60};
        int maxDiffInAdjacentElements = 20;
        int elementToFind = 60;
        int currentElementIndex = 0;
        boolean isElementFound = false;

        while (currentElementIndex >=0 && currentElementIndex < arr.length) {
            if (elementToFind == arr[currentElementIndex]) {
                System.out.println("Element " + elementToFind + " found in array");
                isElementFound = true;
                break;
            }
            currentElementIndex = currentElementIndex + Math.max(1, (elementToFind - arr[currentElementIndex])/maxDiffInAdjacentElements);
        }

        if(!isElementFound) {
            System.out.println("Element " + elementToFind + " is NOT found in array");
        }
    }
}
