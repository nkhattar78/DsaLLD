package trees;

import java.util.concurrent.atomic.AtomicBoolean;

public class BalancedTree {
    public static void mainFn() {
        BTNode root = createTree();
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        AtomicBoolean isBalanced = new AtomicBoolean();
        isBalanced.set(true);
        isBalancedTree(root, isBalanced);

        System.out.println("Is tree balanced: "  + isBalanced.get());
    }

    /**
     * 2 approaches:
     * 1. Brute Force Approach: Calculate the lheight and rHeight of each node, see the diff.
     * If the difference is more than 1 then return false
     * Time Complexity O(n*n)
     *
     * 2. Optimized approach:
     * Instead of calculating the height of left and right subtree for every node, we can get the height in constant time.
     * Idea is to start from bottom of the tree and return the height of the subtree rooted at the given node to its parent.
     * The height of a subtree rooted at any node is one more than the max height of the left and right subtree.
     *
     * For this we need to pass the isBalanced flag by reference and so will use atomic variable.
     */
    private static int isBalancedTree(BTNode root, AtomicBoolean isBalanced) {
        // If root is null or isBalanced is false
        if((root == null) || (!isBalanced.get())) {
            return 0;
        }

        int lHeight = isBalancedTree(root.left, isBalanced);
        int rHeight = isBalancedTree(root.right, isBalanced);

        if(Math.abs(lHeight-rHeight)>1) {
            isBalanced.set(false);
        }
        return Math.max(lHeight, rHeight) +1;
    }

    private static int isBalancedTreeTemp(BTNode root, Boolean isBalanced) {
        // If root is null or isBalanced is false
        if((root == null) || (!isBalanced)) {
            return 0;
        }

        int lHeight = isBalancedTreeTemp(root.left, isBalanced);
        int rHeight = isBalancedTreeTemp(root.right, isBalanced);

        if(Math.abs(lHeight-rHeight)>1) {
            isBalanced = false;
        }
        return Math.max(lHeight, rHeight) +1;
    }
//    private static int getHeightDiffInLeftAndRightSubTrees(BTNode root) {
//        if(root == null) {
//            return true;
//        }
//    }

    private static BTNode createTree() {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(2);
        root.left.left = new BTNode(3);
//        root.right.right = new BTNode(3);
        return root;
    }
}
