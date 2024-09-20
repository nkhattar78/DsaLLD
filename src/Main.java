//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StringFunctions stringFunctions = new StringFunctions("xaabbcccd");
        ArrayListBasics arrayListBasics = new ArrayListBasics();
        HashmapBasics hashmapBasics = new HashmapBasics();
        StackFunctions stackFunctions = new StackFunctions();
        SortSearchFunctions sortSearchFunctions = new SortSearchFunctions();

        //System.out.println(stringFunctions.countSubStringsOfDistinctChars("aaa", 1));
//        int[] arr = {1,1,1, 2,3,3,4,4};
//        System.out.println(new ArraysFunctions().removeDuplicatesFromSortedArray(arr));
//        ArraysFunctions.printArray(arr);
        stringFunctions.partitionLabels("aeccbeby");

        //testRecursionFunctions();

    }

    static void testRecursionFunctions() {
        Recursion recursion = new Recursion();
        //recursion.printNumberInDecOrder(3);
//        recursion.sumNumbers(1, 10, 0);
//        System.out.println("Recursion answer: " + recursion.findFactorial(5));;
//        recursion.printFibonacciSeries(10);
//        int x = 2, y=10;
//        System.out.println("Value of "+  x +  " to the power of " + y + " is : " + recursion.powFunc(x,y));
//        System.out.println("Optimized Approach: Value of "+  x +  " to the power of " + y + " is : " + recursion.powFuncOptimizedStackHtLogN(x,y));
//        recursion.printStringSubsequences("abc");
//        recursion.printUniqueSubSequence("acdefbbb");
//        recursion.printStringInReverse("abcd");
//        recursion.firstAndLastOccuOfChar("abcdba", 'b');
//        int[] arr = {1,3,5,7,8,9,11,12,13,1,3,5,6,7};
//        recursion.checkIfArrayIsStrictlySorted(arr);
        recursion.removeAllDuplicatesChars("abcxdxefex");

    }

    static void testLinkListFunctions() {
//        int[] arr = {1,2,3,4,5,6,7};
//        LinkLIst linkLIst = new LinkLIst(arr);
//        linkLIst.printLinkList();
//        linkLIst.reverseLinkList();
//        linkLIst.printLinkList();
        LinkLIst linkLIst = new LinkLIst();
        linkLIst.mergeTwoLinklistsInline();
    }
    static void testBitsOperation() {
        BitOperations bitOperations = new BitOperations(9, 1);
        bitOperations.getBit();
        bitOperations.setBit();
        bitOperations.clearBit();
        bitOperations.updateBit();
    }
}