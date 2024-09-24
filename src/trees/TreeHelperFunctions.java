package com.company.trees;

public class TreeHelperFunctions {
    public static BTNode getBinaryTree() {
        /* Construct the following tree
                 44
                /  \
               /    \
              9     13
             / \    / \
            4   5  6   7
        */

//        BTNode root = new BTNode(44);
//        root.left = new BTNode(9);
//        root.right = new BTNode(13);
//        root.left.left = new BTNode(4);
//        root.left.right = new BTNode(5);
//        root.right.left = new BTNode(6);
//        root.right.right = new BTNode(7);

        BTNode root = new BTNode(18);
        root.left = new BTNode(9);
        root.left.left = new BTNode(9);
//        root.right = new BTNode(10);
        return root;
    }

    public static int  heightRec(BTNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeHeight  = 1 + heightRec(root.left);
        int rightSubTreeHeight  = 1 + heightRec(root.right);
        return leftSubTreeHeight> rightSubTreeHeight? leftSubTreeHeight: rightSubTreeHeight;
    }
    public static BTNode getNodeFromTree(BTNode root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
        }
        BTNode leftNodeCheck = getNodeFromTree(root.left, data);
        if (leftNodeCheck != null) {
            return leftNodeCheck;
        }

        BTNode rightNodeCheck = getNodeFromTree(root.right, data);
        return rightNodeCheck;
    }

    public static boolean isNodePartOfTree(BTNode root1, BTNode node) {
        if(root1 == null) {
            return false;
        }
        if((root1!=null && node != null) && (root1 == node)){
            return true;
        }
        boolean checkingLeftTree =  isNodePartOfTree(root1.left, node);
        boolean checkingRightTree =  isNodePartOfTree(root1.right, node);
        return checkingLeftTree || checkingRightTree;
    }

    public static boolean areTreesSame(BTNode roo1, BTNode root2) {
        if ((roo1 == null) && (root2 == null)) {
            return true;
        }
        return ((roo1 != null) && (root2!=null)) &&
                (roo1 == root2) &&
                (isTreesDataAndStructureSame(roo1.left, root2.left) &&
                        (isTreesDataAndStructureSame(roo1.right, root2.right)));
    }

    public static boolean isTreesDataAndStructureSame(BTNode roo1, BTNode root2) {
        if ((roo1 == null) && (root2 == null)) {
            return true;
        }
        return ((roo1 != null) && (root2!=null)) &&
                (roo1.data == root2.data) &&
                (isTreesDataAndStructureSame(roo1.left, root2.left) &&
                        (isTreesDataAndStructureSame(roo1.right, root2.right)));
    }

    public static int getLevelOfNode(BTNode root, BTNode node) {
        return getLevel(root, node, 1);
    }

    private static int getLevel(BTNode root, BTNode node, int level) {
        if (root == null) {
            return 0;
        }
        if (root == node) {
            return level;
        }
        int leftCheck =  getLevel(root.left, node, level+1);
        int rightCheck =  getLevel(root.right, node, level+1);
        return leftCheck>rightCheck ? leftCheck: rightCheck;
    }

    public static BTNode getParent(BTNode root, BTNode node) {
        if (root == null) {
            return null;
        }
        if (root.left == node || root.right == node) {
            return root;
        }

        BTNode leftCheck =  getParent(root.left, node);
        if(leftCheck != null) {
            return leftCheck;
        }

        BTNode rightCheck =  getParent(root.right, node);
        return rightCheck;
    }
}
