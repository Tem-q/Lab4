package actors;

import enumerations.*;

import java.util.Objects;

public class Spigl extends Pschigl{
    public Spigl(String name, Location location, TypeOfJob job, Status condition) {
        super(name, location, job, condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spigl spigl = (Spigl) o;
        return job == spigl.job &&
                Objects.equals(thing, spigl.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
