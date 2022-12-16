package worldcup.model.domain;

import java.util.List;

public class Team {
    private final String name;
    private final List<Match> playedMatches;

    public Team(String name, List<Match> playedMatches) {
        this.name = name;
        this.playedMatches = playedMatches;
    }

    // TODO 경기 통계 생성

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", playedMatches=" + playedMatches +
                '}';
    }
}
