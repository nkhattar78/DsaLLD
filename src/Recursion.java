import javax.xml.transform.Source;
import java.util.HashSet;
import java.util.Set;

public class Recursion {
    /*
    Time complexity and the number of times base condition is hit is dependent on the number of times you call the recursive function in the function body.
    For example, to printNum/Sum Numbers / Factorials/ Fibonacci series - we call recursive function once from function body, so the
        Complexity - O(n)
        Number of times - base condition will be true - 1

    For example, to get subsequence we call recursive function twice based on condition whether the current alphabet be part of the subsequence or not. In this case
        Complexity - O(2 pow n+1)
        Number of times base condition will be true - ((2 pow n) - 1)

   For example, to get keypad combination from given number we call recursive function thrice (abc) or 4 times(pqrs).
   Assume 4 times where everytime recursive will be called with different character.
        Complexity - O(4 pow n+1)
        Number of times base condition will be true - ((4 pow n) - 1)
     */

    void printNumberInIncOrder(int n) {
        //Base case
        if (n==0)
            return;
        printNumberInIncOrder(n-1);
        System.out.println(n);
    }

    void printNumberInDecOrder(int n) {
        //Base case
        if (n==0)
            return;
        System.out.println(n);
        printNumberInIncOrder(n-1);
    }

    void sumNumbers(int i, int n, int sum) {
        if (i ==n ){
            sum += i;
            System.out.println("Sum of numbers upto  " + n + " is: " + sum);
            return;
        }

        sum += i;
        sumNumbers(i+1, n, sum);
    }

    int findFactorial(int n) {

        if (n == 1 || n==0) {
            return 1;
        }
        int result = n * findFactorial(n-1);
        return  result;
    }


    private  void printFibonnaciSeriesRecursionFn(int currentNum, int previousNum, int iterationCounter) {
        if (iterationCounter == 0) {
            System.out.print(currentNum + previousNum + " ");
            return;
        }
        int temp = currentNum;

        currentNum = currentNum + previousNum;
        previousNum = temp;
        System.out.print(currentNum + " ");
        printFibonnaciSeriesRecursionFn(currentNum, previousNum, iterationCounter -1);
    }
    void printFibonacciSeries(int n) {
        System.out.println("Here's Fibonacci series upto number " + n);
        System.out.print(0 + " ");
        System.out.print(1+ " ");
        printFibonnaciSeriesRecursionFn(1, 0, n-2);
        System.out.println();
    }

    int powFunc(int x, int y){
        if (x ==0 || x ==1)
            return x;
        if (y ==0)
            return 1;
        if (y ==1)
            return x;

        int result = x * powFunc(x, y-1);
        return result;
    }

    int powFuncOptimizedStackHtLogN(int x, int y){
        if (x ==0 || x ==1)
            return x;
        if (y ==0)
            return 1;

        if (y == 1)
            return x;

        int result =0;
        if (y % 2 == 0) {
            result = powFuncOptimizedStackHtLogN(x, y/2) * powFuncOptimizedStackHtLogN(x, y/2);
        } else {
            result = powFuncOptimizedStackHtLogN(x, y/2) * powFuncOptimizedStackHtLogN(x, y/2) * x;
        }
        return result;
    }


    private void printSubSeqRecFn(String inputStr, int index, String subSeq) {
        if (index == inputStr.length()) {
            System.out.print("Hitting base condition. ");
            System.out.println(subSeq);
            return;
        }

        char currentChar = inputStr.charAt(index);

        // Scenario when the current char is considered be the part of subsequence
        printSubSeqRecFn(inputStr, index + 1 , subSeq + currentChar);

        // Scenario when the current char is NOT considered be the part of subsequence
        printSubSeqRecFn(inputStr, index + 1 , subSeq );
    }

    void printStringSubsequences(String str) {
        String subSeq = "";
        printSubSeqRecFn(str, 0, subSeq);
    }

    private void printUniqueSubSeqRec(String inputStr, int index, String subSeq, Set<String> subSeqSet) {
     if (index == inputStr.length()) {
         if (!subSeqSet.contains(subSeq)) {
             subSeqSet.add(subSeq);
             System.out.println(subSeq);
         }
         return;
     }

     char currentChar = inputStr.charAt(index);

     // Considering scenario when the current character is part of the subsequence
        printUniqueSubSeqRec(inputStr, index + 1, subSeq + currentChar, subSeqSet);

    // Considering scenario when the current character is NOT part of the subsequence
     printUniqueSubSeqRec(inputStr, index + 1, subSeq , subSeqSet);
    }

