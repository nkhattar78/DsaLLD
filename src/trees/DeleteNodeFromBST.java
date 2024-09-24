package com.company.trees;

import static com.company.trees.SortedArrayToBST.sortedArrayToBST;



public class DeleteNodeFromBST {
    public static void mainFn() {
        int data[] = new int[] { 1, 5, 7,10, 40, 50};
        BTNode root = sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        root = deleteNodeFromBST(root, root.data);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
    }

    private static BTNode deleteNodeFromBST(BTNode root, int element) {
        if (root == null) return  null;

        /**
         If element is smaller than root, traverse left otherwise traverse right to reach to the required node
         root.left/root.right assignment does the magic of attaching parent of sub-tree to the next of deleted node.
         */
        if (element< root.data) {
            root.left = deleteNodeFromBST(root.left, element);
        }else if (element > root.data) {
            root.right = deleteNodeFromBST(root.right, element);
        } else {
            /**
             Reached to the node which is required to be deleted. Now there are 3 cases here:
             1. Node to be deleted is a leaf node, just return null
             2. Node to be deleted has left or right node null, then just return the other child
             3. Node to be deleted has 2 children.
                 a. Get the inorder successor and put that in the root
                Now inorder successor value is there at 2 places, one in root and other at its original place
                Delete the inorder successor value from the original place now. For that
                b. Call deleteNodeFromBST function recursively from the right sub-tree of the root.
             */
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = getMinValue(root.right);
                root.right = deleteNodeFromBST(root.right, root.data);
            }
        }
        return root;
    }

    private static int getMinValue(BTNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
}
