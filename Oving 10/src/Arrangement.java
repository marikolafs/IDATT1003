public class Arrangement {

    private final int nummer;
    private final String navn;
    private final String sted;
    private String arrangor;
    private final String type;
    private final double tidspunkt;

    public Arrangement (int nummer, String navn, String sted, String arangor, String type, double tidspunkt) {
        this.nummer = nummer;
        this.navn = navn;
        this.sted = sted;
        this.arrangor = arrangor;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }

    public String getArrangor() {
        return arrangor;
    }

    public String getType() {
        return type;
    }

    public double getTidspunkt() {
        return tidspunkt;
    }

    @Override
    public String toString() {
        String t = String.format("%.1f", this.getTidspunkt());
        String tid = t.substring(6, 8) + "." + t.substring(4, 6) + "." + t.substring(8, 10) + ":" + t.substring(10, 12);
        return "Nummer: " + this.getNummer() + ", navn: " + this.getNavn() + ", sted: " + this.getSted() + ", arrangør: " + this.getArrangor() + ", type: " + this.getType() + ", tidspunkt: " + tid;

    }


}