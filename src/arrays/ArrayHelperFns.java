package arrays;

public class ArrayHelperFns {
    private static ArrayHelperFns instance = null;
    private ArrayHelperFns () {

    }

    public static ArrayHelperFns getInstance() {
        if (instance == null) {
            instance = new ArrayHelperFns();
        }
        return instance;
    }

    void printIntegerArray(int[] array, String message) {
        System.out.println(message);
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
