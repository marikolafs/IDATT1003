import java.util.ArrayList;

public class Oppgaveoversikt {

    private ArrayList<Student> studenter;
    private int antStud = 0;

    public Oppgaveoversikt() {
        studenter = new ArrayList<Student>();
    }

    public int finnAntStud() {
        antStud = studenter.size();
        return antStud;
    }

    public int finnAntOppg(String navn) {
        for (Student s : studenter) {
            if (s.getNavn().equals(navn)) {
                return s.getAntOppg();
            }
        }
        return -1;
    }

    public void addStudent(String navn, int antOppg) {
        for (Student s : studenter) {
            if (s.getNavn().equals(navn)) {
                System.out.println("Studenten er allerede registrert.");
                return;
            }
        }
        studenter.add(new Student(navn, antOppg));
    }

    public void økAntOppgForStud(String navn, int økning) {
        for (Student s : studenter) {
            if (s.getNavn().equals(navn)) {
                s.økAntOppg(økning);
                return;
            }
        }
        System.out.println("Student er ikke registrert.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student s : studenter) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}
