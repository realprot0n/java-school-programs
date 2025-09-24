public class Car {
  private String make;
  private int year;

  public Car(String setMake, int setYear) {
    make = setMake;
    year = setYear;
  }
  
  public void changeMake(String newMake) {
    make = newMake;
  }
  
  public void changeYear(int newYear) {
    year = newYear;
  }

  public void printState() {
    println(String.format(
      "This is a car from %d, and it's make is %s.\n",
      year, make
    ));
  }
  
  private static void println(Object obj) {
      System.out.println(obj);
  }

  public static void main(String[] args) {
    Car car1 = new Car("Hummer", 2001);
    println("Car 1 before:");
    car1.printState();
    
    Car carCopy = car1;
    println("Car copy before:");
    carCopy.printState();
    
    carCopy.changeYear(1967);
    println("Car 1 after:");
    car1.printState();
    println("Car copy after:");
    carCopy.printState();
  }
}
