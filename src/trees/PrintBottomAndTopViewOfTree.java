package trees;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class PrintBottomAndTopViewOfTree {
    static LinkedHashMap<Integer, NodewithLevel> map = new LinkedHashMap<>();
    public static void mainFn() {
        int[] data1 = {10,7,12, 6, 8, 11, 20};
        //int[] data1 = {10,7,12, 6};
        BinaryTree binaryTree1 = new BinaryTree(data1, true);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(binaryTree1.getRoot());
        System.out.println("Bottom view of the tree");
        printBottom(binaryTree1.getRoot(), 0, 0, map);
        printMap();
        map = new LinkedHashMap<>();
        System.out.println("Top view of the tree");
        printTop(binaryTree1.getRoot(), 0, 0, map);
        printMap();
    }

    private static void printMap() {
        for(Map.Entry entry:map.entrySet() ) {
            NodewithLevel nodewithLevel = (NodewithLevel) entry.getValue();
            System.out.print(nodewithLevel.node.data + " ");
        }
        System.out.println();
    }

    static void printTop(BTNode root, int distance , int level, HashMap<Integer, NodewithLevel> map) {
        if(root == null) {
            return;
        }

        printTop(root.left, distance - 1, level + 1, map);
        if (map.containsKey(distance)) {
            if(level < map.get(distance).level) {
                map.put(distance, new NodewithLevel(root, level));
            }
        } else {
            map.put(distance, new NodewithLevel(root, level));
        }
        printTop(root.right, distance + 1, level + 1, map);
    }

    static void printBottom(BTNode root, int distance , int level, HashMap<Integer, NodewithLevel> map) {
        if(root == null) {
            return;
        }

        printBottom(root.left, distance - 1, level + 1, map);
        if (map.containsKey(distance)) {
            if(level > map.get(distance).level) {
                map.put(distance, new NodewithLevel(root, level));
            }
        } else {
            map.put(distance, new NodewithLevel(root, level));
        }
        printBottom(root.right, distance + 1, level + 1, map);
    }
}

class NodewithLevel {
    BTNode node;
    int level;

    public NodewithLevel(BTNode node, int level) {
        this.node = node;
        this.level = level;
    }
}