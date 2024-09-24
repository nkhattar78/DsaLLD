package com.company.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class TreeTraversals {
    public static void preOrderRecursion(BTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRecursion(root.left);
            preOrderRecursion(root.right);
        }
    }

    public static void inOrderRecursion(BTNode root) {
        if (root != null) {
            inOrderRecursion(root.left);
            System.out.print(root.data + " ");
            inOrderRecursion(root.right);
        }
    }

    public static void postOrderRecursion(BTNode root) {
        if (root != null) {
            postOrderRecursion(root.left);
            postOrderRecursion(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void printPreOrderIterativeUsingStack(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        BTNode currentNode = root;
        while (!stack.empty() || currentNode!= null) {
            if (currentNode != null) {
                System.out.print(currentNode.data + " ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
        System.out.println();
    }

    public static void printPostOrderIterativeUsingStack(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        Stack<BTNode> postOrderStack = new Stack<>();
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        BTNode currentNode = root;
        stack.push(currentNode);
        while (!stack.empty()) {
            currentNode = stack.pop();
            postOrderStack.push(currentNode);
            if(currentNode.left!= null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        while (!postOrderStack.isEmpty()) {
            currentNode = postOrderStack.pop();
            System.out.print(currentNode.data + " ");
        }
        System.out.println();
    }

    public static void printInOrderIterativeUsingStack(BTNode root) {
        Stack<BTNode> stack = new Stack<>();
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        BTNode currentNode = root;
        while (!stack.empty() || currentNode!= null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.right;
            }
        }
        System.out.println();
    }

    public static void printGivenLevel(BTNode root, int level) {
        printLevel(root, 1, level);
    }

    private static void printLevel(BTNode root, int level, int giveLevel) {
        if (root == null) {
            return;
        }
        if (level == giveLevel) {
            System.out.print(root.data + " ");
        }
        printLevel(root.left, level + 1, giveLevel);
        printLevel(root.right, level + 1, giveLevel);
    }

    public static void printLevelOrderTraversalWithEachLevelOnDiffLine(BTNode root) {
        Queue<BTNode> queue = new LinkedList<>();
        int currentLevelCounter =0;
        int height = 0;
        if (root == null) {
            return;
        }
        System.out.println("Level order traversal of the tree");
        queue.add(root);
        currentLevelCounter++;
        BTNode currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.print(currentNode.data + " ");
            currentLevelCounter--;
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
            if(currentLevelCounter == 0) {
                System.out.println();
                currentLevelCounter = queue.size();
                height++;
            }
        }
        System.out.println();
        System.out.println("Tree height: " + height);
    }

    public static void printLevelOrderTraversal(BTNode root) {
        Queue<BTNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        System.out.print("Level order traversal of the tree is: ");
        queue.add(root);
        BTNode currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.println();
    }
    public static void printLeafNodes(BTNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    public static void printLeafToRoot(BTNode root, BTNode leaf, AtomicBoolean leafFound) {
        if (root == null) return;

        printLeafToRoot(root.left, leaf, leafFound);
        printLeafToRoot(root.right, leaf, leafFound);
        if (root == leaf) {
            leafFound.set(true);
        }
        if(leafFound.get()) {
            System.out.print(root.data + " ");
        }
    }

}
