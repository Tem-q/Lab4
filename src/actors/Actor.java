package actors;
import actors.exceptions.MoneyIsNotGivenException;
import enumerations.*;
import interfaces.Adder;
import interfaces.Condition;

public abstract class Actor implements Adder {
    protected String name;
    protected Location location;
    protected Status condition;
    protected Actor nextActor;
    protected final TypeOfJob job;
    protected Condition thing;
    protected Condition thing2;
    public Actor(String name, Location location, TypeOfJob job, Status condition){
        this.name = name;
        this.location = location;
        this.job = job;
        this.condition = condition;
    }
    public String getName(){
        return name;
    }
    public Location getLocation(){
        return location;
    }
    public TypeOfJob getJob(){
        return job;
    }
    public void addActor(Actor nextActor){ // adds next Actor of the Actor type to do something with him
        this.nextActor = nextActor;
    }
    @Override
    public void addThing(Condition thing){
        this.thing = thing;
    }
    @Override
    public void addThing2(Condition thing2){
        this.thing2 = thing2;
    }

    protected abstract void doWork() throws MoneyIsNotGivenException;
}
