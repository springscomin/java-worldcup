package worldcup.service;

import worldcup.group.Group;
import worldcup.match.MatchRepository;
import worldcup.match.MatchResult;

import java.util.List;

public class MatchService {
    public static List<MatchResult> findAllByGroup(Group group) {
        return MatchRepository.findAllByGroup(group);
    }
}
