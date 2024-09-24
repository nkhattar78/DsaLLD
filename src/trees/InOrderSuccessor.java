package trees;

public class InOrderSuccessor {
    public static void mainFn() {
//        int[] data = {1,2,3,4,5,6,7};
        int[] data = {1};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        inOrderSuccessor(root, root);
    }

    private static void inOrderSuccessor(BTNode root, BTNode node) {
        if(root == node) {
            System.out.println("No parent");
            return;
        }
        BTNode inrderSuccessor = null;
        if(node.right == null) {
            inrderSuccessor = TreeHelperFunctions.getParent(root, node);
        } else {
            inrderSuccessor = node.right;
            while (inrderSuccessor.left != null) {
                inrderSuccessor = inrderSuccessor.left;
            }
        }
        System.out.println("In order successor of "  + node.data + " is " + inrderSuccessor.data);
    }
}
