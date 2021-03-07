package interfaces;

import enumerations.*;

public interface Condition {
    String getName();
    void setCondition(Status condition);
    void setLocation(Location location);
    Status getCondition();
}
