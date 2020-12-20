package actors;

import actors.exceptions.LetterIsNotSentException;
import enumerations.Status;
import interfaces.*;

import java.util.ArrayList;
import java.util.Objects;

public class Court implements Adder {
    static ArrayList<Teller> witness = new ArrayList<Teller>();
    private Condition thing;

    public void addTeller(Teller teller){
        witness.add(teller);
    }
    @Override
    public void addThing(Condition thing){
        this.thing = thing;
    }
    @Override
    public void addThing2(Condition thing2){}

    int num = 1;
    String num_str;
    public void trial() throws LetterIsNotSentException {
        if ((thing != null) && (thing.getCondition() == Status.SENT)){
            switch (num) {
                case 1:
                    num_str = "first";
                    break;
                case 2:
                    num_str = "second";
                    break;
                case 3:
                    num_str = "third";
                    break;
            }
            System.out.println("The " + num_str +" trial is begun");
            for (int i = 0; i < witness.size(); i += 0) {
                witness.get(i).say(); // actor says something
                witness.remove(i);
            }
            System.out.println("The " + num_str + " trial is ended");
            num++;
        } else {
            throw new LetterIsNotSentException("Letter wasn't sent. The trial won't take place.");
        }
    }

    @Override
    public String toString() {
        return "It is a Court";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Court court = (Court) o;
        return Objects.equals(thing, court.thing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(thing);
    }
}
