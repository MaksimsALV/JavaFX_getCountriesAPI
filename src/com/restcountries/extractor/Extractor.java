package com.restcountries.extractor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Extractor {
    public static void writeToFile(String countryData) throws IOException {

        //output file format constructor
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = LocalDateTime.now().format(dateFormat);
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH-mm-ss"));
        Path outputPath = Path.of(System.getProperty("user.home"), "IdeaProjects", "JavaFX_getCountriesAPI", "files", "OUTPUT_" + date + "_" + timeStamp + ".json");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                writer.write(countryData);
                System.out.println("Export is completed");
        }
    }
}
