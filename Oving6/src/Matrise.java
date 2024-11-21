public class Matrise {
    private final int [][] matrise;
    public Matrise(int [][] matrise) {
        this.matrise = new int [matrise.length][matrise[0].length];
        for (int i = 0; i < matrise.length; i++) {
            System.arraycopy(matrise[i], 0, this.matrise[i], 0, matrise[i].length);
        }
    }

    public Matrise addere(Matrise annen) {
        if (matrise.length != annen.matrise.length || matrise[0].length != annen.matrise[0].length) {
            return null;
        }
        int [][] svar = new int[matrise.length][matrise[0].length];
        for (int i = 0; i < matrise.length; i++) {
            for (int j = 0; j < matrise[0].length; j++) {
                svar[i][j] = matrise[i][j] + annen.matrise[i][j];
            }
        }
        return new Matrise(svar);
    }

    public Matrise multiplisere(Matrise annen) {
        if (matrise[0].length != annen.matrise.length) {
            return null;
        }
        int [][] svar = new int[matrise.length][matrise[0].length];
        for (int i = 0; i < matrise.length; i++) {
            for (int j = 0; j < annen.matrise[0].length; j++) {
                for (int k = 0; k < matrise[0].length; k++) {
                    svar[i][j] += matrise[i][j] * annen.matrise[i][j];
                }
            }
        }
        return new Matrise(svar);
    }

    public Matrise transponere() {
        int [][] svar = new int[matrise[0].length][matrise.length];
        for (int i = 0; i < matrise.length; i++) {
            for (int j = 0; j < matrise[i].length; j++) {
                svar[i][j] = matrise[i][j];
            }
        }
        return new Matrise(svar);
    }

    public void printMatrise() {
        for (int[] rad : matrise) {
            for (int verdi : rad) {
                System.out.print(verdi + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getRader() {
        return matrise.length;
    }

    public int getKolonner() {
        return matrise[0].length;
    }

    public static void tekstklient() {

        int [][] matrise1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int [][] matrise2 = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        Matrise annen1 = new Matrise(matrise1);
        Matrise annen2 = new Matrise(matrise2);

        System.out.println("Addisjon av matrise 1 og 2.");
        Matrise addisjon = annen1.addere(annen2);
        if (addisjon != null) {
            addisjon.printMatrise();
        } else {
            System.out.println("Det er ikke mulig å addere disse to matrisene.");
        }

        System.out.println("Multiplikasjon av matrise 1 og 2.");
        Matrise multiplikasjon = annen1.multiplisere(annen2);
        if (multiplikasjon != null) {
            multiplikasjon.printMatrise();
        } else {
            System.out.println("Det er ikke mulig å multiplisere disse to matrisene.");
        }

        System.out.println("Transponering av matrise 1 og 2.");
        Matrise transponering1 = annen1.transponere();
        transponering1.printMatrise();
        Matrise transponering2 = annen2.transponere();
        transponering2.printMatrise();

    }

    public static void main(String[] args) {
        tekstklient();
    }
}