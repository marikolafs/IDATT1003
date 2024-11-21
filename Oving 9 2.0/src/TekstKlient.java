import java.util.Scanner;

public class TekstKlient {
    public static void main(String[] args) {
        Oppgaveoversikt oversikt = new Oppgaveoversikt();
        Scanner sc = new Scanner(System.in);
        boolean kjør = true;

        while (kjør) {
            System.out.println("\nHva vil du gjøre?");
            System.out.println("1 Registrer ny student");
            System.out.println("2 Vis antall studenter");
            System.out.println("3 Vis antall godkjente oppgaver for en student");
            System.out.println("4 Øk antall godkjente oppgaver for en student");
            System.out.println("5 Print ut liste over alle studenter");
            System.out.println("6 Avslutt");

            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    System.out.println("Skriv inn studentens navn:");
                    String navn = sc.nextLine();
                    System.out.println("Skriv inn antall godkjente oppgaver studenten har:");
                    int antOppg = sc.nextInt();
                    oversikt.addStudent(navn, antOppg);
                    break;

                    case 2:
                        System.out.println("Antall studenter: " + oversikt.finnAntStud());
                        break;

                        case 3:
                            System.out.println("Skriv inn studentens navn: ");
                            navn = sc.nextLine();
                            int oppg = oversikt.finnAntOppg(navn);
                            if (oppg != -1) {
                                System.out.println(navn + " har " + oppg + " oppgaver godkjent.");
                            } else {
                                System.out.println("studenten er ikke registrert.");
                            }
                            break;

                            case 4:
                                System.out.println("skriv inn studentens navn: ");
                                navn = sc.nextLine();
                                System.out.println("Skriv inn antall godkjente oppgaver som skal legges til:");
                                int økning = sc.nextInt();
                                oversikt.økAntOppgForStud(navn, økning);
                                break;

                                case 5:
                                    System.out.println(oversikt);
                                    break;

                                    case 6:
                                        kjør = false;
                                        break;

                                        default:
                                            System.out.println("Ugyldig valg, prøv igjen.");
                                            break;
            }
        }

        sc.close();
    }
}
