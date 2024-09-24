package arrays;

/*
Start with first element and keep on adding until the current sum is less than or equal to given sum. Adding the element towards the end of the loop code.
If current sum is greater than the given sum, this means we need to remove some elements from the current list. Remove the first one and update the start counter.
If current sum is equal to the given sum, then break the loop
 */
public class ContiguousSubArrayWithGivenSum {
    static void fn() {
        int[] inputAr = { 15, 2, 4, 8, 10, 56, 10, 23 };
        int sum = 23;
        int currentSum = inputAr[0];
        int start = 0;
        int currentCounter = 1;

        while (start != inputAr.length-1){
            if (currentSum>sum) {
                currentSum = currentSum -inputAr[start];
                start++;
                continue;
            }
            if (sum == currentSum) {
                System.out.println("Contiguous SubArray with given sum is found");
                break;
            }
            currentSum = currentSum + inputAr[currentCounter];
            currentCounter++;
        }

        System.out.print("Contigous Array is ");
        for (int i = start;i<currentCounter;i++) {
            System.out.print(inputAr[i] + " ");
        }
    }
}
