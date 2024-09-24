package com.company.trees;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 2 variants of this problem
 * 1. Provide only the sum. That is simple and just see function maxSumPath
 * 2. If path needs to be printed also then, need to do
 *      a. Get the leaf which is part of maxSumPath
 *      b. Print the path starting leaf found in step "a" to the root.
 */
public class MaxSumPathFromLeafToRoot {
    static class SumPath {
        int maxSum;
        BTNode leafPartOfMaxSumPath;

        public SumPath() {
            this.maxSum = 0;
            this.leafPartOfMaxSumPath = null;
        }
    }

    public static void mainFn() {
        //int[] data = {1,2,3,4,5,6,7};
        int[] data = {1,2,3};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        root.left.left = new BTNode(6);
        root.right.left = new BTNode(4);
        root.right.left.right = new BTNode(8);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        maxSumPath(root);
        System.out.println("Max Sum from Leaf to root: " + maxSumPath(root));

        printMaxPathSum(root);

//      root = createTree();
//      TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
//      System.out.println("Max Sum from Leaf to root: " + maxSumPath(root));
    }

    /**
     * If we just need to find the maxSumPath then we can use this function
     */
    private static int maxSumPath(BTNode root) {
        if(root == null) return 0;
        int lMax = maxSumPath(root.left);
        int rMax = maxSumPath(root.right);
        if (root.left == null && root.right == null) {
            return root.data;
        }
        return  lMax > rMax ? lMax+root.data : rMax + root.data;
    }

    /**
     *      a. Get the leaf which is part of maxSumPath
     *      b. Print the path starting leaf found in step "a" to the root.
     */
    private static void printMaxPathSum(BTNode root) {
        SumPath sumPathNode = new SumPath();
        getTargetLeafPartOfPathSum(root, 0, sumPathNode);
        System.out.println("Sum Path: " + sumPathNode.maxSum);
        System.out.print("Max sum path from leaf to root : ");
        TreeTraversals.printLeafToRoot(root, sumPathNode.leafPartOfMaxSumPath, new AtomicBoolean(false));

    }

    private static void getTargetLeafPartOfPathSum(BTNode root, int sum, SumPath sumPathInstance) {
        if(root == null) return ;
        sum = sum + root.data;

        if (root.left == null && root.right == null) {
            if (sum>sumPathInstance.maxSum) {
                sumPathInstance.leafPartOfMaxSumPath = root;
                sumPathInstance.maxSum = sum;
            }
        }
        getTargetLeafPartOfPathSum(root.left, sum, sumPathInstance);
        getTargetLeafPartOfPathSum(root.right, sum, sumPathInstance);
    }



    private static BTNode createTree() {
        BTNode root = new BTNode();
        root = new BTNode(-15);
        root.left = new BTNode(5);
        root.right = new BTNode(6);
        root.left.left = new BTNode(-8);
        root.left.right = new BTNode(1);
        root.left.left.left = new BTNode(2);
        root.left.left.right = new BTNode(6);
        root.right.left = new BTNode(3);
        root.right.right = new BTNode(9);
        root.right.right.right = new BTNode(0);
        root.right.right.right.left = new BTNode(4);
        root.right.right.right.right = new BTNode(-1);
        root.right.right.right.right.left = new BTNode(10);
        return root;
    }

}
