import java.util.*;

public class Klient {

    public Scanner sc = new Scanner(System.in);
    public MenyRegister menyregister = new MenyRegister();

    public Klient () {

    }

    public static void main(String[] args) {
        Klient k = new Klient();
        k.testData();
        while(true) {
            k.visMeny();
        }
    }

    public void testData() {
        menyregister.registrerNyRett("Bruschetta med tomat og basilikum", "Forrett", 59, "Oppskrift:\n" +
                "Ingredienser: 4 skiver baguette, 2 store tomater, 1 fedd hvitløk, frisk basilikum, olivenolje, salt og pepper.\n" +
                "Fremgangsmåte:\n" +
                "Skjær baguetten i skiver og pensle med olivenolje. Rist skivene i ovnen på 200°C til de er sprø.\n" +
                "Skjær tomatene i små terninger og hakk basilikum.\n" +
                "Bland tomatene med basilikum, finhakket hvitløk, litt olivenolje, salt og pepper.\n" +
                "Topp baguetteskivene med tomatblandingen rett før servering.");
        menyregister.registrerNyRett("Cæsarsalat med grillet kylling", "hovedrett", 139, "Oppskrift:\n" +
                "Ingredienser: 1 romanosalat, 1 kyllingbryst, 2 ss Cæsardressing, 30g revet parmesan, 4-5 krutonger, olivenolje, salt og pepper.\n" +
                "Fremgangsmåte:\n" +
                "Krydre kyllingbrystet med salt og pepper, og stek det i litt olivenolje til det er gjennomstekt. Skjær i skiver.\n" +
                "Vask og riv romanosalat i biter. Legg den i en stor bolle.\n" +
                "Tilsett kyllingskivene, krutonger og revet parmesan.\n" +
                "Hell Cæsardressing over salaten og vend forsiktig sammen.");
        menyregister.registrerNyRett("Kremet sopp-pasta", "Hovedrett", 129, "Oppskrift:\n" +
                "Ingredienser: 200g pasta (fettuccine eller tagliatelle), 200g assortert sopp (sjampinjong, kantarell osv.), 1 dl fløte, 1 fedd hvitløk, 1 ts timian, smør til steking, salt og pepper.\n" +
                "Fremgangsmåte:\n" +
                "Kok pasta etter anvisning på pakken.\n" +
                "Skjær soppen i skiver, og stek den i smør sammen med hakket hvitløk og timian til den er gyllen.\n" +
                "Tilsett fløte og smak til med salt og pepper. La sausen småkoke i 5 minutter.\n" +
                "Vend den ferdigkokte pastaen inn i soppsausen og server umiddelbart.");
        menyregister.registrerNyRett("Entrecote med rødvinssaus og ovnsbakte grønnsaker", "Hovedrett", 249, "Oppskrift:\n" +
                "Ingredienser: 200g entrecôte, 1 dl rødvin, 1 ss smør, 1 gulrot, 1 rødløk, 1 paprika, 2 poteter, salt og pepper, frisk timian.\n" +
                "Fremgangsmåte:\n" +
                "Kutt grønnsakene i biter, dryss med salt og pepper, og stek dem i ovnen på 200°C i ca. 30 minutter.\n" +
                "Stek entrecôten i en varm panne med smør, ca. 3-4 minutter per side for medium stekt. Krydre med salt og pepper.\n" +
                "Ta ut kjøttet og hell rødvin i pannen. La vinen koke inn til en tykk saus og smak til med litt smør.\n" +
                "Server entrecôten med ovnsbakte grønnsaker og rødvinssaus. Pynt med frisk timian.");
        menyregister.registrerNyRett("Panna cotta med bringebærsaus", "Dessert", 89,"Oppskrift:\n" +
                "Ingredienser: 2 dl kremfløte, 2 ss sukker, 1 ts vaniljesukker, 1 gelatinplate, 100g bringebær, 1 ss sukker til sausen.\n" +
                "Fremgangsmåte:\n" +
                "Legg gelatinplaten i kaldt vann i 5 minutter.\n" +
                "Varm opp fløte, sukker og vaniljesukker til kokepunktet. Klem ut vannet fra gelatinplaten og rør den inn i den varme fløten.\n" +
                "Hell blandingen i små serveringsskåler og sett i kjøleskapet i minst 2 timer.\n" +
                "Lag bringebærsaus ved å koke bringebærene med sukker til de er myke. Press sausen gjennom en sil for å fjerne frøene.\n" +
                "Server panna cotta med en skje bringebærsaus på toppen.\n");
    }

