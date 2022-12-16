package worldcup.model.domain;

import java.util.List;
import worldcup.model.MatchResultReader;

public class Matches {
    private final List<Match> matches;

    public Matches() {
        this.matches = MatchResultReader.readMatchResult();
    }
}
