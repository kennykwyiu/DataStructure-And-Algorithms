package org.kenny.namesplitter;

public class NameSplitter {
    public static class Parts {
        public final String english;
        public final String chinese;

        public Parts(String english, String chinese) {
            this.english = english;
            this.chinese = chinese;
        }
    }

    // Detect CJK (covers most Traditional/Simplified Chinese characters + common ranges)
    public static boolean isCjk(char ch) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(ch);
        return sc == Character.UnicodeScript.HAN;
    }

    private static boolean isAsciiLetterOrDigit(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
