import java.util.Arrays;
import java.util.Scanner;

public class Tekstanalyse {
    private int[] antallTegn;

    public Tekstanalyse(String tekst) {
        antallTegn = new int[30];
        analyserTekst(tekst);
    }
    private void analyserTekst(String tekst) {
        tekst = tekst.toLowerCase();
        for (int i = 0; i < tekst.length(); i++) {
            char tegn = tekst.charAt(i);
            if (tegn >= 'a' && tegn <= 'z') {
                antallTegn[tegn - 'a']++;
            } else if (tegn == 'æ') {
                antallTegn[26]++;
            } else if (tegn == 'ø') {
                antallTegn[27]++;
            } else if (tegn == 'å') {
                antallTegn[28]++;
            } else {
                antallTegn[29]++;
            }
        }
    }

    public int forskjelligeBokstaver() {
        int antall = 0;
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > 0) {
                antall++;
            }
        }
        return antall;
    }

    public int sumBokstaver() {
        int sum = 0;
        for (int i = 0; i < 29; i++) {
            sum += antallTegn[i];
        }
        return sum;
    }

    public double prosentIkkeBokstaver() {
        int sumTegn = sumBokstaver() + antallTegn[29];
        if (sumTegn == 0) {
            return 0;
        }
        return ((double) antallTegn[29] / sumTegn) * 100;
    }

    public int antallForekomster(char bokstav) {

        bokstav = Character.toLowerCase(bokstav);
        if (bokstav >= 'a' && bokstav <= 'z') {
            return antallTegn[bokstav - 'a'];
        } else if (bokstav == 'æ') {
            return antallTegn[26];
        } else if (bokstav == 'ø') {
            return antallTegn[27];
        } else if (bokstav == 'å') {
            return antallTegn[28];
        } else {
            return 0;
        }


    }

    public String vanligsteBokstav() {
        int hoyest = 0;
        StringBuilder vanligste = new StringBuilder();
        for (int i = 0; i < 29; i++) {
            if (antallTegn[i] > hoyest) {
                hoyest = antallTegn[i];
                vanligste = new StringBuilder();
                vanligste.append((char) (i + 'a'));
            } else if (antallTegn[i] == hoyest && hoyest > 0) {
                vanligste.append(", ").append((char) (i + 'a'));
            }
        }
        return vanligste.toString();
    }

    public static void main(String[] args) {
        tekstAnalyseKlient();
    }

    public static void tekstAnalyseKlient() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Skriv inn teksten du vil analysere, hvis du vil avslutte programmet, skriv inn 'avslutt'.");
            String tekst = sc.nextLine();

            if (tekst.equalsIgnoreCase("avslutt")) {
                break;
            }

            Tekstanalyse analyse = new Tekstanalyse(tekst);

            System.out.println("Resultater fra analysen:");
            System.out.println("Antall forskjellige bokstaver i teksten: " + analyse.forskjelligeBokstaver());
            System.out.println("Totalt antall bokstaver i teksten: " + analyse.sumBokstaver());
            System.out.println("Prosentandel av teksten som ikke er bokstaver:" + analyse.prosentIkkeBokstaver());

            System.out.println("Skriv inn en bokstav for å se hvor ofte den forekommer i teksten.");
            char bokstav = sc.nextLine().charAt(0);
            System.out.println("Antall forekomster av '" + bokstav + "': " + analyse.antallForekomster(bokstav));

            System.out.println("Bokstav/er som forekommer oftest i teksten: " + analyse.vanligsteBokstav());
        }
    }
}