    public void visMeny() {
        System.out.println("");
        System.out.println("1. Registrer ny rett");
        System.out.println("2. Finn rett");
        System.out.println("3. Skriv ut alle retter av en type");
        System.out.println("4. Registrer ny meny");
        System.out.println("5. FInn menyer med total pris innen gitt intervall");

        int menyInput = sc.nextInt();
        switch (menyInput) {
            case 1:
                nyRett();
                break;
                case 2:
                    finnRetterMedNavn();
                    break;
                    case 3:
                        finnRetterMedType();
                        break;
                        case 4:
                            nyMeny();
                            break;
                            case 5:
                                finnMenyerTotalPris();
                                break;
                                default:
                                    System.out.println("ugyldig svar");
                                    break;
        }
    }

    public void nyRett() {
        sc.nextLine();
        System.out.println("Navn: ");
        String navn = sc.nextLine();
        System.out.println("Type: ");
        String type = sc.nextLine();
        System.out.println("Pris: ");
        int pris = sc.nextInt();
        sc.nextLine();
        System.out.println("Oppskrift: ");
        String oppskrift = sc.nextLine();

        Rett nyRett = menyregister.registrerNyRett(navn, type, pris, oppskrift);
        System.out.println("Ny rett: ");
        System.out.println(nyRett.toString());
    }

    public void finnRetterMedNavn() {
        sc.nextLine();
        System.out.println("Navn: ");
        String navn = sc.nextLine();
        ArrayList<Rett> retter = menyregister.getRettMedNavn(navn);
        if (retter.size() > 0) {
            for (int i = 0; i < retter.size(); i++) {
                System.out.println(retter.get(i).toString());
            }
        } else {
            System.out.println("ugyldig svar");
        }
    }

    public void finnRetterMedType() {
        sc.nextLine();
        System.out.println("Type: ");
        String type = sc.nextLine();
        ArrayList<Rett> retter = menyregister.getRettMedType(type);
        if (retter.size() > 0) {
            for (int i = 0; i < retter.size(); i++) {
                System.out.println(retter.get(i).toString());
            }
        } else {
            System.out.println("ugyldig svar");
        }
    }

    public void nyMeny() {
        boolean ferdig = false;
        ArrayList<Rett> retter = new ArrayList<>();

        String alleRetter = "";
        for (int i = 0; i < menyregister.getRetter().size(); i++) {
            if (i != 0) {
                alleRetter += ", ";
            }
            alleRetter += menyregister.getRetter().get(i).toSmallString();
        }
        System.out.println("ny meny: ");
        System.out.println(alleRetter);

        sc.nextLine();
        while (!ferdig) {
            if (retter.size() < 1) {
                System.out.println("Skriv navn på rett som skal være i menyen: ");
            } else {
                System.out.println("Skriv inn navnet på neste rett du vil legge til i menyen, eller tast 1 for å fullføre");
            }
            String navn = sc.nextLine();
            if (navn.equals("1")) {
                ferdig = true;
            } else {
                ArrayList<Rett> nyRett = menyregister.getRettMedNavn(navn);
                if (nyRett.size() > 0) {
                    retter.add(nyRett.get(0));
                    System.out.println("retten ble lagt til i menyen");
                } else {
                    System.out.println("ugyldig svar");
                }
            }
        }

        System.out.println("menyen ble registrert");
        menyregister.registrerNyMeny(retter);
    }

    public void finnMenyerTotalPris() {
        System.out.println("minimum pris: ");
        int min = sc.nextInt();
        System.out.println("maximum pris: ");
        int max = sc.nextInt();
        ArrayList<Meny> menyer = menyregister.getMenyerMedPrisIntervall(min, max);
        System.out.println("menyer innenfor intervallet:");
        for (int i = 0; i < menyer.size(); i++) {
            System.out.println("meny nr " + (1 + i) + ": ");
            System.out.println(menyer.get(i).toString());
            System.out.println("");
        }
    }
}
