package worldcup.nation;

import java.util.Objects;

public class Nation {
    private final String name;

    public Nation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Nation nation = (Nation) o;
        return name.equals(nation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
