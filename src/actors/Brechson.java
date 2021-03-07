package actors;

import actors.exceptions.MoneyIsNotGivenException;
import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Brechson extends Actor implements Output, Teller {
    public Brechson(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    @Override
    public void say(){
        System.out.println(name + ": I sent this " + thing.getName() + " to " + Location.NEWS + "."); // says something in court
    }

    protected void doWork() throws MoneyIsNotGivenException {
        if ((thing != null) && (thing2 != null) && (nextActor != null) && (thing2.getCondition() == Status.GIVEN)){
            thing.setCondition(Status.SENT); // changes condition of thing
            thing.setLocation(Location.NEWS); // changes location og thing
            changething(thing);

            location = Location.COURT; // changes location
            go(job, name, location);

            nextActor.condition = Status.HAPPY; // changes condition of the next Actor
            changecondition(nextActor.job, nextActor.name, nextActor.condition);
        } else {
            throw new MoneyIsNotGivenException("The Banker was killed. Money was not given");
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
        Brechson brechson = (Brechson) o;
        return job == brechson.job &&
                Objects.equals(thing, brechson.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
