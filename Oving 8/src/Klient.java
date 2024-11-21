import java.util.Scanner;

public class Klient {
    public static void main(String[] args) {

        Person person = new Person("Maria", "Olafsdottir", 2003);

        ArbTaker arbTaker = new ArbTaker(person, 123, 2020, 10000, 15);

        System.out.println("\nNavn: " + arbTaker.getNavn());
        System.out.println("Alder: " + arbTaker.getAlder());
        System.out.println("Antall år ansatt: " + arbTaker.getÅrAnsatt());
        System.out.println("Skatt per måned: " + arbTaker.getSkattPerMåned());
        System.out.println("Skatt per år: " + arbTaker.getSkattertrekkPerÅr());
        System.out.println("Bruttolønn per år: " + arbTaker.getBruttoLønnPerÅr());
        System.out.println("Har personen vært ansatt mer enn 10 år? " + arbTaker.harVærtAnsattMerEnn(10));

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nHva vil du gjøre?");
            System.out.println("1 Endre månedslønn");
            System.out.println("2 Endre skatteprosent");
            System.out.println("3 Print ut data");
            System.out.println("4 Avslutt");
            int valg = sc.nextInt();

            if (valg == 1) {
                System.out.print("Skriv inn ny månedslønn: ");
                double nyLønn = sc.nextDouble();
                arbTaker.setMånedslønn(nyLønn);
                System.out.println("Ny månedslønn: " + arbTaker.getMånedslønn());
            } else if (valg == 2) {
                System.out.println("Skriv inn ny skatteprosent: ");
                double nySkatt = sc.nextDouble();
                arbTaker.setSkatteprosent(nySkatt);
                System.out.println("Ny skatteprosent: " + arbTaker.getSkatteprosent());
            } else if (valg == 3) {
                System.out.println(arbTaker);
            } else if (valg == 4) {
                break;
            }
        }
    }
}


