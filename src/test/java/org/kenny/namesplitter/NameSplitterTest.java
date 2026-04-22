package org.kenny.namesplitter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameSplitterTest {

    private static void assertSplit(String raw, String english, String chinese) {
        NameSplitter.Parts p = NameSplitter.splitEnglishChinese(raw);
        // Keep assertion messages explicit so failures show which side regressed.
        Assertions.assertEquals(english, p.english, "english");
        Assertions.assertEquals(chinese, p.chinese, "chinese");
    }

}
