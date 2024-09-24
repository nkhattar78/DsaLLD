package trees.AVL;
class IntervalTree {
    int low, high, max;
    IntervalTree left, right;

    public IntervalTree(int low, int high) {
        this.low = low;
        this.high = high;
        this.max = high;
    }

    public IntervalTree() {

    }
}

public class CalendarConflicts {
    /**
     * If we just sort the interval based on start time or end time, then it will be difficult to check for cases when in slots are very big
     * So, to solve that, we use AVL type of tree. Instead of keeping the height, we will keep the max end time of that tub-tree in the node
              15,20
                35(maximum end time in sub-tree)
              /  \
            /     \
           12,15  25,35
            15     35
     */
        public static void mainFn() {
            IntervalTree root = createIntervalTree();
            System.out.println("Calendar conflict program");
            IntervalTree node1 = new IntervalTree(5,10);
            IntervalTree node2 = new IntervalTree(2,5);
            System.out.println("Are nodes conflicting: " + isConflicting(node1, node2));

            node1 = new IntervalTree(6,7);
            findConflictingSlot(root, node1);
        }

        private static IntervalTree createIntervalTree() {
            IntervalTree root =  new IntervalTree(15,20);
            root = insertNode(root, new IntervalTree(10,30));
            root = insertNode(root, new IntervalTree(12,15));
            root = insertNode(root, new IntervalTree(5,20));
            root = insertNode(root, new IntervalTree(17,19));
            root = insertNode(root, new IntervalTree(30,40));
            return root;
        }

    /**
     * Algorithm for finding conflicting slot is:
       1. If root node and given node are conflicting then, just return the root node
       2. If root.left exists and root.left.max > given interval start time, then check in left subtree
       3. Otherwise, check in right sub-tree of the root

     If we don't take the max value in picture, then just based on start/end time we may go to the wrong sub-tree
     and will not find the conflicting slot. */
    private static void findConflictingSlot(IntervalTree root, IntervalTree node) {
            if (root == null) return;

            if ( isConflicting(root, node) == true) {
                System.out.println("Conflicting slot for [" + node.low + ", " + node.high + "] is ["
                        + root.low + ", " + root.high + "]");
                return;
            }
            if (root.left!= null && root.left.max > node.low) {
                findConflictingSlot(root.left, node);
            } else {
                findConflictingSlot(root.right, node);
            }
        }

        private static boolean isConflicting(IntervalTree node1, IntervalTree node2) {
            if (node1.low < node2.low && node1.high < node2.low) {
                return false;
            }
            if (node1.low > node2.high && node1.high > node2.high) {
                return false;
            }
            return true;
        }

        private static IntervalTree insertNode(IntervalTree root, IntervalTree node) {
            if(root == null) return node;
            if (node.low < root.low) {
                root.left = insertNode(root.left, node);
            } else {
                root.right = insertNode(root.right, node);
            }
            if (root.max < getMax(root.left) || root.max < (getMax(root.right))) {
                root.max = Math.max(getMax(root.left), getMax(root.right));
            }
            return root;
        }

        private static int getMax(IntervalTree node) {
            if (node == null) return 0;
            return node.max;
        }
}
