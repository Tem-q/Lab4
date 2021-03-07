package actors;

import enumerations.*;

import java.util.Objects;

public class Gigl extends Pschigl{
    public Gigl(String name, Location location, TypeOfJob job, Status condition) {
        super(name, location, job, condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gigl gigl = (Gigl) o;
        return job == gigl.job &&
                Objects.equals(thing, gigl.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
