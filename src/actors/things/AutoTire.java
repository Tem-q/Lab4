package actors.things;

import enumerations.*;

import java.util.Objects;

public class AutoTire extends Thing  {
    public AutoTire(String name, Location location, Status condition){
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
        AutoTire autoTire = (AutoTire) o;
        return Objects.equals(name, autoTire.name) &&
                location == autoTire.location &&
                condition == autoTire.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, condition);
    }
}
