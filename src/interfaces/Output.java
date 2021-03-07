package interfaces;

import enumerations.*;

public interface Output {
    default void go(TypeOfJob job, String name, Location location) {
        System.out.println(job + " " + name + " goes to the " + location); // displays a message about moving the actor
    }
    default void changething(Condition thing) {
        System.out.println("The " + thing.getName() + " is " + thing.getCondition()); // displays a message about changes in the thing's status
    }
    default void changecondition(TypeOfJob job, String name, Status condition) {
        System.out.println(job + " " + name + " is " + condition); // displays a message about changes in the actor's condition
    }
    default void printArticle(TypeOfJob job, String name) {
        System.out.println(job + " " + name + ": This week's news: The bank was robbed. There are 3 trials going on");
    }
    default void printPoster() {
        System.out.println("Poster: The shorties won't be sorry. And they won't waste their money if they buy shares in the giant plant society, one furling a piece!");
    }
}
