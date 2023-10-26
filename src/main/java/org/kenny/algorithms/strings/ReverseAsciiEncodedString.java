package org.kenny.algorithms.strings;

public class ReverseAsciiEncodedString {
    public String reverseAsciiEncodedString(String encodeString) {
        StringBuilder sb = new StringBuilder();
        for (int i = encodeString.length(); i >= 2; i = i - 2) {
            String code = encodeString.substring(i - 2, i);
            int num = Integer.parseInt(code);
            sb.append((char)num);
        }
        return sb.toString();
    }
}
