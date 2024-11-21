import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class ArrangementRegister {

    public ArrayList<Arrangement> arrangementer;

    public ArrangementRegister() {
        arrangementer = new ArrayList<>();
    }

    public Arrangement nyttArrangement(String navn, String sted, String arrangor, String type, double tidspunkt) {
        int nummer = arrangementer.size();
        Arrangement arrangement = new Arrangement(nummer, navn, sted, arrangor, type, tidspunkt);
        return arrangement;
    }

    public ArrayList<Arrangement> stedArrangementer(String sted) {
        ArrayList<Arrangement> arrangementerSted = new ArrayList<>();
        for (int i = 0; i < arrangementer.size(); i++) {
            if (arrangementer.get(i).getSted().equals(sted)) {
                arrangementerSted.add(arrangementer.get(i));
            }
        }
        return arrangementerSted;
    }

    public ArrayList<Arrangement> datoArrangementer(double tidspunkt) {
        ArrayList<Arrangement> arrangementerDato = new ArrayList<>();
        for (int i = 0; i < arrangementer.size(); i++) {
            int Dato = (int)Math.floor(arrangementer.get(i).getTidspunkt() / 10000);
            if (Dato == (int)tidspunkt) {
                arrangementerDato.add(arrangementer.get(i));
            }
        }
        return arrangementerDato;
    }

    public ArrayList<Arrangement> mellomDatoArrangement(double tidspunkt1, double tidspunkt2) {
        ArrayList<Arrangement> arrangementerDato = new ArrayList<>();
        for (int i = 0; i < arrangementer.size(); i++) {
            int Dato = (int)Math.floor(arrangementer.get(i).getTidspunkt() / 10000);
            if (Dato >= (int)tidspunkt1 && Dato <= (int)tidspunkt2) {
                arrangementerDato.add(arrangementer.get(i));
            }
        }
        Comparator<Arrangement> sorterTidspunkter = (Arrangement a1, Arrangement a2) -> (int)a1.getTidspunkt() - (int)a2.getTidspunkt();
        Collections.sort(arrangementerDato, sorterTidspunkter);
        return arrangementerDato;
    }
}
