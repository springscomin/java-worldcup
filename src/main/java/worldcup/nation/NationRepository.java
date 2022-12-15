package worldcup.nation;

import java.util.HashSet;
import java.util.Set;

public class NationRepository {
    private static final Set<Nation> nations = new HashSet<>();

    public static Nation saveByName(String nationName) {
        Nation nation = new Nation(nationName);
        nations.add(nation);
        return nation;
    }
}
