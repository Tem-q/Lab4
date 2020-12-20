package actors.things;

import enumerations.*;
import java.util.Objects;

public class Poster extends Thing{
    public Poster(String name, Location location, Status condition) {
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
        Poster poster = (Poster) o;
        return Objects.equals(name, poster.name) &&
                location == poster.location &&
                condition == poster.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, condition);
    }
}
