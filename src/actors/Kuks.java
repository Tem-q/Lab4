package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Kuks extends Actor implements Output, Teller {
    public Kuks(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    @Override
    public void say(){
        System.out.println(name + ": You came up with the idea that the suitcase was buried in the yard because of the allegedly large rent and sent the letter!"); // says something in court
    }

    protected void doWork(){
        if ((thing2 != null) && (nextActor != null) && (thing2.getCondition() == Status.SENT)) {
            location = Location.COURT; // changes location
            go(job, name, location);

            nextActor.condition = Status.SAD;
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
        Kuks kuks = (Kuks) o;
        return job == kuks.job &&
                Objects.equals(thing, kuks.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
