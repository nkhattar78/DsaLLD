package trees;

import java.util.concurrent.atomic.AtomicInteger;

public class LCAofBTInSingleTraversal {
    public static void mainFn() {
        int[] data = {1,2,3,4,5,6,7};
        BTNode root = SortedArrayToBST.sortedArrayToBST(data, 0, data.length-1);
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        BTNode lca = lcaInOneTraversal(root, 1,3);
        System.out.println("LCA node value: " + lca.data);
    }

    /**
     * Follow following steps to find LCA using one traversal
     *      If node data is same as data1 or data2 then return node
     *      Otherwise,
     *          Find call function for left sub-tree and right sub-tree which checks if the sub-tree contains data1 or data2.
     *          In case leftLCA and rightRCA both are not null this means data1 and data2 are in different sub-trees
     *          If either of leftLCA and rightRCA is null then that means both the nodes are in that sub=tree
     */
    private static BTNode lcaInOneTraversal(BTNode root, int data1, int data2) {
        if(root == null) {
            return null;
        }
        if(root.data == data1 || root.data == data2) {
            return root;
        }
        BTNode lcaLeft = lcaInOneTraversal(root.left, data1, data2);
        BTNode lcaRight = lcaInOneTraversal(root.right, data1, data2);

        if(lcaLeft != null && lcaRight!= null) {
            return root;
        }
        return lcaLeft==null? lcaRight:lcaLeft;
    }
}

