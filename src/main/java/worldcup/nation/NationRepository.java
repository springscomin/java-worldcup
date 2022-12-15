package worldcup.nation;

import java.util.HashSet;
import java.util.Set;

public class NationRepository {
    private static final Set<Nation> nations = new HashSet<>();
    public static final String INVALID_NATION_NAME_EXCEPTION = "출전하지 않는 국가 이름";

    public static Nation saveByName(String nationName) {
        Nation nation = new Nation(nationName);
        nations.add(nation);
        return nation;
    }

    public static Nation findByName(String nationName) {
        return nations
                .stream().filter(nation -> nation.isName(nationName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_NATION_NAME_EXCEPTION));
    }
}
