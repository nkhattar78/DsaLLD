package trees;

public class BoundaryOfBinaryTree {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        System.out.print("\nTree BoundaryLeaves right to left ");
        printLHSofBT(root);
        printLeafNodeLeftToRight(root.left);
        printLeafNodeLeftToRight(root.right);
        printRHSofBT(root);
    }

    private static void printLHSofBT(BTNode root) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
        printLHSofBT(root.left);
    }

    private static void printRHSofBT(BTNode root) {
        if (root == null) return;
        printRHSofBT(root.right);
        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
    }

    private static void printLeafNodeLeftToRight(BTNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeafNodeLeftToRight(root.left);
        printLeafNodeLeftToRight(root.right);
    }

    private static void printLeafNodeRightToLeft(BTNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeafNodeRightToLeft(root.right);
        printLeafNodeRightToLeft(root.left);
    }
}
