package actors;

import actors.exceptions.MoneyIsNotGivenException;

import java.util.ArrayList;

public class Story {
    static ArrayList<Actor> person = new ArrayList<Actor>();

    public void addActor(Actor actor){
        person.add(actor);
    }

    public void storyline() throws MoneyIsNotGivenException {
        for (int i = 0; i < person.size(); i += 0){
            person.get(i).doWork(); // every actor does their job
            person.remove(i);
        }
    }

    @Override
    public String toString() {
        return "It is a Story";
    }
}
