
public class CheapMince {
    public static void main(String[] args) {
        double priceA = 35.9;
        double weightA = 450;
        double priceB = 39.5;
        double weightB = 500;

        if ((priceA / weightA) < (priceB / weightB)) {
            System.out.println("Mince A is cheaper than mince B.");
        } else if ((priceA / weightA) > (priceB / weightB)) {
            System.out.println("Mince B is cheaper than mince A.");
        } else {
            System.out.println("Mince A and mince B have the same price per kg.");
        }
    }
}
