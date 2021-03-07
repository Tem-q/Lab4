package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Banker extends Actor implements Output {
    public Banker(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    protected void doWork(){
        System.out.println(job + " " + name + " gives money and stays in the " + location);

        if (thing != null) {
            thing.setCondition(Status.GIVEN); // changes condition of thing
            thing.setLocation(Location.MAFIA_HOME); // changes location og thing
            changething(thing);
        }
        condition = Status.NEUTRAL; // changes condition
        changecondition(job, name, condition);

        if (nextActor != null) {
            nextActor.condition = Status.HAPPY; // changes condition of the next Actor
            changecondition(nextActor.job, nextActor.name, nextActor.condition);
        }
    }

    @Override
    public String toString() {
        return  name + " is " + job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banker banker = (Banker) o;
        return job == banker.job &&
                Objects.equals(thing, banker.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
