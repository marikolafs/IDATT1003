import java.util.*;

public class MenyRegister {

    private ArrayList<Meny> menyer;
    private ArrayList<Rett> retter;

    public MenyRegister() {
        menyer = new ArrayList<>();
        retter = new ArrayList<>();
    }

    public ArrayList<Meny> getMenyer() {
        return menyer;
    }
    public ArrayList<Rett> getRetter() {
        return retter;
    }

    public Rett registrerNyRett(String navn, String type, double pris, String oppskrift) {
        Rett nyRett = new Rett(navn, type, pris, oppskrift);
        retter.add(nyRett);
        return nyRett;
    }

    public ArrayList<Rett> getRettMedNavn(String navn) {
        ArrayList<Rett> rettMedNavn = new ArrayList<>();
        for (int i = 0; i < getRetter().size(); i++) {
            if (getRetter().get(i).getNavn().toLowerCase().equals(navn.toLowerCase())) {
                rettMedNavn.add(getRetter().get(i));
            }
        }
        return rettMedNavn;
    }

    public ArrayList<Rett> getRettMedType(String type) {
        ArrayList<Rett> rettMedType = new ArrayList<>();
        for (int i = 0; i < getRetter().size(); i++) {
            if (getRetter().get(i).getType().toLowerCase().equals(type.toLowerCase())) {
                rettMedType.add(getRetter().get(i));
            }
        }
        return rettMedType;
    }

    public Meny registrerNyMeny(ArrayList<Rett> menyRetter) {
        Meny nyMeny = new Meny(menyRetter);
        getMenyer().add(nyMeny);
        return nyMeny;
    }

    public ArrayList<Meny> getMenyerMedPrisIntervall(double min, double max) {
        ArrayList<Meny> menyArray = new ArrayList<Meny>();
        for (int i = 0; i < getMenyer().size(); i++) {
            if (getMenyer().get(i).getTotalPris() >= min && getMenyer().get(i).getTotalPris() <= max) {
                menyArray.add(getMenyer().get(i));
            }
        }
        return menyArray;
    }
}