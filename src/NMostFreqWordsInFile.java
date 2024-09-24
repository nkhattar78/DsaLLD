package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class NMostFreqWordsInFile {
    static void  fn(int k) throws  Exception{
        PriorityQueue<String > pq = new PriorityQueue<>();
        HashMap<String, Integer> wordsMap = new HashMap<String, Integer>();
        File inputFile = new File("C:\\Learnings\\Code Work\\Java\\DataSt\\FileHavingWords.txt");
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String st;
        while((st = br.readLine()) != null) {
           //System.out.println(st);
           String [] words = st.split(" ");
            for (String word:words) {
                int wordCount = 1;

                if (wordsMap.containsKey(word)) {
                    wordCount = wordsMap.get(word);
                    wordsMap.replace(word, ++wordCount);
                } else {
                    wordsMap.put(word,1);
                }

                //If priority queue does not contains the word then do
                    // If queue size is smaller then K then add it
                    // Else check the count of top word, if less than the current word then remove the top one and add the current one
                // Else, nothing requires to be done as word continues to be eligible be a part of the priority queue.
                if(!pq.contains(word)) {
                    if(pq.size()<k) {
                        pq.add(word);
                    } else {
                        int minCount = wordsMap.get(pq.peek());
                        if (wordCount>minCount) {
                            pq.poll();
                            pq.add(word);
                        }
                    }
                }
            }
        }

        while(pq.size()>0) {
            String word = pq.poll();
            System.out.println("Count of word " + word + " is: " + wordsMap.get(word));
        }
    }
}
