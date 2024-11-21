public class Eiendom {

    private int kommunenr;
    private String kommuneNavn;
    private int gnr; // Gårdsnummer
    private int bnr; // Bruksnummer
    private String bruksNavn; // Navn på eiendommen
    private double areal; // Areal i m^2
    private String eierNavn; // Navn på eieren

    // Konstruktør
    public Eiendom (int kommunenr, String kommuneNavn, int gnr, int bnr, String bruksNavn, double areal, String eierNavn) {
        this.kommunenr = kommunenr;
        this.kommuneNavn = kommuneNavn;
        this.gnr = gnr;
        this.bnr = bnr;
        this.bruksNavn = bruksNavn;
        this.areal = areal;
        this.eierNavn = eierNavn;
    }

    // Aksessor metoder
    public int getKommunenr() {
        return kommunenr;
    }

    public String getKommuneNavn() {
        return kommuneNavn;
    }

    public int getGnr() {
        return gnr;
    }

    public int getBnr() {
        return bnr;
    }

    public String getBruksNavn() {
        return bruksNavn;
    }

    public double getAreal() {
        return areal;
    }

    public String getEierNavn() {
        return eierNavn;
    }

    // mutator metoder
    // disse kan alle endres over tid, mens de andre er statiske
    public void setBruksNavn(String bruksNavn) {
        this.bruksNavn = bruksNavn;
    }

    public void setAreal(double areal) {
        this.areal = areal;
    }

    public void setEierNavn(String eierNavn) {
        this.eierNavn = eierNavn;
    }

    // metode som setter en id for eiendommen i formatet kommunenummer-gnr/bnr
    public String getId() {
        return kommunenr + "-" + gnr + "/" + bnr;
    }
}
