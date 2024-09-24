package trees.AVL;

import java.util.LinkedList;

public class AVLTreeImplementation {
    public static void mainFn(){
//        int[] dataArray = {4,6,2,1,3,5,7};
        //int[] dataArray = {1,2,3,4,5,6,7};
        int[] dataArray = {7,6,5,4,3,2,1};
        AVLNode root = createAVLTree(dataArray);
        levelWiseTraversal(root);
        updateHeight(root);
        System.out.println("Root Height: " + root.height);
    }

    private static AVLNode createAVLTree(int[] data) {
        if (data.length ==0) return null;
        AVLNode root = new AVLNode(data[0]);
        for (int i=1; i<data.length;i++) {
            root = insertRec(root, new AVLNode(data[i]));
        }
        return root;
    }

    private static AVLNode insertRec(AVLNode root, AVLNode node) {
        if (root == null) return node;
        if (node.data > root.data ) {
            root.right = insertRec(root.right, node);
        } else {
            root.left = insertRec(root.left, node);
        }

        /** After node is added at the right place, rest of the code will be called for:
         *      All ancestors come from root to added node path
         *      Ancestor will be travelled from parent of added node to the root of the tree
         * THIS HAPPENS DUE TO RECURSION USED AND THE FUNCTION WAS CALLED STARTING FROM ROOT TILL THE PARENT OF ADDED NODE
         *
         * After insertion, to re-balance the trees we need to:
         * 1. Update the height of the node coming in ancestor path
         * 2. Get node balance
         * 3. Check for all 4 conditions, LL, LR, RR, RL. In case of any condition, perform the right operation*/


        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        int balance = getNodeBalance(root);
        if (balance<-1 || balance>1) {
            /** Current ancestor is not balanced and so need to be rectified.*/
            System.out.println("Unbalanced Node " + root.data);

            /** Checking RR case */
            if (balance < -1 && node.data > root.right.data) {
                System.out.println("RR Case");
                return rotateLeft(root);
            }

            /** Checking RL case */
            if (balance < -1 && node.data < root.right.data) {
                System.out.println("RL Case");
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }

            /** Checking LL case */
            if (balance > 1 && node.data < root.left.data) {
                System.out.println("LL Case");
                return rotateRight(root);
            }

            /** Checking LR case */
            if (balance > 1 && node.data > root.left.data) {
                System.out.println("LR Case");
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }
        return root;
    }

    private static int getNodeBalance(AVLNode node) {
        int result = 0, lHeight, rHeight;
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private static int getHeight(AVLNode node) {
        if (node == null){
            return 0;
        }
        return node.height;
    }

    private static AVLNode insert(AVLNode root, int data) {
        AVLNode node = new AVLNode(data);
        if (root == null) {
            return node;
        } else{
            AVLNode current = root;
            while (current!= null) {
                if (data < current.data ) {
                    if (current.left == null) {
                        current.left = node;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = node;
                        break;
                    }
                    current = current.right;
                }
            }
        }
        return root;
    }

    private static AVLNode findNode(AVLNode root, int data) {
        AVLNode node = null;
        while (root !=null) {
            if (root.data == data) {
                node = root;
                break;
            } else if (data > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return node;
    }

    private static void delete(AVLNode root, int data) {
        AVLNode nodeToBeDeleted = findNode(root, data);
        AVLNode tempNode = null;
        /** If there is no children of the node to be deleted. Just delete that node*/
        if (nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
            nodeToBeDeleted = null;
        }
        /** If one child is null
         * Copy the data, left and right children of the child node to the deleted node.  */
        else if (nodeToBeDeleted.left == null || nodeToBeDeleted.right == null) {
            if (nodeToBeDeleted.left == null) {
                nodeToBeDeleted.data = nodeToBeDeleted.right.data;
                nodeToBeDeleted.left = nodeToBeDeleted.right.left;
                nodeToBeDeleted.right = nodeToBeDeleted.right.right;
            } else {
                nodeToBeDeleted.data = nodeToBeDeleted.left.data;
                nodeToBeDeleted.left = nodeToBeDeleted.left.left;
                nodeToBeDeleted.right = nodeToBeDeleted.left.right;
            }
        }
        /** If node to be deleted has 2 children then find the inorder successor or predecessor
         * Copy the data of successor/predecessor to the node to be deleted
         * Call the delete function with nodeToDelete.right if successor was chosen else
         * Call the delete function with nodeToDelete.left if predecessor was chosen*/
        else {
            AVLNode inorderSuccessor = getMinNode(nodeToBeDeleted.right);
            nodeToBeDeleted.data = inorderSuccessor.data;
            delete(nodeToBeDeleted.right, data);
        }
    }

    private static AVLNode getMinNode(AVLNode root) {
        if (root.left == null) {
            return root;
        } else {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    private static AVLNode getMaxNode(AVLNode root) {
        if (root.right == null) {
            return root;
        } else {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    private static int updateHeight(AVLNode root) {
        if (root == null) return 0;
        int leftHt = updateHeight(root.left);
        int rightHt = updateHeight(root.right);
        root.height = 1 + Math.max(leftHt, rightHt);
        return root.height;
    }

    private static AVLNode rotateLeft(AVLNode root) {
        AVLNode newRoot = root.right;
        AVLNode tmpNode = newRoot.left;
        newRoot.left = root;
        root.right = tmpNode;

        /** Height needs to be updated for root and newRoot nodes, rest all will remain as is */
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private static AVLNode rotateRight(AVLNode root) {
        AVLNode newRoot = root.left;
        AVLNode tmpNode = newRoot.right;
        newRoot.right = root;
        root.left = tmpNode;

        /** Height needs to be updated for root and newRoot nodes, rest all will remain as is */
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));

        return newRoot;
    }

    private static void levelWiseTraversal(AVLNode root) {
        LinkedList<AVLNode> list = new LinkedList<>();
        AVLNode node= null;
        list.add(root);

        while (!list.isEmpty()) {
            int listSize = list.size();
             for (int i =0; i<listSize;i++) {
                 node = list.removeFirst();
                 System.out.print(node.data + " ");
                 if (node.left != null) {
                     list.add(node.left);
                 }
                 if (node.right != null) {
                     list.add(node.right);
                 }
             }
            System.out.println();
        }
    }

    private static void preOrderTraversal(AVLNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void postOrderTraversal(AVLNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    private static void inOrderTraversal(AVLNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
}

