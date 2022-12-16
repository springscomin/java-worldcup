package worldcup.model;

import java.util.List;
import java.util.Map;
import worldcup.model.domain.Match;
import worldcup.model.domain.Matches;

public class WorldCupService {
    private final Matches matches = new Matches();

    public Map<String, List<Match>> getAllMatchesByGroup() {
        return matches.allMatchesByGroup();
    }
}
