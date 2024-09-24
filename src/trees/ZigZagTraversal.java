package trees;

import java.util.LinkedList;

public class ZigZagTraversal {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
//        int[] data = {1,2,3};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        printLevelOrder(root);
        ziZagTraversal(root);
    }

    static private void printLevelOrder(BTNode root) {
        if(root == null) {
            return;
        }
        LinkedList<BTNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int listSize = list.size();
            for (int i = 0;i < listSize;i++) {
                BTNode currentNode = list.remove();
                System.out.print(currentNode.data + " ");
                if(currentNode.left!= null) {
                    list.add(currentNode.left);
                }
                if(currentNode.right!= null) {
                    list.add(currentNode.right);
                }
            }
            System.out.println();
        }
    }
    static private void ziZagTraversal(BTNode root) {
        if(root == null) {
            return;
        }
        LinkedList<BTNode> list = new LinkedList<>();
        boolean leftToRight = true;
        list.add(root);
        while (!list.isEmpty()) {
            int listSize = list.size();
            for (int i = 0;i < listSize;i++) {
                if (leftToRight) {
                    BTNode currentNode = list.remove();
                    System.out.print(currentNode.data + " ");
                    if(currentNode.left!= null) {
                        list.add(currentNode.left);
                    }
                    if(currentNode.right!= null) {
                        list.add(currentNode.right);
                    }
                } else {
                    BTNode currentNode = list.removeLast();
                    System.out.print(currentNode.data + " ");
                    if(currentNode.right!= null) {
                        list.addFirst(currentNode.right);
                    }
                    if(currentNode.left!= null) {
                        list.addFirst(currentNode.left);
                    }
                }
            }
            System.out.println();
            leftToRight = !leftToRight;
        }
    }
}
