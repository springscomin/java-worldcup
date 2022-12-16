package worldcup.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.IntStream;
import worldcup.controller.MenuCommand;
import worldcup.model.domain.Match;
import worldcup.model.domain.TeamResult;
import worldcup.view.constant.OutputFormat;

public class OutputView {
    public static final String INFORM_START = "카타르 월드컵 조별리그 결과";
    public static final String DIVISION = "============================================================";
    public static final String RESULT_DELIMITER = ", ";
    public static final String ERROR_PREFIX = "[ERROR] ";

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
        System.out.println(DIVISION);
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

    public void printTeamResultsByGroup(String groupName, List<TeamResult> results) {
        System.out.println(groupName);
        IntStream.range(1, results.size() + 1)
                .forEach(rank -> System.out.println(makeRankedTeamResultDisplay(rank, results.get(rank - 1))));
        System.out.println(DIVISION);
    }

    private String makeRankedTeamResultDisplay(int rank, TeamResult teamResult) {
        StringBuilder builder = new StringBuilder();
        builder.append(rank).append("위 ").append(teamResult.getTeamName());
        builder.append(" ").append(makeTeamResultDisplay(teamResult));
        return builder.toString();
    }

    public void printTeamMatchResults(TeamResult teamResult, List<Match> matches) {
        printTeamResult(teamResult);
        System.out.println();
        matches.forEach(this::printMatch);
        System.out.println(DIVISION);
        System.out.println();
    }

    private void printTeamResult(TeamResult teamResult) {
        System.out.println(makeTeamResultDisplay(teamResult));
    }

    private String makeTeamResultDisplay(TeamResult teamResult) {
        StringBuilder builder = new StringBuilder();
        builder.append("승 : ").append(teamResult.getMatchResultCount().getWinCount());
        builder.append(" 무 : ").append(teamResult.getMatchResultCount().getDrawCount());
        builder.append(" 패 : ").append(teamResult.getMatchResultCount().getLoseCount());
        builder.append(RESULT_DELIMITER);
        builder.append("승점 : ").append(teamResult.getScoreSummary().getRankPoint());
        builder.append(" 득실차 : ").append(teamResult.getScoreSummary().computeTotalGoalDifference());
        builder.append(" 득점 : ").append(teamResult.getScoreSummary().getTotalGoals());
        return builder.toString();
    }

    public void printAdvancedTeams(Map<String, List<String>> advancedTeamsByGroup) {
        advancedTeamsByGroup.keySet()
                .stream()
                .forEach(groupName -> printAdvancedTeamsByGroup(groupName, advancedTeamsByGroup.get(groupName)));
    }

    private void printAdvancedTeamsByGroup(String groupName, List<String> teamNames) {
        System.out.println(groupName);
        IntStream.range(1, 3)
                .mapToObj(rank -> rank + "위 " + teamNames.get(rank - 1))
                .forEach(System.out::println);
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }
}
