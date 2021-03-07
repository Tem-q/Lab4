package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;
import java.lang.Math;

public class Mafia extends Actor implements Output {
    public Mafia(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    protected void doWork(){
        location = Location.BANK;
        go(job, name, location);
        double a = Math.random();
        if ((a >= 0.5) && (nextActor != null)){ // a 50% chance...
            Story.person.remove(1); // ...to kill the next actor
            System.out.println(job + " " + name + " killed " + nextActor.getJob() + " " + nextActor.getName());
            condition = Status.SAD; // changes condition
        } else if ((a < 0.5) && (nextActor != null)) {
            condition = Status.HAPPY; // changes condition
        }
        changecondition(job, name, condition);

    }

    @Override
    public String toString() {
        return  name + " is " + job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mafia mafia = (Mafia) o;
        return job == mafia.job;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job);
    }
}
