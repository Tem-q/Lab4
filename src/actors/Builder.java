package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Builder extends Actor implements Output {
    public Builder(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    protected void doWork(){
        if ((thing != null) && (thing2 != null) && (nextActor != null) && (thing2.getCondition() == Status.SENT)) {
            location = Location.KUKS_HOME; // changes location
            go(job, name, location);

            thing.setCondition(Status.BROKEN); // changes condition of thing
            changething(thing);

            condition = Status.HAPPY; // changes condition
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
        Builder builder = (Builder) o;
        return job == builder.job &&
                Objects.equals(thing, builder.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }

}
