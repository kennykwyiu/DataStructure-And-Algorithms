package org.kenny.algorithms;

/**
 *
 * Problem:
 * You are given an array of strings. Your task is to determine if the array of strings forms a valid Prefix Set. A Prefix Set is a set of strings, where no string is a prefix of another string in the set. If the array forms a valid Prefix Set, return "GOOD SET". Otherwise, return the first string that violates the property of a Prefix Set.
 *
 * Write a function `noPrefix` to determine if the given array of strings forms a valid Prefix Set.
 *
 * Function Signature:
 * `String noPrefix(String[] arr)`
 *
 * Input:
 * - An array `arr` of strings where each string consists of lowercase English alphabets. The length of the array is between 1 and 10^5.
 * - The length of each string is between 1 and 60.
 *
 * Output:
 * - If the array of strings forms a valid Prefix Set, return "GOOD SET".
 * - If the array of strings does not form a valid Prefix Set, return the first string that violates the property of a Prefix Set.
 *
 * Example:
 * Input:
 * `arr = ["abc", "def", "ab", "abcd"]`
 * Output:
 * `ab`
 *
 * Explanation:
 * - The string "ab" is a prefix of "abc" and "abcd", violating the property of a Prefix Set.
 *
 * Note:
 * - The output string should be the first string that violates the property of a Prefix Set.
 * - The array of strings may contain duplicates.
 * - The order of the input strings may vary.
 * - You only need to return the first string that violates the property, even if there are multiple strings that violate the property.
 *
 */
public class NoPrefixSet {
}
