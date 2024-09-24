package com.company.trees;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Replace each node with sum of all nodes greater than that node
 */
public class GreatSumTree {
    public static void mainFn() {
        //int[] data = {1,2,3,4,5,6,7};
        int[] data = {1,2,3};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        AtomicInteger greaterSum = new AtomicInteger(0);
        greaterSumTree(root, greaterSum);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
    }

    private static void greaterSumTree(BTNode root, AtomicInteger sum) {
        if(root == null) return;
        greaterSumTree(root.right, sum);
        int element = root.data;
        root.data = sum.get();
        sum.set(sum.get() + element);
        greaterSumTree(root.left, sum);
    }
}
