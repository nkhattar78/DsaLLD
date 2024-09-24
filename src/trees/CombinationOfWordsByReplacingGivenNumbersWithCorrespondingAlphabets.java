package trees;
// A class to store a binary tree node
class Node
{
    String key;
    Node left, right;

    // Constructor
    Node(String key)
    {
        this.key = key;
        left = right = null;
    }
}

public class CombinationOfWordsByReplacingGivenNumbersWithCorrespondingAlphabets
{
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Function to print all leaf nodes of the binary tree
    public static void print(Node node)
    {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.key + " ");
        }
        else {
            print(node.right);
            print(node.left);
        }
    }

    // Function to construct a binary tree where each leaf node contains
    // one unique combination of words formed
    public static void construct(Node root, int[] digits, int i)
    {
        // Base case: empty tree
        if (root == null || i == digits.length) {
            return;
        }

        // check if `digits[i+1]` exists
        if (i + 1 < digits.length)
        {
            // process current and next digit
            int sum = 10 * digits[i] + digits[i + 1];

            // if both digits can form a valid character, create the left child from it
            if (sum <= 26) {
                root.left = new Node(root.key + alphabet.charAt(sum - 1));
            }

            // construct the left subtree by remaining digits
            construct(root.left, digits, i + 2);
        }

        // process the current digit and create the right child from it
        root.right = new Node(root.key + alphabet.charAt(digits[i] - 1));

        // construct the right subtree by remaining digits
        construct(root.right, digits, i + 1);
    }

    public static void mainFn()
    {
        int[] digits = { 1, 2, 1 };

        // create an empty root
        Node root = new Node("");

        // construct binary tree
        construct(root, digits, 0);

        print(root);
    }
}

//public class CombinationOfWordsByReplacingGivenNumbersWithCorrespondingAlphabets {
//    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//
//    // Function to find all possible combinations of words formed
//    // by replacing given positive numbers with the corresponding
//    // character of the English alphabet
//    public static void recur(int[] digits, int i, String str)
//    {
//        // base case: all digits are processed in the current configuration
//        if (i == digits.length)
//        {
//            // print the string
//            System.out.println(str);
//            return;
//        }
//
//        int sum = 0;
//
//        // process the next two digits (i'th and (i+1)'th)
//        for (int j = i; j <= Integer.min(i + 1, digits.length - 1); j++)
//        {
//            sum = (sum * 10) + digits[j];
//
//            // if a valid char can be formed by taking one or both digits,
//            // append it to the output and recur for the remaining digits
//            if (sum > 0 && sum <= 26) {
//                recur(digits, j + 1, str + alphabet.charAt(sum - 1));
//            }
//        }
//    }
//
//    public static void findCombinations(int[] digits)
//    {
//        // base case
//        if (digits == null || digits.length == 0) {
//            return;
//        }
//
//        String str = "";
//        recur(digits, 0, str);
//    }
//
//    public static void mainFn()
//    {
//        int[] digits = { 1, 2 };
//
//        findCombinations(digits);
//    }
//}
