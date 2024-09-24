package trees;

import java.util.concurrent.atomic.AtomicInteger;

/**
 2 approaches:
 1. Brute force approach:
    a. Compare the node value with all children, if all are equal then true
    b. Count for how many nodes, step a returns true
 Complexity :O(n*n)

 2. Optimized approach: Do bottom-up traversal. For every subtree visited, return true if subtree rooted under it is single valued and so increment the count.
 Here need to pass the increment count parameter as reference.
 */

public class SingleValuesSubTreeCount {
    public static void mainFn() {
        BTNode root = createTree();
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        AtomicInteger singleValuedTreeeCount = new AtomicInteger(0);
        getSingleValuedSubTreeCount(root, singleValuedTreeeCount);
        System.out.println("Number of valued trees: " + singleValuedTreeeCount.get());
    }

    private static boolean getSingleValuedSubTreeCount(BTNode root, AtomicInteger count) {
        if(root == null) {
            return true;
        }

        //Check if left subtree is single valued
        boolean isLeftTreeSinglValued = getSingleValuedSubTreeCount(root.left, count);
        //Check if right subtree is single valued
        boolean isRightTreeSinglValued = getSingleValuedSubTreeCount(root.right, count);

        //If either left or right subtree is not single valued, then current subtree can't be single valued
        if(isLeftTreeSinglValued == false || isRightTreeSinglValued == false) {
            return false;
        }

        //If left subtree is not null then current node data and left node data has to be same for single valued sub-tree otherwise return false
        if (root.left!= null && root.left.data!=root.data) {
            return false;
        }

        //If right subtree is not null then current node data and right node data has to be same for single valued sub-tree otherwise return false
        if (root.right!= null && root.right.data!=root.data) {
            return false;
        }

        //If all the above conditions are not met then current sub-tree is single valued, increment the count and return true.
        count.set(count.get() + 1);
        return true;
    }

    private static BTNode createTree() {
        BTNode root = new BTNode(5);
        root.left = new BTNode(4);
        root.right = new BTNode(5);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(4);
        root.right.right = new BTNode(5);
        return root;
    }
}
