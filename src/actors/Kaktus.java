package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Kaktus extends Actor implements Output, Teller {
    public Kaktus(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }
    int courtnum = 1;
    @Override
    public void say(){
        if (courtnum == 1) {
            System.out.println(name + ": I didn't write this letter! "); // says something in court
            courtnum++;
        } else {
            System.out.println(name + ": You typed this letter!"); // says something in court
        }
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
        Kaktus kaktus = (Kaktus) o;
        return job == kaktus.job &&
                Objects.equals(thing, kaktus.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
