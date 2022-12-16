package worldcup.model.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import worldcup.model.MatchResultReader;
import worldcup.view.constant.ErrorMessage;

public class Matches {
    private final List<Match> matches;

    public Matches() {
        this.matches = MatchResultReader.readMatchResult();
    }

    public Map<String, List<Match>> allMatchesByGroup() {
        Map<String, List<Match>> matchesByGroup = matches.stream()
                .map(Match::getGroupName)
                .distinct()
                .collect(Collectors.toMap(groupName -> groupName, this::findMatchesByGroup));
        return new TreeMap<>(matchesByGroup);
    }

    public List<Match> findMatchesByGroup(String groupName) {
        List<Match> foundMatches = matches.stream()
                .filter(match -> Objects.equals(groupName, match.getGroupName()))
                .collect(Collectors.toList());
        validateFoundMatches(foundMatches);
        return foundMatches;
    }

    private void validateFoundMatches(List<Match> matches) {
        if (matches.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.GROUP_MATCHES_NOT_FOUND);
        }
    }
}
