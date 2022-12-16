package worldcup.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import worldcup.controller.MenuCommand;
import worldcup.model.domain.Match;
import worldcup.view.constant.OutputFormat;

public class OutputView {
    public static final String INFORM_START = "카타르 월드컵 조별리그 결과";

    public void printMain() {
        System.out.println(INFORM_START);
        System.out.println();
        Arrays.stream(MenuCommand.values())
                .forEach(command -> System.out.printf(OutputFormat.MAIN_COMMAND, command.getKey(), command.getValue()));
    }

    public void printAllMatchesByGroup(Map<String, List<Match>> allMatches) {
        System.out.println();
        allMatches.keySet()
                .forEach(groupName -> printGroupMatches(groupName, allMatches.get(groupName)));
    }

    private void printGroupMatches(String groupName, List<Match> matches) {
        System.out.println(groupName);
        matches.forEach(this::printMatch);
        System.out.println();
    }

    private void printMatch(Match match) {
        Map<String, Integer> scoreByTeam = match.getScoreByTeam();
        System.out.println(makeMatchDisplay(scoreByTeam));
    }

    private String makeMatchDisplay(Map<String, Integer> scoreByTeam) {
        StringJoiner teams = new StringJoiner(OutputFormat.VERSUS_DELIMITER);
        StringJoiner scores = new StringJoiner(OutputFormat.SCORE_DELIMITER);
        scoreByTeam.keySet()
                .forEach(teams::add);
        scoreByTeam.values()
                .stream().map(String::valueOf)
                .forEach(scores::add);
        return teams + " " + scores;
    }
}
