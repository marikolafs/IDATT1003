import java.util.GregorianCalendar;
import java.util.Scanner;

public class ArbTaker {

    private Person personalia;
    private int arbtakernr;
    private int ansettelsesår;
    private double månedslønn;
    private double skatteprosent;
    GregorianCalendar kalender = new GregorianCalendar();

    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesår, double månedslønn, double skatteprosent) {

        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesår = ansettelsesår;
        this.månedslønn = månedslønn;
        this.skatteprosent = skatteprosent;
    }

    public Person getPersonalia() {

        return personalia;
    }

    public int getArbtakernr() {

        return arbtakernr;
    }

    public int getAnsettelsesår() {

        return ansettelsesår;
    }

    public double getMånedslønn() {

        return månedslønn;
    }

    public void setMånedslønn(double månedslønn) {

        this.månedslønn = månedslønn;
    }

    public double getSkatteprosent() {

        return skatteprosent;
    }

    public void setSkatteprosent(double skatteprosent) {

        this.skatteprosent = skatteprosent;
    }

    public double getSkattPerMåned() {

        return (månedslønn * skatteprosent) / 100;
    }

    public double getBruttoLønnPerÅr() {

        return månedslønn * 12;
    }

    public double getSkattertrekkPerÅr() {

        return (månedslønn * 10.5 * skatteprosent) / 100;
    }

    public String getNavn() {

        String navn = this.getPersonalia().getEtternavn() + ", " + this.getPersonalia().getFornavn();
        return navn;
    }

    public int getAlder() {

        int år = kalender.get(java.util.Calendar.YEAR);
        int alder = år - this.getPersonalia().getFødselsår();
        return alder;
    }

    public int getÅrAnsatt() {

        int år = kalender.get(java.util.Calendar.YEAR);
        int årAnsatt = år - this.getAnsettelsesår();
        return årAnsatt;
    }

    public boolean harVærtAnsattMerEnn(int antallÅr) {

        boolean merEnn = false;
        if (this.getÅrAnsatt() >= antallÅr) {
            merEnn = true;
        }
        return merEnn;
    }

    @Override
    public String toString() {

        return "Arbeidstaker personalia = " + getNavn() + ", arbtakernr = " + arbtakernr + ", ansettelsesår = " + ansettelsesår +
                ", antall år ansatt = " + getÅrAnsatt() + ", månedslønn = " + månedslønn + ", skatteprosent = " + skatteprosent + ", bruttolønn = " +
                getBruttoLønnPerÅr() + ", alder = " + getAlder();
    }
}
