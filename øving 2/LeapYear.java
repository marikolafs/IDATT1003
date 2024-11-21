import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
      Scanner myObj = new Scanner(System.in);
      System.out.println("What year would you like to check?");
      int year = myObj.nextInt();
      if (year % 400 == 0) {
        System.out.println("The year " +year+ " is a leap year.");
      } else if ((year % 4 == 0) && (year % 100 != 0)) {
        System.out.println("The year " +year+ " is a leap year.");
      } else {
        System.out.println("The year "+year+ " is not a leap year.");
      }
  }
}