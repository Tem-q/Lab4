package interfaces;

import actors.Actor;

@FunctionalInterface
public interface ActorDoWork {
    String sentence(String s);
}
