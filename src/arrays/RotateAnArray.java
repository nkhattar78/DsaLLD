package arrays;

public class RotateAnArray {
    public void mainFn(int[] numArray, int numberOfRotations){
        numberOfRotations = numberOfRotations % numArray.length;

        ArrayHelperFns.getInstance().printIntegerArray(numArray, "Original Array");
        for (int i=1;i<=numberOfRotations;i++) {
            numArray = rotateArrayByOne(numArray);
        }
        ArrayHelperFns.getInstance().printIntegerArray(numArray, "Final Array");
    }

    int[] rotateArrayByOne(int[] numArray) {
        int num = numArray[numArray.length-1];
        for (int i = 0;i< numArray.length;i++) {
            int temp = numArray[i];
            numArray[i] = num;
            num = temp;
        }
        return numArray;
    }
}
