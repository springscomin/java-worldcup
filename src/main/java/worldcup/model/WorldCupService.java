package worldcup.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public Map<String, List<String>> getAdvancedTeamsByGroup() {
        List<String> groupNames = matches.getAllGroupNames();
        Map<String, List<String>> advancedTeams = groupNames.stream()
                .collect(Collectors.toMap(groupName -> groupName, this::getAdvancedTeamsByGroup));
        return new TreeMap<>(advancedTeams);
    }

    private List<String> getAdvancedTeamsByGroup(String groupName) {
        return getAdvancedTeams(getTeamResultsByGroup(groupName));
    }

    private List<String> getAdvancedTeams(List<TeamResult> teamResults) {
        List<String> advancedTeamNames = new ArrayList<>();
        IntStream.range(0, 2)
                .mapToObj(teamResults::get)
                .forEach(team -> advancedTeamNames.add(team.getTeamName()));
        return advancedTeamNames;
    }
}