    void printUniqueSubSequence(String str) {
        String subSeq = "";
        Set <String> subSeqSet = new HashSet<>();
        printUniqueSubSeqRec(str, 0, subSeq, subSeqSet);
    }

    private void printStrInReverseRecFn(String str, int index, String resultStr) {
        if (index == str.length()) {
            System.out.print("Hitting base condition. ");
            System.out.println(resultStr);
            return;
        }
        char currentChar = str.charAt(index);
        printStrInReverseRecFn(str, index +1, currentChar + resultStr);

    }
    void printStringInReverse(String str) {
        printStrInReverseRecFn(str, 0, "");
    }

    private void firstAndLastOccuOfCharRecFn(String str, int index, char ch, int firstOcc, int lastOcc) {
        if (index ==  str.length()) {
            System.out.println(" First occurence of char " + ch + " in string " + str + " is " + firstOcc + " and last occuurence is " + lastOcc);
            return;
        }
        char currentChar = str.charAt(index);
        if (currentChar == ch) {
            if (firstOcc == -1) {
                firstOcc = index;
            }

            if (lastOcc < index) {
                lastOcc = index;
            }
        }

        firstAndLastOccuOfCharRecFn(str, index +1, ch, firstOcc, lastOcc);
    }

    void firstAndLastOccuOfChar(String str, char ch) {
        firstAndLastOccuOfCharRecFn(str, 0, ch, -1, -1);
    }

    private boolean checkArrayIsSortedRecFn(int[] arr, int index, boolean result) {
        //If reached till base condition then this means that all the previous elements are checked and so just return true
        if (index == arr.length-1) {
            return true;
        }
        boolean currentCheck = arr[index] < arr [index+1];

        //If comparison fails, then just returns and not required to check further
        // With this return statement it will exit the recursive function completely as the recursive call is the last statement
        // and so all the previous recursive function executions are fully completed.
        if (!currentCheck)
            return false;

        return checkArrayIsSortedRecFn(arr, index +1, currentCheck);
    }
    void checkIfArrayIsStrictlySorted(int[] arr) {
        if (checkArrayIsSortedRecFn(arr, 0, false)) {
            System.out.println("Array is sorted");
        } else {
            System.out.println("Given array is NOT sorted");
        }
    }

    private void moveAllxToEndRecFn(String inputStr, int index, String resultStr, int xCount) {
        if (index == inputStr.length()) {
            for(int i=0;i<xCount;i++) {
                resultStr = resultStr + 'x';
            }
            System.out.println("After moving all x in string " + inputStr + " it becomes " + resultStr);
            return;
        }

        char currentChar = inputStr.charAt(index);

        if (currentChar != 'x') {
            resultStr = resultStr + currentChar;
            moveAllxToEndRecFn(inputStr, index +1, resultStr, xCount);
        } else {
            moveAllxToEndRecFn(inputStr, index +1, resultStr, xCount + 1);
        }
    }
    void moveAllxToEnd(String str) {
        moveAllxToEndRecFn(str, 0, "", 0);
    }

    private void removeAllDupesRecFn(String str, int index, boolean[] countCheckArr, String resultStr) {
        if (index == str.length()) {
            System.out.println("After moving all x in string " + str + " it becomes " + resultStr);
            return;
        }
        char currentChar = str.charAt(index);
        if (!countCheckArr[currentChar - 'a']) {
            resultStr = resultStr + currentChar;
            countCheckArr[currentChar - 'a'] = true;
        }
        removeAllDupesRecFn(str, index +1, countCheckArr, resultStr);
    }

    void removeAllDuplicatesChars(String str) {
        boolean[] countCheckArr = new boolean[26];
        removeAllDupesRecFn(str, 0, countCheckArr, "");
    }

    private int getMaxElementRecursiveFn(int[] arr, int index, int maxElement) {
        if (index == arr.length) {
            return maxElement;
        }
        if (maxElement < arr[index]) {
            maxElement = arr[index];
        }

        return getMaxElementRecursiveFn(arr, index +1, maxElement);
    }

    int getMaxElement(int[] arr) {
        return getMaxElementRecursiveFn(arr, 0, 0);
    }


    private boolean checkPalindromeRecursiveFn(String str, int index) {
        if (index == str.length()/2) {
            return true;
        }
        if (str.charAt(index) != str.charAt(str.length()-1 - index)) {
            return false;
        }
        return checkPalindromeRecursiveFn(str, index+1);
    }

    boolean checkIfStringIsPallindrome(String str) {
        return checkPalindromeRecursiveFn(str, 0);
    }
}
