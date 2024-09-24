package com.company.trees;

import java.util.concurrent.atomic.AtomicInteger;

public class CreateBSTFromPreorder {

    public static void mainFn() {
        int preorder[] = new int[] { 10, 5, 1, 7, 40, 50 };
//        int preorder[] = new int[] { 10, 5, 40};
        AtomicInteger index = new AtomicInteger(0);
        BTNode root = createBSTFromPreorderTraversal(preorder, index, 0, preorder.length-1, preorder.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
    }

    private static BTNode createBSTFromPreorderTraversal(int[] preOrder,AtomicInteger index, int low, int high, int size) {
        if((low>high) || (index.get() > size)) {
            return null;
        }
        BTNode node = new BTNode(preOrder[low]);
        index.set(index.get() + 1);
        if(index.get() > size) {
            return node;
        }

        int i = searchIndex(preOrder, preOrder[low], low+1, high);
        node.left = createBSTFromPreorderTraversal(preOrder, index, low + 1, i-1, size);
        node.right = createBSTFromPreorderTraversal(preOrder, index, i , high, size);
        return node;
    }

    private static int searchIndex(int[] array, int element, int low, int high) {
        int i =0;
        for (i=low;i<=high;i++) {
            if (array[i] > element)
                break;
        }
        return i;
    }

}
