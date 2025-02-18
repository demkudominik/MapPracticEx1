

import Model.Log;
import Model.LogParser;
import Model.LogParserFactory;
import java.util.List;

/**
 * Main program class
 */
public class Main {
    public static void main(String[] args) {
        try {
            LogParser parser = LogParserFactory.getParser("tsv");
            List<Log> logEntries = parser.parse("ninja_events.tsv");



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
