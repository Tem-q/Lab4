package actors.things;

import enumerations.*;

import java.util.Objects;

public class Letter extends Thing {
    public Letter(String name, Location location, Status condition) {
        super(name, location, condition);
    }

    @Override
    public String toString() {
        return name + " is " + condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return Objects.equals(name, letter.name) &&
                location == letter.location &&
                condition == letter.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, condition);
    }
}
