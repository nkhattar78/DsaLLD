package com.company.trees;

public class PrintAllPaths {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        int[] path = new int[1000];
        printAllPaths(root, path, 0);
    }

    private static void printAllPaths(BTNode root, int[] pathArray, int arrayCounter) {
        if(root == null) {
            return;
        }
        pathArray[arrayCounter] = root.data;
        arrayCounter++;
        if(root.left == null && root.right == null) {
            printArray(pathArray, arrayCounter);
        }
        printAllPaths(root.left, pathArray, arrayCounter);
        printAllPaths(root.right, pathArray, arrayCounter);
    }

    private static void printArray(int[] array, int size) {
        for (int i =0; i<size;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
