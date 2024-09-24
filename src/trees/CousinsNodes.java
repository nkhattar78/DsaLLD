package com.company.trees;

public class CousinsNodes {
    public static void mainFn() {
        int[] data1 = {10,7,12, 6, 8, 11, 20};
        //int[] data1 = {10,7,12};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
        printCousins(binaryTree1.root, binaryTree1.root.right.left);
//        boolean areCousin = areNodesCousins(binaryTree1.root, binaryTree1.root.left.left, binaryTree1.root.right.left);
//        if(areCousin) {
//            System.out.println("Nodes are cousins");
//        } else {
//            System.out.println("Nodes are not cousins");
//        }
    }

    static boolean areNodesCousins(BTNode root, BTNode node1, BTNode node2) {
        NodeInfo node1Info = new NodeInfo(node1, 0, null);
        NodeInfo node2Info = new NodeInfo(node2, 0, null);
        updateNodeInfo(root, null, 0, node1Info, node2Info);
        if(root == null || node1==null || node2 == null) {
            return false;
        }

        if((node1Info.level == node2Info.level) && (node1Info.parent != node2Info.parent)) {
            return true;
        }
        return false;
    }

    private static void printCousins(BTNode root, BTNode node) {
        NodeInfo nodeInfo = new NodeInfo(node, 0, null);
        nodeInfo.level = TreeHelperFunctions.getLevelOfNode(root, node);
        nodeInfo.parent = TreeHelperFunctions.getParent(root, node);
        printCousins(root,null, 1, nodeInfo);
    }

    private static void printCousins(BTNode root, BTNode parent, int level, NodeInfo nodeInfo) {
        if (root == null) {
            return;
        }
        if((level == nodeInfo.level) && (parent != nodeInfo.parent)){
            System.out.print(root.data + " ");
        }
        printCousins(root.left, root, level + 1, nodeInfo);
        printCousins(root.right, root, level + 1, nodeInfo);
    }


    private static void updateNodeInfo(BTNode root, BTNode parent, int level, NodeInfo node1Info, NodeInfo node2Info) {
        if (root == null) {
            return;
        }
        if (root == node1Info.node) {
            node1Info.parent = parent;
            node1Info.level = level + 1;
        }
        if (root == node2Info.node) {
            node2Info.parent = parent;
            node2Info.level = level + 1;
        }
        updateNodeInfo(root.left, root, level + 1, node1Info, node2Info);
        updateNodeInfo(root.right, root, level + 1, node1Info, node2Info);
    }

    static class NodeInfo {
        BTNode node;
        int level;
        BTNode parent;

        public NodeInfo(BTNode node, int level, BTNode parent) {
            this.node = node;
            this.level = level;
            this.parent = parent;
        }
    }
}

