package worldcup.group;

import java.util.*;

public class GroupRepository {
    private static final Set<Group> groups = new HashSet<>();

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
}
