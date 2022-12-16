package worldcup.model.domain;

import java.util.Map;

public class Match {
    private final String groupName;
    private final Map<String, Integer> scoreByTeam;

    public Match(String groupName, Map<String, Integer> scoreByTeam) {
        this.groupName = groupName;
        this.scoreByTeam = scoreByTeam;
    }

    // TODO 기능: 참여한 팀 목록 확인
    // TODO 기능: 특정 팀의 승/무/패 여부 확인
    // TODO 기능: 특정 팀의 승점/골득실/득점 확인
}
