package actors;

import enumerations.Location;
import enumerations.Status;
import enumerations.TypeOfJob;
import interfaces.Output;

import java.util.Objects;

public class TVpresenter extends Actor implements Output {
    public TVpresenter(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    protected void doWork(){
        if ((thing2 != null) && (thing2.getCondition() == Status.READY)) {
            condition = Status.HAPPY; // changes condition
            changecondition(job, name, condition);

            printArticle(job, name);
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
        TVpresenter tVpresenter = (TVpresenter) o;
        return job == tVpresenter.job &&
                Objects.equals(thing, tVpresenter.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(job, thing);
    }
}
