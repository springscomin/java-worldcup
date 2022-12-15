package worldcup.group;

import java.util.HashSet;
import java.util.Set;

public class GroupRepository {
    private static final Set<Group> groups = new HashSet<>();

    public static Group saveByName(String groupName) {
        Group group = new Group(groupName);
        groups.add(group);
        return group;
    }
}
