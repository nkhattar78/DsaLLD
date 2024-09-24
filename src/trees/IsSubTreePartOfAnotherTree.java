package com.company.trees;

public class IsSubTreePartOfAnotherTree {
    public static void mainFn() {
        int[] data1 = {10,7,12, 6, 8, 11, 20};
        int[] data2 = {10,7,12, 6, 8, 11, 20};
        //int[] data1 = {10,7,12};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        BinaryTree binaryTree2 = new BinaryTree(data2, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
        System.out.println("Checking is tree part of subtree: " + isSubTreeOfAnotherTree(binaryTree1.root, binaryTree1.root.left));
    }

    public static boolean isSubTreeOfAnotherTree(BTNode mainTreeRoot, BTNode subTreeRoot) {
        BTNode subTreeNodeInMainTree =  TreeHelperFunctions.getNodeFromTree(mainTreeRoot, subTreeRoot.data);
        if (subTreeNodeInMainTree != null) {
            //getNodeFromTree can be optimized further to check for data as well as node address.
            //Here not checking node address to keep getNodeFromTree function generic.
            return (TreeHelperFunctions.isNodePartOfTree(mainTreeRoot, subTreeRoot) &&
                    (TreeHelperFunctions.areTreesSame(subTreeNodeInMainTree, subTreeRoot)) );
        } else {
            return false;
        }
    }
}
