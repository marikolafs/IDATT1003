public class TotalSeconds {
    public static void main (String[] args) {
      double hours = 1, mins = 30, secs = 20, AllSeconds; 
      AllSeconds = hours * 3600 + mins * 60 + secs;
      System.out.println(hours+"h "+mins+"m "+secs+"s is equal to "+AllSeconds+"s.");
  }
}
