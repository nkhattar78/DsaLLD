package trees;

public class MaxGCDofSiblings {
    public static void mainFn() {
        //int[] data = {1,2,3,4,5,6,7};
        int[] data = {10,12,14};
        BTNode root = createTree();
        TreeTraversals.printLevelOrderTraversalWithEachLevelOnDiffLine(root);
        System.out.println("Max GCD of siblings is: " +  maxGCDofSiblingsInBT(root));
    }


    private static int maxGCDofSiblingsInBT(BTNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
           return 1;
        }
        int maxGCD = 1;
        if(root.left!=null && root.right!= null) {
            maxGCD = getGCD(root.left.data, root.right.data);
        }
        int maxLeft = maxGCDofSiblingsInBT(root.left);
        if(maxLeft>maxGCD) {
            maxGCD = maxLeft;
        }
        int maxRight = maxGCDofSiblingsInBT(root.right);
        if(maxRight>maxGCD) {
            maxGCD = maxRight;
        }
        return maxGCD;
    }

    private static int getGCD(int a, int b) {
        if(a==1||b==1) {
            return 1;
        }
        if (a==0) {
            return b;
        }
        if (b==0) {
            return a;
        }
        if (a>b) {
            return getGCD(b, a%b);
        } else {
            return getGCD(a, b%a);
        }
    }

    private static BTNode createTree() {
        BTNode root = new BTNode(4);
        root.left = new BTNode(5);
        root.right = new BTNode(2);
        root.right.right = new BTNode(36);
        root.right.left = new BTNode(48);
        root.right.left.left = new BTNode(6);
        root.right.left.right = new BTNode(12);
        return root;
    }
}
