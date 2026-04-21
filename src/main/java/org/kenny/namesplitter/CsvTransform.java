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

    }
}
