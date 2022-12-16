package worldcup.model.domain;

import java.util.Map;
import java.util.Objects;
import worldcup.view.constant.ErrorMessage;

public class Match {
    private final String groupName;
    private final Map<String, Integer> scoreByTeam;

    public Match(String groupName, Map<String, Integer> scoreByTeam) {
        this.groupName = groupName;
        this.scoreByTeam = scoreByTeam;
    }

    public String getGroupName() {
        return groupName;
    }

    public Map<String, Integer> getScoreByTeam() {
        return scoreByTeam;
    }

    public boolean isPlayedBy(String teamName) {
        return scoreByTeam.containsKey(teamName);
    }

    public Integer getSelfScore(String teamName) {
        validateTeamName(teamName);
        return scoreByTeam.get(teamName);
    }

    public Integer getCounterPartScore(String teamName) {
        validateTeamName(teamName);
        return scoreByTeam.keySet()
                .stream().filter(name -> !Objects.equals(name, teamName))
                .findFirst()
                .map(scoreByTeam::get)
                .orElse(null);
    }

    private void validateTeamName(String teamName) {
        if (!scoreByTeam.containsKey(teamName)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TEAM_NAME_FOR_MATCH);
        }
    }
    // TODO 기능: 특정 팀의 승점/골득실/득점 확인

    @Override
    public String toString() {
        return "Match{" +
                "groupName='" + groupName + '\'' +
                ", scoreByTeam=" + scoreByTeam +
                '}';
    }
}
