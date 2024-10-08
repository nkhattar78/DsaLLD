import java.util.*;

public class StringFunctions {
    String str;
    StringFunctions(String str){
        this.str = str;
    }

    void accessStringChars(){
        StringBuilder sb = new StringBuilder("abc");
        System.out.println("String length is: " + sb.length());
        System.out.println("String value is: " + sb.toString());

        for (int i=0;i<sb.length();i++) {
            System.out.println("Char at position " + i + " is " + sb.charAt(i));
        }
    }

    void checkPalindrome() {
        int startIndex = 0, endIndex=str.length()-1;
        boolean isPalindrome = true;
        for (;startIndex<str.length()/2;startIndex++, endIndex--) {
            if(str.charAt(startIndex) != str.charAt(endIndex)) {
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome)
            System.out.println("Given string " + str + " is palindrome");
        else
            System.out.println("Given string " + str + " is NOT  palindrome");
    }

    void checkParanthesis() {
        Stack<Character> charStack = new Stack<Character>();
        boolean doesStrHasValidParanthesis = true;

        for (int i=0;i<str.length();i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' ) {
                charStack.push(str.charAt(i));
            } else {
                switch (str.charAt(i)) {
                    case ')':{
                        if (charStack.pop() != '(') {
                            doesStrHasValidParanthesis = false;
                            break;
                        }
                        continue;
                    }
                    case '}': {
                        if (charStack.pop() != '{') {
                            doesStrHasValidParanthesis = false;
                            break;
                        }
                        continue;
                    }
                    case ']': {
                        if (charStack.pop() != '[') {
                            doesStrHasValidParanthesis = false;
                            break;
                        }
                        continue;
                    }
                }
            }
        }

        if(doesStrHasValidParanthesis)
            System.out.println("Given string " + str + " has valid paranthesis");
        else
            System.out.println("Given string " + str + " does not have valid paranthesis");

    }

    void checkAnagram(String strToCheck){
        if (str.length() != strToCheck.length()) {
            System.out.println("Given strings " + str + " and " + strToCheck + " are not anagrams");
            return;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        boolean areStringAnagram = true;

        for (int i=0;i<str.length();i++) {
            Character currentChar = str.charAt(i);
            if(map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) +1);
            } else {
                map.put(currentChar, 1);
            }
        }

        for (int i=0;i<strToCheck.length();i++) {
            Character currentChar = strToCheck.charAt(i);
            if(map.containsKey(currentChar)) {
                if (map.get(currentChar) == 1) {
                    map.remove(currentChar);
                } else {
                    map.put(currentChar, map.get(currentChar) - 1);
                }
            } else {
                break;
            }
        }

        if (!map.isEmpty())
            System.out.println("Given strings " + str + " and " + strToCheck + " are NOT anagrams");
        else
            System.out.println("Given strings " + str + " and " + strToCheck + " are anagrams");
    }

    void printNumericKeyboardForStr(){
        HashMap<Character, Integer> map = new HashMap<>();
        str = str.toUpperCase();
        map.put('A',2);
        map.put('B',22);
        map.put('C',222);
        map.put('D', 3);
        map.put('E', 33);
        map.put('F', 333);
        map.put('G', 4);
        map.put('H', 44);
        map.put('I', 444);
        map.put('J', 5);
        map.put('K', 55);
        map.put('L', 555);
        map.put('M', 6);
        map.put('N', 66);
        map.put('O', 666);
        map.put('P', 7);
        map.put('Q', 77);
        map.put('R', 777);
        map.put('S', 7777);
        map.put('T', 8);
        map.put('U', 88);
        map.put('V', 888);
        map.put('W', 9);
        map.put('X', 99);
        map.put('Y', 999);
        map.put('Z', 9999);

        StringBuilder resultString = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            Character currentChar = str.charAt(i);
            resultString.append(map.get(currentChar).toString());
        }

        System.out.println("Result String is: " + resultString);
    }

    void removeDuplicateChars() {
        List<Character> listOfChars = new ArrayList<>();


        for (int i =0; i< str.length(); i++) {
            if (!listOfChars.contains(str.charAt(i))){
                listOfChars.add(str.charAt(i));
            }
        }
        StringBuilder resultString  = new StringBuilder();

        for (Character ch: listOfChars){
            resultString.append(ch);
        }

        System.out.println("For input string "+ str + ", result string after removing duplicates is: " + resultString);
    }

    void removeConsecutiveChars(){
        StringBuilder resultString = new StringBuilder();
        resultString.append(str.charAt(0));

        for (int i = 1; i<str.length();i++) {
            char currentChar = str.charAt(i), previousChar = str.charAt(i-1);
            if(currentChar != previousChar) {
                resultString.append(currentChar);
            }
        }

        System.out.println("For input string "+ str + ", result string after removing consecutive characters is: " + resultString);
    }

    int countSubStringsOfDistinctChars(String str, int k) {
        boolean[] frequencyArray = new boolean[26];
        int distinctChars = 0;
        String substr = "";
        HashSet<String> subStringsSet = new HashSet<>();

        for (int i=0;i<str.length(); i++) {
            Arrays.fill(frequencyArray, false);
            distinctChars = 0;
            substr = "";
            for (int j = i; j<str.length(); j++) {
                char currentChar = str.charAt(j);
                substr = substr + currentChar;
                if (!frequencyArray[currentChar - 'a']) {
                    distinctChars ++;
                    frequencyArray[currentChar -'a'] = true;
                }
                if (distinctChars ==k){
                    subStringsSet.add(substr);
                } else if (distinctChars >k) {
                    break;
                }
            }
        }
        System.out.println(subStringsSet);
        return subStringsSet.size();
    }

    static int[] frequencyArrayForString(String str) {
        int [] frequencyArray = new int[26];
        for (int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            frequencyArray[ch  - 'a']++;
        }
        return frequencyArray;
    }

    static int[] frequencyArrayForNumber(int num) {
        int [] frequencyArray = new int[10];
        while (num >0) {
            int mod = num%10;
            frequencyArray[mod]++;
            num = num /10;
        }
        return frequencyArray;
    }

    static boolean[] seenArrayForString(String str) {
        boolean [] frequencyArray = new boolean[26];
        for (int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            frequencyArray[ch  - 'a'] = true;
        }
        return frequencyArray;
    }

    static boolean[] seenArrayForNumber(int num) {
        boolean [] frequencyArray = new boolean[10];
        while (num >0) {
            int mod = num%10;
            frequencyArray[mod] = true;
            num = num /10;
        }
        return frequencyArray;
    }

    /**
     * @Category 2-pointer
     * 	• Problem: Given a string, partition it into as many parts as possible so that each letter appears in at most one part, and return the length of each part.
     * 	• Approach:
     * 		○ Create a frequency array which will store the last index of the character instead of number of chars.
     * 		○ Use two pointers: one (i) for the current position and the other (j) to track the farthest last occurrence of characters in the current segment.
     */
    void partitionLabels(String str) {
        int [] lastIndexArr = ArraysFunctions.getCharLastIndexArray(str);
        String subStr = "";
        int moveTillIndex =0;

        for (int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            moveTillIndex = Math.max(moveTillIndex, lastIndexArr[ch - 'a']);
            subStr = subStr + ch;
            if (i == moveTillIndex) {
                System.out.println(subStr);
                subStr  = "";
            }
        }
    }
}

