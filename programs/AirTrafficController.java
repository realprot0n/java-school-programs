import java.util.Scanner;

public class AirTrafficController {
  public static void main(String[] args) {
    Airplane planeOne = new Airplane();
    Airplane planeTwo = new Airplane("AAA02", 15.8d, 30_000d, new Degrees(128d));
    Airplane planeThree = Airplane.getAirplaneFromUser();
    
    planeOne.printDistance(planeTwo);
  }
}

class Output {
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
    
    Output.println("Enter the details of the third airplane (call-sign, distance, altitude, bearing):");
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
  
  public void loseAlt() {
    altitude -= 1000;
  }
  
  public double getAlt() {
    return altitude;
  }

  public double getAltInMiles() {
    return altitude/5280d;
  }
  
  @Override
  public String toString() {
    return String.format("%s - %f miles away at bearing %d°, altitude %d feet",
                         callSign, distance, direction.degrees, altitude);
  }
  
  public double getDist(Airplane otherPlane) {
    // i kinda have like no idea how to make it like the test run
    // i tried to use pythagorean with the distance and altitude but it still came up short
    // ts pmo icl 😭
    return Math.abs(distance - otherPlane.distance);
  }
  
  public void printDistance(Airplane otherPlane) {
    Output.printf("The distance between Airplane %s and Airplane %s is %.2f miles.",
                callSign, otherPlane.callSign, getDist(otherPlane));
  }
}