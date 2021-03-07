package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Davilons extends Actor implements Output, Teller {
    public Davilons(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }
    @Override
    public void say(){
        System.out.println(name + ": Poodle and Brechson is familiar. I saw them together on the day of the robbery!"); // says something
    }

    protected void doWork(){
        if ((thing != null) && (thing2 != null) && (nextActor != null) && (thing2.getCondition() == Status.SENT)){
            System.out.println(job + " " + name + " breaks " + thing.getName() + " and sit on the " + location);
            thing.setCondition(Status.BROKEN); // changes condition of thing
            changething(thing);

            condition = Status.SAD; // changes condition
            changecondition(job, name, condition);

            nextActor.condition = Status.SAD; // changes condition of the next Actor
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
        Davilons davilons = (Davilons) o;
        return job == davilons.job &&
                Objects.equals(thing, davilons.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
