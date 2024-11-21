import java.util.*;
import java.util.Collections;

public class Klient {
    private Scanner sc = new Scanner(System.in);
    private ArrangementRegister register = new ArrangementRegister();

    public static void main (String[] args) {
        Klient k = new Klient();
        while (true) {
            k.visMeny();
        }
    }

    public void visMeny() {
        System.out.println("");
        System.out.println("1. Registrer nytt arrangement");
        System.out.println("2. Finn alle arrangemnter på et sted");
        System.out.println("3. Finn alle arrangemnter på en dato");
        System.out.println("4. Finn alle arrangementer innenfor et tidsintervall");
        System.out.println("5. Se alle arrangementer");

        int menyInput = sc.nextInt();
        switch (menyInput) {
            case 1:
                lagArrangement();
                break;
                case 2:
                    finnStedArrangementer();
                    break;
                    case 3:
                        finnDatoArrangemnter();
                        break;
                        case 4:
                            mellomArrangementer();
                            break;
                            case 5:
                                alleArrangementer();
                                break;
            case 6:

                                default:
                                    System.out.println("Ugyldig svar");
                                    break;
        }
    }
    public void skrivUtArrangement(ArrayList<Arrangement> liste) {
        System.out.println("");
        if (liste.size() > 0) {
            for (int i = 0; i < liste.size(); i++) {
                System.out.println(liste.get(i).toString());
            }
        } else {
            System.out.println("Ugyldig svar");
        }
    }

    private void lagArrangement() {
        sc.nextLine();
        System.out.println("Navn: ");
        String navn = sc.nextLine();
        System.out.println("Sted: ");
        String sted = sc.nextLine();
        System.out.println("Arrangør: ");
        String arrangor = sc.nextLine();
        System.out.println("Type: ");
        String type = sc.nextLine();
        System.out.println("Tidspunkt (YYYYMMDDTTMM): ");
        double tidspunkt = sc.nextDouble();
        Arrangement a = register.nyttArrangement(navn, sted, arrangor, type, tidspunkt);
        register.arrangementer.add(a);
    }

    private void finnStedArrangementer() {
        sc.nextLine();
        System.out.println("Sted: ");
        String sted = sc.nextLine();
        skrivUtArrangement(register.stedArrangementer(sted));
    }

    private void finnDatoArrangemnter() {
        System.out.println("Dato (YYYYMMDD): ");
        double tidspunkt = sc.nextDouble();
        skrivUtArrangement(register.datoArrangementer(tidspunkt));
    }

    private void mellomArrangementer() {
        System.out.println("Start (YYYYMMDD): ");
        double tidspunkt1 = sc.nextDouble();
        System.out.println("Slutt (YYYYMMDD): ");
        double tidspunkt2 = sc.nextDouble();
        if (tidspunkt1 < tidspunkt2) {
            skrivUtArrangement(register.mellomDatoArrangement(tidspunkt1, tidspunkt2));
        } else {
            System.out.println("Ugyldig svar");
        }
    }

    private void alleArrangementer() {
        System.out.println("1. sorter etter sted");
        System.out.println("2. sorter etter en dato");
        System.out.println("3. sorter etter type");
        int Input =sc.nextInt();
        switch (Input) {
            case 1:
                Comparator<Arrangement> sorterEtterSted = (Arrangement a1, Arrangement a2) -> a1.getSted().compareTo(a2.getSted());
                ArrayList<Arrangement> ar1 =register.arrangementer;
                Collections.sort(ar1, sorterEtterSted);
                skrivUtArrangement(ar1);
                break;
                case 2:
                    Comparator<Arrangement> sorterEtterDato = (Arrangement a1, Arrangement a2) -> (int)a1.getTidspunkt() - (int)a2.getTidspunkt();
                    ArrayList<Arrangement> ar2 =register.arrangementer;
                    Collections.sort(ar2, sorterEtterDato);
                    skrivUtArrangement(ar2);
                    break;
                    case 3:
                        Comparator<Arrangement> sorterEtterType = (Arrangement a1, Arrangement a2) -> a1.getType().compareTo(a2.getType());
                        ArrayList<Arrangement> ar3 =register.arrangementer;
                        Collections.sort(ar3, sorterEtterType);
                        skrivUtArrangement(ar3);
                        break;
            default:
                System.out.println("Ugyldig svar");
                alleArrangementer();
                break;
        }
    }

}
