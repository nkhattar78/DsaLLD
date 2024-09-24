package trees;

import java.util.*;

public class VerticalTraversal {
    static TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    public static void mainFn() {
        int[] data1 = {10,7,12, 6, 8, 11, 20};
        //int[] data1 = {10,7,12};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
        System.out.println("Vertical traversal of the tree");
        verticalTraversalOfBT(binaryTree1.root, 0);
        printMap();
    }

    private static void verticalTraversalOfBT(BTNode root, int distance) {
        if(root == null) return;

        if(map.get(distance) ==  null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(distance, list);
        } else {
            List<Integer> list = map.get(distance);
            list.add(root.data);
        }
        verticalTraversalOfBT(root.left, distance - 1);
        verticalTraversalOfBT(root.right, distance + 1);
    }

    private static void printMap() {
        for (Map.Entry entry:map.entrySet()) {
            System.out.print("Distance: " + entry.getKey());
            List<Integer> list = (List<Integer>) entry.getValue();
            while (!list.isEmpty()) {
                int num = list.remove(0);
                System.out.print(" " + num + " ");
            }
            System.out.println();
        }
    }
}
