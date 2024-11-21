import java.util.Scanner;

public class Klient {

    private static Scanner sc = new Scanner(System.in);

    private static EiendomsRegister register = new EiendomsRegister();

    public static void main(String[] args) {
        Klient klient = new Klient();
        klient.testData();
        while(true) {
            klient.meny();
        }
    }

    public void testData() {
        register.addEiendom(new Eiendom(1445, "Gloppen", 77, 631, "", 1017.6, "Jens Olsen"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 77, 131, "Syningom", 661.3, "Nicolay Madsen"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 75, 19, "Fugletun", 650.6, "Evilyn Jensen"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 74, 188, "", 1457.2, "Karl Ove Bråten"));
        register.addEiendom(new Eiendom(1445, "Gloppen", 69, 47, "Høiberg", 1339.4, "Elsa Indregård"));
    }

    public void meny() {
        System.out.println("\n");
        System.out.println("Velkommen til eiendomsregister");
        System.out.println("Tast inn et tall for å utføre en operasjon: \n");
        System.out.println("1. Legg til eiendom");
        System.out.println("2. Slett en eiendom");
        System.out.println("3. Finn anntall eiendommer");
        System.out.println("4. Skriv ut liste over eiendommer");
        System.out.println("5. Søk etter eiendom basert på kommunenr, gnr og bnr");
        System.out.println("6. Skriv ut alle eiendommer med gitt gnr");
        System.out.println("7. Regn ut gjennomsnitts areal");
        System.out.println("8. Avslutt");

        int input = sc.nextInt();
        switch (input) {
            case 1:
                registrerEiendom();
                break;
            case 2:
                slettEiendom();
                break;
            case 3:
                visAntallEiendommer();
                break;
            case 4:
                SkrivUtAlleEiendommer();
                break;
            case 5:
                søkOgVisEiendom();
                break;
            case 6:
                søkOgVisGårdsnummer();
                break;
            case 7:
                regnOgVisGjennomsnittAreal();
                break;
            case 8:
                System.out.println("Avslutter programmet :)");
                System.exit(0);
                break;
            default:
                System.out.println("Ikke gyldig");
                break;
        }
    }

    private static void registrerEiendom() {
        System.out.println("Tast inn kommunenummer:");
        int kommunenr = sc.nextInt();
        sc.nextLine();
        System.out.println("Skriv inn kommunenavn:");
        String kommuneNavn = sc.nextLine();
        System.out.println("Skriv inn gårdsnummer:");
        int gnr = sc.nextInt();
        System.out.println("Skriv inn bruksnummer:");
        int bnr = sc.nextInt();
        sc.nextLine();
        System.out.println("Skriv inn bruksnavn (kan være tomt):");
        String bruksNavn = sc.nextLine();
        System.out.println("Skriv inn areal i m^2:");
        double areal = sc.nextDouble();
        sc.nextLine();
        System.out.println("Skriv inn navn på eiendommens eier:");
        String eierNavn = sc.nextLine();

        Eiendom eiendom = new Eiendom(kommunenr, kommuneNavn, gnr, bnr, bruksNavn, areal, eierNavn);
        register.addEiendom(eiendom);
        System.out.println("Eiendom er registrert");

    }

    private static void slettEiendom() {
        System.out.println("Skriv inn kommunenummer for eiendommen som skal slettes");
        int kommunenr = sc.nextInt();
        System.out.println("Skriv inn gårdsnummer:");
        int gnr = sc.nextInt();
        System.out.println("Skriv inn bruksnummer:");
        int bnr = sc.nextInt();

        boolean slettet = register.slettEiendom(kommunenr, gnr, bnr);

        if (slettet) {
            System.out.println("eiendommen er slettet");
        } else {
            System.out.println("Ikke gyldig");
        }
    }

    private static void visAntallEiendommer() {
        System.out.println("Antall registrerte eiendommer: " + register.getAntallEiendommer());
    }

    private static void SkrivUtAlleEiendommer() {
        System.out.println("\nAlle registrete eiendommer:");
        for (Eiendom eiendom : register.getAlleEiendommer()) {
            System.out.println(eiendom.getId() + ": " + (eiendom.getBruksNavn().isEmpty() ? "Uten navn" : eiendom.getBruksNavn()) + ", eier: " + eiendom.getEierNavn());
        }
    }

    private static void søkOgVisEiendom() {
        System.out.println("Skriv inn kommunenummer: ");
        int kommunenr = sc.nextInt();
        System.out.println("Skriv inn gårdsnummer: ");
        int gnr = sc.nextInt();
        System.out.println("Skriv inn bruksnummer: ");
        int bnr = sc.nextInt();

        Eiendom eiendom = register.søkEiendommer(kommunenr, gnr, bnr);
        if (eiendom != null) {
            System.out.println("Eiendom er funnet: " + eiendom.getId() + ", Navn:" + (eiendom.getBruksNavn().isEmpty() ? "Uten navn" : eiendom.getBruksNavn()) +", eier: " + eiendom.getEierNavn());
        } else {
            System.out.println("Ikke gyldig");
        }
    }

    private static void regnOgVisGjennomsnittAreal() {
        double gjennomsnitt = register.getGjennomsnittAreal();
        System.out.println("Gjennomsnittsareal: " + gjennomsnitt);
    }

    private static void søkOgVisGårdsnummer() {
        System.out.println("Skriv inn gårdsnummer:");
        int gnr = sc.nextInt();

        var eiendommer = register.søkGårdsnummer(gnr);
        if (eiendommer.isEmpty()) {
            System.out.println("ikke gyldig");
        } else {
            System.out.println("Eiendommer med gårdsnummer " + gnr + ":");
            for (Eiendom eiendom : eiendommer) {
                System.out.println(eiendom.getId() + ", eier: " + eiendom.getEierNavn());
            }
        }
    }
}