package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class KthLargetElementInTree {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
        //int[] data = {1};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        AtomicInteger kthNum = new AtomicInteger();
        int k = 3;
        System.out.print("BST reverse in-order: ");
        inOrderTraversalReverse(root);
        System.out.println();

        System.out.print( k +" largest element in BST is: ");
        kthNum.set(k);
        kthLargestElementInBST(root, kthNum);
    }

    private static void kthLargestElementInBST(BTNode root, AtomicInteger kthNum) {
        if (root == null) {
            return;
        }
        kthLargestElementInBST(root.right, kthNum);
        if (kthNum.get() == 1) {
            System.out.println(root.data);
        }
        kthNum.set(kthNum.get() -1 );
        kthLargestElementInBST(root.left, kthNum);
    }

    private static void inOrderTraversalReverse(BTNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversalReverse(root.right);
        System.out.print(root.data + " ");
        inOrderTraversalReverse(root.left);
    }
}
