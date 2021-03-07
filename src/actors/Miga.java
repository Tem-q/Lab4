package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Miga extends Actor implements Output, Teller {
    public Miga(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    @Override
    public void say(){
        System.out.println(name + ": No one buys shares. We'll go broke"); // says something
    }

    protected void doWork(){
        if ((thing != null) && (thing2 != null) && (nextActor != null) && (thing2.getCondition() == Status.SENT)) {
            condition = Status.SAD;
            changecondition(job, name, condition);

            location = Location.STREET; // changes location
            go(job, name, location);

            thing.setCondition(Status.READY); // changes condition of thing
            changething(thing);

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
        Miga miga = (Miga) o;
        return job == miga.job &&
                Objects.equals(thing, miga.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
