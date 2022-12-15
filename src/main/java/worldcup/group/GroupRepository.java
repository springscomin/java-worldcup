package worldcup.group;

import java.util.*;

public class GroupRepository {
    private static final Set<Group> groups = new HashSet<>();
    public static final String INVALID_GROUP_NAME_EXCEPTION = "존재하지 않는 조";

    public static Group saveByName(String groupName) {
        Group group = new Group(groupName);
        groups.add(group);
        return group;
    }

    public static List<Group> findAll() {
        ArrayList<Group> groups = new ArrayList<>(GroupRepository.groups);
        Collections.sort(groups);
        return groups;
    }

    public static Group findByName(String groupName) {
        return groups
                .stream().filter(group -> group.isName(groupName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GROUP_NAME_EXCEPTION));
    }
}
