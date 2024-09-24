package com.company;
import java.util.HashSet;

public class LongestNonRepeatingChars {
    static void fn(String str) {
        HashSet<Character> hashSet = new HashSet<Character>();
        int maxLen=0;
        int currentSeqLen = 0;
        for (int i=0;i<str.length();i++) {
            //If character is repeated, check for currentLen and maxLen
            //Reset hashSet and currenLen
            if (hashSet.contains(str.charAt(i))) {
                if(currentSeqLen>maxLen) {
                    maxLen = currentSeqLen;
                }
                hashSet.clear();
                hashSet.add(str.charAt(i));
                currentSeqLen = 1;
            }
            //If character is non-repeated, just increment the current length and add the char in hashset
            else {
                hashSet.add(str.charAt(i));
                currentSeqLen++;
            }
        }
        //This is required in case  last seq was the max sex, e.g. "naatre"
        if(currentSeqLen>maxLen) {
            maxLen = currentSeqLen;
        }

        System.out.println("Maximum non-repeating chars length for string " + str + " is: " + maxLen);
    }
}
