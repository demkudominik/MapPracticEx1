package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for TXT files.
 */
public class TXTLogParser implements LogParser {
    @Override
    public List<Log> parse(String filePath) throws IOException {
        List<Log> logEntries = new ArrayList<>();
        Path file = Path.of(filePath);

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            reader.readLine(); // Ignore header row
            String line;

            while ((line = reader.readLine()) != null) {
                String[] field = line.split("&");
                if (field.length != 6) continue; // Field number validation

                int id = Integer.parseInt(field[0]);
                String charaktername = field[1];
                Stufe stufe= Stufe.valueOf(field[2]);
                String beschreibung = field[3];
                String datum = field[4];
                double kraftpunkte= Double.parseDouble(field[5]);

                logEntries.add(new Log(id, charaktername, stufe, beschreibung, datum,kraftpunkte));
            }
        }
        return logEntries;
    }
}
