package actors.things;

import enumerations.*;

import java.util.Objects;

public class House extends Thing {
    public House (String name, Location location, Status condition) {
        super(name, location, condition);
    }

    public class Wall extends House {
        public Wall(String name, Location location, Status condition) {
            super(name, location, condition);
        }
    }

    @Override
    public String toString() {
        return name + " is " + condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) &&
                location == house.location &&
                condition == house.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, condition);
    }
}
