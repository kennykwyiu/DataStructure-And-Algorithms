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

        // Step 4) Find the first Chinese (Han) character position.
        int firstHan = -1;
        for (int i = 0; i < s.length(); i++) {
            if (isCjk(s.charAt(i))) {
                // Found first Han; use this as the default split point.
                firstHan = i;
                break;
            }
        }

        // Step 5) If no Han exists, treat the whole string as English.
        if (firstHan == -1) {
            return new Parts(s, "");
        }

        // Step 6) Start with default Chinese start at first Han.
        // Then try a heuristic: include a Latin/digit brand token before Han in Chinese.
        // Example: "3M Co., Ltd. 3M有限公司" -> Chinese starts at second "3M".
        int chineseStart = firstHan;
        // Cursor used to walk backward from firstHan.
        int i = firstHan - 1;
        // Track whether we skipped spaces between Latin token and Han.
        boolean skippedWhitespaceBeforeLatin = false;
        // Step 6a) Skip spaces immediately before first Han (e.g. "Sme 發展").
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
            skippedWhitespaceBeforeLatin = true;
        }
        // Step 6b) If the char before Han-side gap is ASCII letter/digit, collect that run.
        if (i >= 0 && isAsciiLetterOrDigit(s.charAt(i))) {
            // Move left across contiguous ASCII letters/digits.
            while (i >= 0 && isAsciiLetterOrDigit(s.charAt(i))) {
                i--;
            }
            // Candidate start for Chinese segment = start of that ASCII run.
            int candidate = i + 1;
            // Accept only if token boundary is start-of-string or whitespace.
            boolean boundaryOk =
                    candidate == 0 || Character.isWhitespace(s.charAt(candidate - 1));
            // Step 6c) Guardrail:
            // "A 中文" should stay English + Chinese, so don't pull from index 0 when there was a gap.
            // But "3M有限公司" (no gap) is still allowed to start Chinese at index 0.
            if (skippedWhitespaceBeforeLatin && candidate == 0) {
                boundaryOk = false;
            }
            // Step 6d) If valid, shift Chinese start left to include Latin token.
            if (candidate < firstHan && boundaryOk) {
                chineseStart = candidate;
            }
        }

        // Step 7) Split and trim both sides.
        String english = s.substring(0, chineseStart).trim();
        String chinese = s.substring(chineseStart).trim();
        return new Parts(english, chinese);
    }

    /** Fast ASCII-only check used by the brand-token heuristic. */
    private static boolean isAsciiLetterOrDigit(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
