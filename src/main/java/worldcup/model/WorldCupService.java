package worldcup.model;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.reverse(teamResults);
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
                .map(name -> new Team(name, findTeamMatches(name, matchesByGroup)))
                .collect(Collectors.toList());
    }

    private List<Match> findTeamMatches(String teamNames, List<Match> matchesByGroup) {
        return matchesByGroup.stream()
                .filter(match -> match.isPlayedBy(teamNames))
                .collect(Collectors.toList());
    }

    private List<String> findTeamNames(List<Match> matchesByGroup) {
        Set<String> distinctTeams = new HashSet<>();
        matchesByGroup.stream()
                .map(match -> match.getScoreByTeam().keySet())
                .forEach(distinctTeams::addAll);
        return new ArrayList<>(distinctTeams);
    }
}
