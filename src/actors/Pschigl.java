package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;


public class Pschigl extends Actor implements Output {
    public Pschigl(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    protected void doWork(){
        if ((thing2 != null) && (nextActor != null) && (thing2.getCondition() == Status.SENT)) {
            double a = Math.random();
            if (a >= 0.5) {
                nextActor.location = Location.POLICE_DEPARTMENT; // changes location
                go(nextActor.job, nextActor.name, nextActor.location);

                nextActor.condition = Status.SAD; // changes condition of the next Actor

                condition = Status.HAPPY; // changes condition
            } else {
                nextActor.condition = Status.HAPPY; // changes condition of the next Actor

                condition = Status.SAD; // changes condition
            }
            changecondition(nextActor.job, nextActor.name, nextActor.condition);
            changecondition(job, name, condition);
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
        Pschigl pschigl = (Pschigl) o;
        return job == pschigl.job &&
                Objects.equals(thing, pschigl.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }

}
