import java.util.Scanner;

public class AirTrafficController {
  public static void main(String[] args) {
    Airplane planeOne = new Airplane();
    Airplane planeTwo = new Airplane("AAA02", 15.8d, 30_000d, new Degrees(128d));
    Airplane planeThree = Airplane.getAirplaneFromUser();

    TheOutput.println("Initial Positions:");
    TheOutput.println(planeOne.toString());
    TheOutput.println(planeTwo.toString());
    TheOutput.println(planeThree.toString());
    TheOutput.println("");
    
    TheOutput.println("Initial Distances:");
    planeOne.printDistance(planeTwo);
    planeOne.printDistance(planeThree);
    planeTwo.printDistance(planeThree);
    TheOutput.println("");

    TheOutput.println("Initial Height Differences");
    planeOne.printHeightDifference(planeTwo);
    planeOne.printHeightDifference(planeThree);
    planeTwo.printHeightDifference(planeThree);
    TheOutput.println("");


    planeOne.move(planeTwo.getDist(planeThree), new Degrees(65));
    planeTwo.move(8.0, new Degrees(135));
    planeThree.move(5.0, new Degrees(55));

    planeOne.gainAlt(3);
    planeTwo.loseAlt(2);
    planeThree.loseAlt(4);

    TheOutput.println("New Positions:");
    TheOutput.println(planeOne.toString());
    TheOutput.println(planeTwo.toString());
    TheOutput.println(planeThree.toString());
    TheOutput.println("");
    
    TheOutput.println("New Distances:");
    planeOne.printDistance(planeTwo);
    planeOne.printDistance(planeThree);
    planeTwo.printDistance(planeThree);
    TheOutput.println("");

    TheOutput.println("New Height Differences");
    planeOne.printHeightDifference(planeTwo);
    planeOne.printHeightDifference(planeThree);
    planeTwo.printHeightDifference(planeThree);
    TheOutput.println("");
  }
}

class TheOutput {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static void print(Object obj) {
    System.out.print(obj);
  }
  
  public static void printf(String template, Object... args) {
    println(String.format(template, args));
  }
}

class Degrees {
  double degrees;
  
  public Degrees(double degrees) {
    setDegrees(degrees);
  }
  
  public void setDegrees(double degrees) {
    this.degrees = degrees % 360;
  }

  public void addDegrees(double degrees) {
    this.degrees = (this.degrees + degrees) % 360;
  }

  public void addDegrees(Degrees otherDegrees) {
    addDegrees(otherDegrees.degrees);
  }

  public double getDegrees() {
    return degrees;
  }
}

class Airplane {
  
  String callSign;
  double distance;
  double altitude;
  Degrees direction;
  
  public Airplane() {
    callSign = "AAA01";
    distance = 1d;
    altitude = 0;
    direction = new Degrees(0);
  }
  
  public Airplane(String callSign, double distance,
                  double altitude, Degrees direction) {
    this.callSign = callSign;
    this.distance = distance;
    this.altitude = altitude;
    this.direction = direction;
  }
  
  public static Airplane getAirplaneFromUser() {
    Scanner scanner = new Scanner(System.in);
    
    TheOutput.println("Enter the details of the third airplane (call-sign, distance, altitude, bearing):");
    Airplane returnAirplane = new Airplane(
                    scanner.nextLine().toUpperCase(),
                    Double.parseDouble(scanner.nextLine()),
                    Double.parseDouble(scanner.nextLine()),
                    new Degrees(Double.parseDouble(scanner.nextLine()))
                    );
    
    scanner.close();
    return returnAirplane;
  }

  public void move(double distance, Degrees direction) {
    this.distance += distance;
    this.direction.addDegrees(direction);
  }
  
  public void gainAlt() {
    altitude += 1000;
  }

  public void gainAlt(int times) {
    for (int index = 0; index < times; index++) {
      gainAlt();
    }
  }
  
  public void loseAlt() {
    altitude -= 1000;
  }

  public void loseAlt(int times) {
    for (int index = 0; index < times; index++) {
      loseAlt();
    }
  }
  
  public double getAlt() {
    return altitude;
  }
  
  @Override
  public String toString() {
    return String.format("%s - %f miles away at bearing %f°, altitude %f feet",
    callSign, distance, direction.degrees, altitude);
  }
  
  public double getDist(Airplane otherPlane) {
    // i kinda have like no idea how to make it like the test run
    // i tried to use pythagorean with the distance and altitude but it still came up short
    // ts pmo icl 😭
    return Math.abs(distance - otherPlane.distance);
  }
  
  public double getAltDifference(Airplane otherPlane) {
    return Math.abs(altitude - otherPlane.altitude);
  }
  
  public void printDistance(Airplane otherPlane) {
    TheOutput.printf("The distance between Airplane %s and Airplane %s is %.2f miles.",
                callSign, otherPlane.callSign, getDist(otherPlane));
  }

  public void printHeightDifference(Airplane otherPlane) {
    TheOutput.printf("The difference in height between Airplane %s and Airplane %s is %.0f feet.",
                  callSign, otherPlane.callSign, getAltDifference(otherPlane));
  }
}