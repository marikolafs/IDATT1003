import java.util.Random;

public class RandomTall {
    static java.util.Random random = new java.util.Random();
    private static int tall = random.nextInt(10);
    private static int[] antall = new int[10];

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int tall = random.nextInt(10);
            antall[tall]++;
        }

        for (int i = 0; i < 10; i++) {
            int sum = antall[i];
            System.out.println("Tallet " + i + " forekom " + sum + " ganger.");
        }
    }
}

