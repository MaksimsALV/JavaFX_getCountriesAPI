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
    public static void writeToFile(String jsonResponse) throws IOException {

        //output file format constructor
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String timeStamp = LocalDateTime.now().format(dateFormat);
        Path outputPath = Path.of(System.getProperty("user.home"), "IdeaProjects", "JavaFX_getCountriesAPI", "OUTPUT_" + timeStamp + ".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
                writer.write(String.valueOf(jsonResponse));

                //for output analysis only
                System.out.println("This is writing result in console:");
                System.out.println(jsonResponse);
                //
        }
    }
}
