import java.util.*;

public class Meny {

    private ArrayList<Rett> menyRetter;

    public Meny(ArrayList<Rett> menyRetter) {
        this.menyRetter = menyRetter;
    }

    public ArrayList<Rett> getMenyRetter() {
        return menyRetter;
    }

    public double getTotalPris() {
        double pris = 0;
        for (int i = 0; i < menyRetter.size(); i++) {
            pris += menyRetter.get(i).getPris();
        }
        return pris;
    }

    public String toString() {
        String menyRetter = "";
        for (int i = 0; i < getMenyRetter().size(); i++) {
            if (i != 0) {
                menyRetter += ", ";
            }
            menyRetter += getMenyRetter().get(i).toSmallString();
        }
        menyRetter += "\nTotalPris: " + getTotalPris();
        return menyRetter;
    }
}
