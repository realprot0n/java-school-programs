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

  public void printState() {
    System.out.println(String.format(
      "This is a car from %d, and it's make is %s.\n",
      year, make
    ));
  }

  public static void main(String[] args) {
    Car car1 = new Car("Hummer", 2001);
    car1.printState();
    Car car2 = car2;
    
    car2.printState();
    car2.changeMake("Clown Car");
    car1.printState();
  }
}