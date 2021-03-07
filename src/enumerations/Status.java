package enumerations;

public enum Status { // all actor's condition and thing's states:
    BROKEN ("Broken"),
    OK ("Repaired"),
    READY ("Ready"),
    NOT_READY ("Not ready"),
    SENT ("Sent"),
    NOT_SENT ("Not sent"),
    GIVEN ("Given"),
    NOT_GIVEN ("Not given"),
    HAPPY ("Happy"),
    NEUTRAL ("Neutral"),
    SAD ("Sad");

    private String Stat;

    Status(String Stat) {
        this.Stat = Stat;
    }

    @Override
    public String toString() {
        return Stat;
    }
}
