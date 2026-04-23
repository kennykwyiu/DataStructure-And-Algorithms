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

    @Test
    void nullAndEmpty() {
        // Guardrails: parser should be null-safe and trim whitespace-only inputs.
        assertSplit(null, "", "");
        assertSplit("", "", "");
        assertSplit("   ", "", "");
    }

    @Test
    void englishOnly_noHan() {
        // No Han characters means everything stays on the English side.
        assertSplit("Acme Corp.", "Acme Corp.", "");
    }

    @Test
    void chineseOnly_startsWithHan() {
        // Leading Han should route the full value to Chinese.
        assertSplit("有限公司", "", "有限公司");
    }

    @Test
    void nbspNormalized() {
        // CSV data can contain NBSP; split logic normalizes it like regular space.
        assertSplit("A\u00A0中文", "A", "中文");
    }

}
