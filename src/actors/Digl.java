package actors;

import enumerations.*;

import java.util.Objects;

public class Digl extends Pschigl{
    public Digl(String name, Location location, TypeOfJob job, Status condition) {
        super(name, location, job, condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digl digl = (Digl) o;
        return job == digl.job &&
                Objects.equals(thing, digl.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
