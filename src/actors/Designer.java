package actors;

import enumerations.*;
import interfaces.*;

import java.util.Objects;

public class Designer extends Actor implements Output {
    public Designer(String name, Location location, TypeOfJob job, Status condition) {
        super(name, location, job, condition);
    }
    protected void doWork(){
        if ((thing != null) && (thing2 != null)  && (thing2.getCondition() == Status.SENT)) {
            thing.setCondition(Status.READY); // changes condition of thing
            changething(thing);

            printPoster();
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
        Designer designer = (Designer) o;
        return job == designer.job &&
                Objects.equals(thing, designer.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
