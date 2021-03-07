package actors.things;

import enumerations.*;

import java.util.Objects;

public class Money extends Thing {
    public Money(String name, Location location, Status condition) {
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
        Money money = (Money) o;
        return Objects.equals(name, money.name) &&
                location == money.location &&
                condition == money.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, condition);
    }
}
