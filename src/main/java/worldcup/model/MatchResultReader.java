package worldcup.model;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import worldcup.model.constant.ErrorMessage;
import worldcup.model.domain.Match;
import worldcup.model.util.FileTextReader;

public class MatchResultReader {
    private static final String PATH = "src/main/resources/MatchResult.txt";

    private MatchResultReader() {
    }

    public static List<Match> readMatchResult() {
        try {
            List<String> readLines = FileTextReader.readTextLines(PATH);
            return parseLines(readLines);
        } catch (IOException exception) {
            throw new RuntimeException(ErrorMessage.FAIL_READ_MATCH_RESULT + PATH);
        }
    }

    private static List<Match> parseLines(List<String> readLines) {
        return readLines.stream()
                .map(MatchResultReader::parseLine)
                .collect(Collectors.toList());
    }

    private static Match parseLine(String readLine) {
        String[] matchValues = readLine.split(" ");
        Map<String, Integer> scoresByTeam = new LinkedHashMap<>();
        scoresByTeam.put(matchValues[1], parseInteger(matchValues[4]));
        scoresByTeam.put(matchValues[3], parseInteger(matchValues[6]));
        return new Match(matchValues[0], scoresByTeam);
    }

    private static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PARSE_NOT_A_INTEGER);
        }
    }

}
