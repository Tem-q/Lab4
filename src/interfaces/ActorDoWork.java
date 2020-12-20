package interfaces;

import actors.Actor;

@FunctionalInterface
public interface ActorDoWork {
    Actor actorDoWork(Actor actor);
}
