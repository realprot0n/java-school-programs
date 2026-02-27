import java.util.Scanner;

class MissionToMars {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int inputs = scan.nextInt();
    scan.nextLine();

    for (int inputNum = 0; inputNum < inputs; inputNum++) {
      double miles = scan.nextDouble()*1_000_000;
      double speedMPH = scan.nextDouble();
      
      double hours = miles/speedMPH;
      int days = (int) (hours/24);
      double minutes = (hours*60)%60;
      int seconds = (int) Math.round(minutes*60)%60;
      hours = hours%24;
      
      System.out.println(String.format(
        "Time to Mars: %s days, %s hours, %s minutes, %s seconds",
        days,
        Math.round(Math.floor(hours)), 
        (int) minutes,
        seconds
      ));
    }
  }
}
