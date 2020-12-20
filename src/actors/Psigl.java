package actors;

import enumerations.*;

import java.util.Objects;

public class Psigl extends Pschigl{
    public Psigl(String name, Location location, TypeOfJob job, Status condition) {
        super(name, location, job, condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Psigl psigl = (Psigl) o;
        return job == psigl.job &&
                Objects.equals(thing, psigl.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
