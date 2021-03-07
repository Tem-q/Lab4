package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Eduard extends Actor implements Output, Teller {
    public Eduard(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    @Override
    public void say(){
        System.out.println(name + ": No, I didn't do it!"); // says something in court
    }

    protected void doWork(){
        if ((thing != null) && (thing2 != null) && (thing2.getCondition() == Status.SENT)) {
            location = Location.COURT; // changes location
            go(job, name, location);

            thing.setCondition(Status.READY);
            changething(thing);
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
        Eduard eduard = (Eduard) o;
        return job == eduard.job &&
                Objects.equals(thing, eduard.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
