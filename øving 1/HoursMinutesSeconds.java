public class HoursMinutesSeconds {
    public static void main(String[] args) {
      int TotalSeconds = 5420, hours, mins, secs;
      mins = TotalSeconds / 60;
      secs = TotalSeconds % 60;
      hours = mins / 60;
      mins = mins % 60;
      System.out.println(TotalSeconds+ "s is equal to "+hours+"h "+mins+"m "+secs+"s.");
  }
}
