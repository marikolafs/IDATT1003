public class Student {
    private String navn;
    private int antOppg;

    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntOppg() {
        return antOppg;
    }

    public void økAntOppg(int økning) {
        if (økning > 0) {
            this.antOppg += økning;
        }
    }

    @Override
    public String toString() {
        return "Student [navn: " + navn + ", antall godkjente oppgaver: " + antOppg + "]";
    }

}