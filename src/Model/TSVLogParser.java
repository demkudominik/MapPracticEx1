package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

    /**
     * Parser for TSV files.
     */
    public class TSVLogParser implements LogParser {
        @Override
        public List<Log> parse(String filePath) throws IOException {
            List<Log> logEntries = new ArrayList<>();
            Path file = Path.of(filePath);

            try (BufferedReader reader = Files.newBufferedReader(file)) {
                reader.readLine(); // Ignore header row
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\t");

                    if (parts.length == 6) {
                        int id = Integer.parseInt(parts[0].trim());
                        String charaktername = parts[1].trim();
                        Stufe stufe = Stufe.valueOf(parts[2].trim());
                        String beschreibung = parts[3].trim();
                        String datum = parts[4].trim();
                        double  kraftpunkte = Double.parseDouble(parts[5]);

                        logEntries.add(new Log(id, charaktername, stufe, beschreibung, datum,kraftpunkte));
                    }
                }
            }
            return logEntries;
        }
    }

