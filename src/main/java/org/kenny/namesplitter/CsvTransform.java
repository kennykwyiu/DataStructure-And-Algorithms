package org.kenny.namesplitter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvTransform {
    public static void main(String[] args) throws Exception {
        // Fixed paths for this utility run: read raw names, write split output.
        Path in = Paths.get("src/main/java/org/kenny/namesplitter/input_utf8.csv");
        Path out = Paths.get("src/main/java/org/kenny/namesplitter/output.csv");

        // Input is one full name per line; commas inside names (e.g. "Co., Ltd.") are not CSV field
        // separators. Parsing with CSVParser would split those lines incorrectly.
        List<String> lines = Files.readAllLines(in, StandardCharsets.UTF_8);
        int start = 0;
        if (!lines.isEmpty()) {
            // First line may be BOM-prefixed; normalize before header check.
            String first = lines.get(0).trim();
            if (first.startsWith("\uFEFF")) {
                first = first.substring(1);
            }
            // Accept a single header line "name" and skip it.
            if ("name".equalsIgnoreCase(first)) {
                start = 1;
            }
        }

        try (Writer writer = Files.newBufferedWriter(out, StandardCharsets.UTF_8);
             CSVPrinter printer = CSVFormat.DEFAULT
                     .builder()
                     .setHeader("English", "Chinese")
                     .build()
                     .print(writer)) {
            for (int i = start; i < lines.size(); i++) {
                String value = lines.get(i);
                // Ignore empty rows so output only contains meaningful records.
                if (value.isBlank()) {
                    continue;
                }
                // Lightweight diagnostics: show source row and first detected Han position.
                System.out.println("RAW=" + value);
                for (int j = 0; j < value.length(); j++) {
                    char ch = value.charAt(j);
                    if (NameSplitter.isCjk(ch)) {
                        System.out.println("First CJK at " + j + " char=" + ch);
                        break;
                    }
                }
                // Core transform: split one mixed-language name into two output columns.
                NameSplitter.Parts p = NameSplitter.splitEnglishChinese(value);
                printer.printRecord(p.english, p.chinese);
            }
        }
    }
}
