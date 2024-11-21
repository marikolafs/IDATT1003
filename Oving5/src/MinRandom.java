import java.util.Scanner;
import java.util.Random;

public class MinRandom {

    private Random random = new Random();
    static MinRandom minRandom = new MinRandom();
    static Scanner sc = new Scanner(System.in);

    public int nesteHeltall (int nedre, int ovre) {

        if (nedre >= ovre) {
            throw new IllegalArgumentException("Nedre grense må være mindre enn øvre grense.");
        }

        int diff = ovre - nedre;
        int svar = random.nextInt(diff);
        svar = svar + nedre;
        return svar;
    }

    public double nesteDesimaltall (double nedre, double ovre){

        if (nedre >= ovre) {
            throw new IllegalArgumentException("Nedre grense må være mindre enn øvre grense.");
        }

        double diff = ovre - nedre;
        double svar = random.nextDouble();
        svar = (svar * diff) + nedre;
        return svar;
    }

    public static void main(String[] args) {
        tekstKlient();
    }

    public static void tekstKlient() {

        System.out.println("Tast inn nedre grense for intervallet.");
        int nedre = sc.nextInt();
        System.out.println("Tast inn øvre grense for intervallet.");
        int ovre = sc.nextInt();

        System.out.println("Heltall mellom " + nedre + " og " + ovre + ".");
        for (int i = 0; i < 10; i++) {
            int heltall = minRandom.nesteHeltall(nedre, ovre);
            System.out.println(heltall);
        }
        System.out.println("Desimaltall mellom " + nedre + " og " + ovre + ".");
        for (int i = 0; i < 10; i++) {
            double desimaltall = minRandom.nesteDesimaltall(nedre, ovre);
            System.out.println(desimaltall);
        }

        System.out.println(minRandom.nesteHeltall(nedre, ovre));
        System.out.println(minRandom.nesteDesimaltall(nedre, ovre));
    }
}


