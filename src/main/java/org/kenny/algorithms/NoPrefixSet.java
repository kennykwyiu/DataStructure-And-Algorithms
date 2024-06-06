package org.kenny.algorithms;

import java.util.List;

/**
 * Problem:
 * You are given an array of strings. Your task is to determine if the array of strings forms a valid Prefix Set. A Prefix Set is a set of strings, where no string is a prefix of another string in the set. If the array forms a valid Prefix Set, return "GOOD SET". Otherwise, return the first string that violates the property of a Prefix Set.
 * <p>
 * Write a function `noPrefix` to determine if the given array of strings forms a valid Prefix Set.
 * <p>
 * Function Signature:
 * `String noPrefix(String[] arr)`
 * <p>
 * Input:
 * - An array `arr` of strings where each string consists of lowercase English alphabets. The length of the array is between 1 and 10^5.
 * - The length of each string is between 1 and 60.
 * <p>
 * Output:
 * - If the array of strings forms a valid Prefix Set, return "GOOD SET".
 * - If the array of strings does not form a valid Prefix Set, return the first string that violates the property of a Prefix Set.
 * <p>
 * Example:
 * Input:
 * `arr = ["abc", "def", "ab", "abcd"]`
 * Output:
 * `ab`
 * <p>
 * Explanation:
 * - The string "ab" is a prefix of "abc" and "abcd", violating the property of a Prefix Set.
 * <p>
 * Note:
 * - The output string should be the first string that violates the property of a Prefix Set.
 * - The array of strings may contain duplicates.
 * - The order of the input strings may vary.
 * - You only need to return the first string that violates the property, even if there are multiple strings that violate the property.
 */
public class NoPrefixSet {
    public static void noPrefix(List<String> words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            if (!insert(root, word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return; // Stop processing further words
            }
        }
        System.out.println("GOOD SET");


    }

    public static boolean insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            } else if (current.children[index].isWord) {
                return false;
            }

            current = current.children[index];
        }

        current.isWord = true;

        for (TrieNode child : current.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }

}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
