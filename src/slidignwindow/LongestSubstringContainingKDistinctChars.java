package slidignwindow;

import java.util.HashMap;

/** Problem Statement: Given a string and a positive number k, find the longest substring of the string containing k distinct characters.
 * If k is more than the total number of distinct characters in the string, return the whole string.
 *
 * For example, consider string abcbdbdbbdcdabd. *
     * For k = 2, o/p is ‘bdbdbbd’
     * For k = 3, o/p is ‘bcbdbdbbdcd’
     * For k = 5, o/p is ‘abcbdbdbbdcdabd’
 *
 */
public class LongestSubstringContainingKDistinctChars {
    public static void mainFn() {
        String result = findLongestSubStringOfKUniqueChars("abcbdbdbbdcdabd", 2);
        System.out.println("Longest Substring: " + result);
    }

    private static String findLongestSubStringOfKUniqueChars(String str, int k) {
        if (k> str.length()) return "Not Possible";
        if (k== str.length()) return str;

        String result = "";
        int startIndex = 0;
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
        int i=0;
        while (i<str.length()) {
            char ch = str.charAt(i);
            addCharInMap(charMap, ch);
            if (charMap.size() > k) {
                if (result.length() < i-startIndex) {
                    result = str.substring(startIndex, i);
                }
                //Start traversing from startIndex and go up the last char of left most element
                char elementToRemove = str.charAt(startIndex);
                int elementToRemoveFreq = charMap.get(elementToRemove);
                while (elementToRemoveFreq != 0) {
                    if (str.charAt(startIndex) == elementToRemove) {
                        elementToRemoveFreq--;
                        startIndex++;
                    } else {
                        startIndex++;
                    }
                }
                charMap = new HashMap<>();
                i = startIndex;
            } else {
                i++;
            }
        }
        if (result.length() < str.length()-startIndex) {
            result = str.substring(startIndex);
        }
        return result;
    }

    private static void addCharInMap(HashMap<Character, Integer> charMap, char ch) {
        if (charMap.get(ch)!= null) {
            charMap.put(ch, charMap.get(ch) + 1);
        } else {
            charMap.put(ch, 1);
        }
    }

}
