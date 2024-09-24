package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class CheckIfArrayRepresentsPreorderTraversalOfBST {
    public static void mainFn() {
        int[] data = {40,30,35,80,100};

        BTNode root = createBST(data, new AtomicInteger(0), 0, data.length-1, data.length-1);
        int[] inorderData = new int[data.length];
        fillInorder(root, inorderData, new AtomicInteger(0));
        System.out.println("Pre-order traversal represented BST: " + isArraySorted(inorderData));
    }

    private static void fillInorder(BTNode root, int[] array, AtomicInteger index) {
        if(root == null) {
            return;
        }

        fillInorder(root.left, array, index);
        array[index.get()] = root.data;
        index.set(index.get() + 1);
        fillInorder(root.right, array, index);
    }

    private static boolean isArraySorted(int[] array) {
        for (int i=0; i < array.length-1; i++) {
            if(array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static BTNode createBST(int[] preorderTraversal, AtomicInteger index, int low, int high, int size) {
        if(low > high || index.get()>size) {
            return null;
        }
        BTNode root = new BTNode(preorderTraversal[index.get()]);
        index.set(index.get() + 1);
        if (index.get() > size) {
            return root;
        }
        int i = searchIndex(preorderTraversal, root.data, low, high);
        root.left = createBST(preorderTraversal, index, low + 1, i-1, size);
        root.right = createBST(preorderTraversal, index, i, high, size);
        return root;
    }

    private static int searchIndex(int[] array, int element, int low, int high) {
        int i =0;
        for (i=low;i<=high;i++) {
            if (array[i] > element)
                break;
        }
        return i;
    }
}
