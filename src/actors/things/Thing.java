package actors.things;

import enumerations.*;
import interfaces.Condition;

public class Thing implements Condition {
    protected String name;
    protected Location location;
    protected Status condition;
    public Thing (String name, Location location, Status condition) {
        this.name = name;
        this.location = location;
        this.condition = condition;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCondition(Status condition) {
        this.condition = condition;
    }

    @Override
    public Status getCondition() {
        return condition;
    }

    @Override
    public void setLocation(Location location){
        this.location = location;
    }
}
