import java.util.ArrayList;

public class EiendomsRegister {

    // bruker ArrayList for økt fleksibilitet
    private ArrayList<Eiendom> eiendommer;

    public EiendomsRegister() {
        eiendommer = new ArrayList<>();
    }

    // metode for å registrere en eiendom i registeret

    public void addEiendom(Eiendom eiendom) {
        eiendommer.add(eiendom);
    }

    // metode for å slette en eiendom fra registeret basert på id
    // markeres som true hvis sletter, false hvis ikke funnet
    public boolean slettEiendom(int kommunenr, int gnr, int bnr) {
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getKommunenr() == kommunenr && eiendom.getGnr() == gnr && eiendom.getBnr() == bnr) {
                eiendommer.remove(eiendom);
                return true;
            }
        }
        return false;
    }

    // legg til en metode for å returnere antall eiendommer i registeret

    public int getAntallEiendommer() {
        return eiendommer.size();
    }

    // legg til en metode som regner ut gjennomsnittsareal av alle eiendommene i registeret

    public double getGjennomsnittAreal(){

        double nevner = 0;
        double sumAreal = 0;
        for (int i = 0; i < eiendommer.size(); i++) {
            nevner += 1;
            sumAreal += eiendommer.get(i).getAreal();
        }
        double gjennomsnittsAreal = sumAreal / nevner;
        return gjennomsnittsAreal;
    }

    // metode for å finne en eiendom basert på kommunenr, gnr og bnr

    public Eiendom søkEiendommer(int kommunenr, int gnr, int bnr) {

        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getKommunenr() == kommunenr && eiendom.getGnr() == gnr && eiendom.getBnr() == bnr) {
                return eiendom;
            }
        }
        return null;
    }

    // legg til metode som søker og returnerer samtlige eiendommer med gitt gnr

    public ArrayList<Eiendom> søkGårdsnummer(int gnr){
        ArrayList<Eiendom> gnrListe = new ArrayList<>();
        for (Eiendom eiendom : eiendommer) {
            if (eiendom.getGnr() == gnr) {
                gnrListe.add(eiendom);
            }
        }
        return gnrListe;
    }

    public ArrayList<Eiendom> getAlleEiendommer() {
        return new ArrayList<>(eiendommer);
    }
}
