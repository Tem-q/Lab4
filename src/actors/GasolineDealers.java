package actors;

import enumerations.*;
import interfaces.Output;
import interfaces.Teller;

import java.util.Objects;

public class GasolineDealers extends Actor implements Output, Teller {
    public GasolineDealers(String name, Location location, TypeOfJob job, Status condition){
        super(name, location, job, condition);
    }

    @Override
    public void say(){
        System.out.println(name + ": This " + TypeOfJob.MAKE_AUTO_TIRE + " sent this letter!"); // says something in court
    }

    protected void doWork(){
        if ((nextActor != null) && (condition == Status.SAD)) {
            location = Location.COURT; // changes location
            go(job, name, location);
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
        GasolineDealers that = (GasolineDealers) o;
        return job == that.job;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job);
    }
}
