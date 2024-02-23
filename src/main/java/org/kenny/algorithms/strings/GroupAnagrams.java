package org.kenny.algorithms.strings;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(List<String> words) {
        // TODO: implement this method
        Map<String, List<String>> wordsMap = new HashMap<>();
        for (String word : words) {
            char[] charWordArr = word.toCharArray();
            Arrays.sort(charWordArr);
            String key = new String(charWordArr);
            List<String> innerList = wordsMap.getOrDefault(key, new ArrayList<>());
            innerList.add(word);
            wordsMap.put(key, innerList);
        }
        return new ArrayList<>(wordsMap.values());
    }
}
