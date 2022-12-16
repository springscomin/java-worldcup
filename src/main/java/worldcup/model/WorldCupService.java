package worldcup.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import worldcup.model.domain.Match;
import worldcup.model.domain.Matches;
import worldcup.model.domain.Team;
import worldcup.model.domain.TeamResult;

public class WorldCupService {
    private final Matches matches = new Matches();

    public Map<String, List<Match>> getAllMatchesByGroup() {
        return matches.allMatchesByGroup();
    }

    public List<TeamResult> getTeamResultsByGroup(String groupName) {
        return getTeamsByGroup(groupName)
                .stream().map(Team::computeResult)
                .collect(Collectors.toList());
    }

    public TeamResult getTeamResultByName(String name) {
        List<Match> teamMatches = matches.findMatchesByTeamName(name);
        Team team = new Team(name, teamMatches);
        return team.computeResult();
    }

    public List<Match> getTeamMatchesByName(String name) {
        return matches.findMatchesByTeamName(name);
    }

    private List<Team> getTeamsByGroup(String groupName) {
        List<String> teamNames = matches.findTeamNamesByGroup(groupName);
        return teamNames.stream()
                .map(name -> new Team(name, matches.findMatchesByTeamName(name)))
                .collect(Collectors.toList());
    }
}
