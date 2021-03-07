package enumerations;

public enum Location { // all locations:
    STREET ("Street"),
    COURT ("Court"),
    NEWS ("Newspaper"),
    BANK ("Bank"),
    POLICE_DEPARTMENT ("Police department"),
    OFFICE ("Office"),
    BRECHSON_HOME ("Brechson's house"),
    MAFIA_HOME ("Shelter"),
    KUKS_HOME ("Kuks's house");

    private String L;

    Location(String L) {
        this.L = L;
    }

    @Override
    public String toString() {
        return L;
    }
}
