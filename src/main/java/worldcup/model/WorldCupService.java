package worldcup.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

    public List<TeamResult> getGroupMatches(String groupName) {
        List<TeamResult> teamResults = getTeamResultsByGroup(groupName);
        return teamResults;
    }

    private List<TeamResult> getTeamResultsByGroup(String groupName) {
        return getTeamsByGroup(groupName)
                .stream().map(Team::computeResult)
                .collect(Collectors.toList());
    }

    private List<Team> getTeamsByGroup(String groupName) {
        List<Match> matchesByGroup = matches.findMatchesByGroup(groupName);
        List<String> teamNames = findTeamNames(matchesByGroup);
        return teamNames.stream()
                .map(name -> new Team(name, matches.findMatchesByTeamName(name)))
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

    private List<String> findTeamNames(List<Match> matchesByGroup) {
        Set<String> distinctTeams = new HashSet<>();
        matchesByGroup.stream()
                .map(match -> match.getScoreByTeam().keySet())
                .forEach(distinctTeams::addAll);
        return new ArrayList<>(distinctTeams);
    }
}
