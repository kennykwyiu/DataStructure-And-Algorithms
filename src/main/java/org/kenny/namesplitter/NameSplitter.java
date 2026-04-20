package org.kenny.namesplitter;

public class NameSplitter {
    /** Split result container: English part and Chinese part. */
    public static class Parts {
        public final String english;
        public final String chinese;

        public Parts(String english, String chinese) {
            this.english = english;
            this.chinese = chinese;
        }
    }

    /** Returns true when the character belongs to Han script (Chinese). */
    public static boolean isCjk(char ch) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(ch);
        return sc == Character.UnicodeScript.HAN;
    }

    public static Parts splitEnglishChinese(String raw) {
        // Step 1) Handle null safely.
        if (raw == null) return new Parts("", "");

        // Step 2) Normalize spaces (convert NBSP to normal space) and trim both ends.
        String s = raw.replace('\u00A0', ' ').trim();
        // Step 3) If nothing remains after trimming, return empty result.
        if (s.isEmpty()) return new Parts("", "");
    }

    /** Fast ASCII-only check used by the brand-token heuristic. */
    private static boolean isAsciiLetterOrDigit(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
