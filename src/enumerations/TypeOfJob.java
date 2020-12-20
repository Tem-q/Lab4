package enumerations;

public enum TypeOfJob { // all types of possible jobs:
    MAKE_AUTO_TIRE("Manufacturer"),
    SELL_GASOLINE("Gasoline seller"),
    BIKER ("Biker"),
    BANKER ("Banker"),
    FILM_CRITIC ("Film critic"),
    CRIMINAL_ACTIVITY ("Mafioznik"),
    FREELANCER ("Freelancer"),
    POLICEMAN ("Policeman"),
    POLICE_OFFICER ("Police officer"),
    EDITOR ("Editor"),
    BUILDER ("Builder"),
    DESIGNER ("Designer"),
    TV_PRESENTER ("TV presenter"),
    BUSINESSMAN ("Businessman"),
    OWNER ("Owner of house"),
    LODGER ("Lodger");

    private String ToJ;

    TypeOfJob(String ToJ) {
        this.ToJ = ToJ;
    }

    @Override
    public String toString() {
        return ToJ;
    }

}
