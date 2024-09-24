package com.company.trees;

public class SortedArrayToBST {
    public static void mainFn() {
        int[] data = {1,2,3};
        BTNode root =sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
    }

    public static BTNode sortedArrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end)/2;
        BTNode node = new BTNode(array[mid]);
        node.left = sortedArrayToBST(array, start, mid-1);
        node.right = sortedArrayToBST(array, mid+1, end);
        return node;
    }
}
