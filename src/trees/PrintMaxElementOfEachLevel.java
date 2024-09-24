package com.company.trees;

import java.util.LinkedList;

public class PrintMaxElementOfEachLevel {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        printMaxElementOfEachLevel(root);
    }
    private static void printMaxElementOfEachLevel(BTNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BTNode> list = new LinkedList<>();
        list.add(root);
        BTNode tempNode = new BTNode();
        list.add(tempNode);
        int max = Integer.MIN_VALUE;
        while (!list.isEmpty()) {
            BTNode currentNode = list.remove();
            if (currentNode == tempNode) {
                System.out.println(max);
                max = Integer.MIN_VALUE;
                if(list.size() == 0) {
                    break;
                }
                list.add(tempNode);
            } else {
                if (currentNode.data > max) {
                    max = currentNode.data;
                }
//              System.out.print(currentNode.data + " ");
                if(currentNode.left!= null) {
                    list.add(currentNode.left);
                }
                if(currentNode.right!= null) {
                    list.add(currentNode.right);
                }
            }
        }
    }
}
