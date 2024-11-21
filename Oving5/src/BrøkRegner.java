import java.util.Scanner;

public class BrøkRegner {

    public double nevner;
    private double teller;
    private static double svar;

    public BrøkRegner(double teller, double nevner) {
        if (nevner == 0) {
            throw new IllegalArgumentException("Nevner kan ikke være null.");
        } else {
            this.teller = teller;
            this.nevner = nevner;
        }
    }

    public BrøkRegner(double teller) {
        this.teller = teller;
        this.nevner = 1;
    }

    public double getTeller() {
        return teller;
    }

    public double getNevner() {
        return nevner;
    }

    public void summere(BrøkRegner annen) {
        this.teller = (this.teller * annen.nevner) + (annen.teller * this.nevner);
        this.nevner = this.nevner * annen.nevner;
    }

    public void subtrahere(BrøkRegner annen) {
        this.teller = this.teller * annen.nevner - annen.teller * this.nevner;
        this.nevner = this.nevner * annen.nevner;
    }

    public void multiplisere(BrøkRegner annen) {
        this.teller = this.teller * annen.teller;
        this.nevner = this.nevner * annen.nevner;
    }

    public void dividere(BrøkRegner annen) {
        if (annen.teller == 0) {
            throw new IllegalArgumentException("Kan ikke dele på null.");
        }
        this.teller = this.teller * annen.nevner;
        this.nevner = this.nevner * annen.teller;
    }

    public String toString() {
        return teller + "/" + nevner;
    }

    public static void main(String[] args) {
        BrøkRegner brøk1 = new BrøkRegner(3, 4);
        BrøkRegner brøk2 = new BrøkRegner(2, 3);

        Scanner sc = new Scanner(System.in);
        int input;

        brøk1.summere(brøk2);
        System.out.println("Summen av brøk 1 og 2 er " + brøk1);
        brøk1 = new BrøkRegner(3, 4);

        brøk1.subtrahere(brøk2);
        System.out.println("Differansen av brøk 1 og brøk 2 er " + brøk1);
        brøk1 = new BrøkRegner(3, 4);

        brøk1.multiplisere(brøk2);
        System.out.println("Brøk 1 multiplisert med brøk 2 er " + brøk1);
        brøk1 = new BrøkRegner(3, 4);

        brøk1.dividere(brøk2);
        System.out.println("Brøk 1 dividert med brøk 2 er " + brøk1);
    }
}
