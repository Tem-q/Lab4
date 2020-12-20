package actors;

import enumerations.*;

import java.util.Objects;

public class Bald extends Actor{
    public Bald(String name, Location location, TypeOfJob job, Status condition) {
        super(name, location, job, condition);
    }

    @Override
    public void doWork(){};

    @Override
    public String toString() {
        return  name + " is " + job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bald bald = (Bald) o;
        return job == bald.job &&
                Objects.equals(thing, bald.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
