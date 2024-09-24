package slidignwindow;

import strings.AreStringAnagrams;

/** Problem Statement
 *Find all substrings of a string that contains all characters of another string.
 * In other words, find all substrings of the first string that are anagrams of the second string.
 * For example
     * The first string is 'XYYZXZYZXXYZ'
     * The second string is 'XYZ'
     *
     * Anagram 'YZX' present at index 2
     * Anagram 'XZY' present at index 4
     * Anagram 'YZX' present at index 6
     * Anagram 'XYZ' present at index 9
 */
public class AllSubStringsWhichAreAnagramsOfAnotherString {
    public static void mainFn(){
        findAllAnagrams("XYYZXZYZXXYZ", "XYZ");
//        findAllAnagrams("YXZY", "XYZ");
    }

    private static void findAllAnagrams(String str1, String str2) {
        if (str1.length()<str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int anagramsCount =0;

        for (int i = 0;i<= str1.length()-str2.length();i++) {
            String subString = str1.substring(i, str2.length()+i);
            boolean checkAnagramsResult = AreStringAnagrams.checkAnagrams(subString,str2);
            if (checkAnagramsResult) {
                anagramsCount++;
                System.out.println("Substring " + subString + " is an anagram");
            }
        }
        System.out.println("total anagrams are: " + anagramsCount);
    }

}
