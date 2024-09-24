package com.company.trees;

import java.util.concurrent.atomic.AtomicInteger;

public class BSTtoMaxHeap {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
//        int[] data = {1,2,3};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        createMaxHeapFromBST(root, data, new AtomicInteger(0));
        new HeapSort().printMaxHeapByLevel(data);
    }

    private static void createMaxHeapFromBST(BTNode root, int[] array, AtomicInteger index) {
        if(root == null) {
            return;
        }
        createMaxHeapFromBST(root.right, array, index);
        array[index.get()] = root.data;
        index.set(index.get() +1);
        createMaxHeapFromBST(root.left, array, index);
    }
}
