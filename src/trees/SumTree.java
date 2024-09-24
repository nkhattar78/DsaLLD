package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SumTree {
    public static void mainFn() {
        int[] data1 = {10,7,12, 5, 8, 11, 20};
        //int[] data1 = {10,7,12};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());

        ArrayList<BTNode> nodeList = new ArrayList<>();
        System.out.println("Checking Path sum");
        int sum = 23;
        printSumPath(binaryTree1.root, sum, sum, nodeList);
    }
    public static void printSumPath(BTNode root, int sumLeft, int sum, ArrayList<BTNode>  nodeList) {
        if (root == null) {
            return ;
        }
        nodeList.add(root);
        printPaths(nodeList, sum);
        printSumPath(root.left, sumLeft - root.data, sum, nodeList);
        printSumPath(root.right, sumLeft - root.data, sum, nodeList);

        //Remove the node as that has been processed.
        // In case it's a last node of the path then it's already printed.
        // Otherwise, just need to be removed from the list.
        nodeList.remove(root);
    }

    public static void checkSumTree() {
        BTNode root = TreeHelperFunctions.getBinaryTree();
        if(isSumTree(root) == Integer.MIN_VALUE) {
            System.out.println("This is not a sum tree");
        } else {
            System.out.println("This is a sum tree");
        }
    }

    public static void convertTreeIntoSumTree() {
        int[] data1 = {10,7,12, 6, 8, 11, 20};
        //int[] data1 = {10,7,12};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
        transformTree(binaryTree1.getRoot());
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
    }

    public static void printSumPathStartFromRoot(BTNode root, int sum, ArrayList<BTNode>  nodeList) {
        if (root == null) {
            return ;
        }

        nodeList.add(root);
        if (sum == root.data) {
            for (int i=0;i<nodeList.size();i++) {
                System.out.print(nodeList.get(i).data + " " );
            }
            System.out.println();
        }
        printSumPathStartFromRoot(root.left, sum - root.data, nodeList);
        printSumPathStartFromRoot(root.right, sum - root.data, nodeList);

        //Remove the node as that has been processed.
        // In case it's a last node of the path then it's already printed.
        // Otherwise, just need to be removed from the list.
        nodeList.remove(root);
    }

    public static boolean hasSumPathStartFromRoot(BTNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (sum == root.data) {
            return true;
        }
        boolean leftSubTreeValidation = hasSumPathStartFromRoot(root.left, sum - root.data);
        if (leftSubTreeValidation == true) {
            return true;
        }
        boolean rightSubTreeValidation = hasSumPathStartFromRoot(root.right, sum - root.data);
        return rightSubTreeValidation;
    }

    private static int isSumTree(BTNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.data;
        }

        int leftSum = isSumTree(root.left);
        int rightSum = isSumTree(root.right);

        if( (leftSum != Integer.MIN_VALUE) && (rightSum != Integer.MIN_VALUE) && (root.data == (leftSum + rightSum))) {
            return 2* root.data;
        }
        return Integer.MIN_VALUE;
    }


    private static int transformTree(BTNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = transformTree(root.left);
        int rightSum = transformTree(root.right);
        int oldData = root.data;
        root.data = leftSum + rightSum;
        return oldData + root.data;
    }

    private static void printPaths(ArrayList<BTNode> nodesList, int sum) {
        int sumCheck = 0;
        for(int i = nodesList.size()-1; i>=0; i--) {
            sumCheck += nodesList.get(i).data;
            if (sum == sumCheck) {
                for (int j=i; j<nodesList.size();j++) {
                    System.out.print(nodesList.get(j).data + " ");
                }
                System.out.println();
            }
        }
    }

}
