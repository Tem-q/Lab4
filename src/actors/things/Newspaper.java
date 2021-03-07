package actors.things;

import enumerations.*;

import java.util.Objects;

public class Newspaper extends Thing {
    public Newspaper(String name, Location location, Status condition) {
        super(name, location, condition);
    }
    public class Article extends Newspaper {
        public Article(String name, Location location, Status condition) {
            super(name, location, condition);
        }
    }
    @Override
    public String toString() {
        return name + " is " + condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(name, newspaper.name) &&
                location == newspaper.location &&
                condition == newspaper.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, condition);
    }

}
