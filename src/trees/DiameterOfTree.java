package trees;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfTree {
    /**
      https://www.techiedelight.com/find-diameter-of-a-binary-tree/
    2 solutions to this problem
     Brute force approach:
        a. Find height of left subtree and right subtree of each node.
        b. Then look for 1 + left subtree height + right subtree height
        c. Take the max of step b for all nodes

     Optimized Solution
     Instead of calculating height of left and right subtree of each node in the tree, get the height in constant time.
     The idea is to start from bottom of the tree and return the height of the subtree rooted at a given node to its parent.
     The height of the subtree rooted at any node is one more than the max height of the left or right subtree

     Trick here is to pass the variable diameter by reference to the recursive function.
     In Java we can use AtomicInteger for this purpose. Use get and set methods to get or set the value of atomic variable.
     */


    public static void mainFn() {
        //int[] data1 = {10,7,12, 6, 8,11};
        int[] data1 = {10,7,12, 6};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
        System.out.println("Tree diameter is: " + getTreeDiameter(binaryTree1.root));
    }
    static int getTreeDiameter(BTNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        getDiameter(root, diameter);
        return diameter.get();

    }
    static int getDiameter(BTNode root, AtomicInteger diameter) {
        if(root == null) {
            return 0;
        }
        int leftHeight = getDiameter(root.left, diameter);
        int rightHeight = getDiameter(root.right, diameter);
        diameter.set(Math.max((leftHeight + rightHeight +1), diameter.get()));

        //Here height has to be returned as recursive call of this function is supposed to return the height of the subtree
        return Math.max(leftHeight, rightHeight) +1;
    }

    static int getTreeDiameterBruteForce(BTNode root) {
        int diameter =0;
        List<NodeInfo> nodesList = new ArrayList<>();
        updateTreeNodes(root, nodesList);
        for (int i=0; i<nodesList.size(); i++) {
            if((nodesList.get(i).leftSubtreeHeight + nodesList.get(i).rightSubtreeHeight + 1) > diameter) {
                diameter = nodesList.get(i).leftSubtreeHeight + nodesList.get(i).rightSubtreeHeight + 1;
            }
        }
        return diameter;
    }

    static void updateTreeNodes(BTNode root, List<NodeInfo> nodesList) {
        if (root == null) {
            return;
        }
        NodeInfo nodeInfo = new NodeInfo(root, TreeHelperFunctions.heightRec(root.left), TreeHelperFunctions.heightRec(root.right));
        nodesList.add(nodeInfo);
        updateTreeNodes(root.left, nodesList);
        updateTreeNodes(root.right, nodesList);
    }

    static class NodeInfo{
        BTNode node;
        int leftSubtreeHeight;
        int rightSubtreeHeight;

        public NodeInfo(BTNode node, int leftSubtreeHeight, int rightSubtreeHeight) {
            this.node = node;
            this.leftSubtreeHeight = leftSubtreeHeight;
            this.rightSubtreeHeight = rightSubtreeHeight;
        }
    }
}
