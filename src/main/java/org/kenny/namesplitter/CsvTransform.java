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
        Path in = Paths.get("src/main/java/org/kenny/namesplitter/input_utf8.csv");
        Path out = Paths.get("src/main/java/org/kenny/namesplitter/output.csv");

        // Input is one full name per line; commas inside names (e.g. "Co., Ltd.") are not CSV field
        // separators. Parsing with CSVParser would split those lines incorrectly.
        List<String> lines = Files.readAllLines(in, StandardCharsets.UTF_8);
        int start = 0;
        if (!lines.isEmpty()) {
            String first = lines.get(0).trim();
            if (first.startsWith("\uFEFF")) {
                first = first.substring(1);
            }
            if ("name".equalsIgnoreCase(first)) {
                start = 1;
            }
        }

    }
}
