package com.company.trees;


public class Mirror {
    public static void mainFn() {
        BTNode root = createTree();
        System.out.println("Tree is symmetric/mirror of itself: "  + isMirror(root));
//        int[] data1 = {10,7,12, 6, 8,11};
//        //int[] data1 = {10,7,12, 6};
//        BinaryTree binaryTree1 = new BinaryTree(data1, true);
//        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
//        convertToMirror(binaryTree1.root);
//        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
    }

    private static boolean isMirror(BTNode root) {
        return isMirror(root, root);
    }

    /**
     * Two trees are mirror to each other only if it meets these three condition:
     * 1. Value of the node has to be same of the both the trees
     * 2. Left of First tree is same as right of 2nd tee
     * 3. Right of first tree is same as left of 2nd tree.
     */
    private static boolean isMirror(BTNode root1, BTNode root2) {
        if( (root1 == null) && (root2 == null)) {
            return true;
        }

        if(((root1 !=null) && (root2!= null)) && (root1.data == root2.data)) {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
        return false;
    }


    /**
     * Use Post order traversal, so that reaches to node pointer after traversing left and right children
     * Swap the pointers of left and right children of the node
     */
    private static void convertToMirror(BTNode root) {
        if (root ==null) {
            return;
        }
        convertToMirror(root.left);
        convertToMirror(root.right);
        BTNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    private static BTNode createTree() {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(2);
        root.left.left = new BTNode(3);
        root.right.right = new BTNode(3);
        return root;
    }

}
