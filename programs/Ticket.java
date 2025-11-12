public abstract class Ticket {
  private static int currSerialNumber;
  private int serialNumber;
  
  public Ticket() {
    serialNumber = getNextSerialNumber();
  }
  
  public abstract double getPrice();
  
  public String toString() {
    return "Number: " + serialNumber + "\nPrice: " + getPrice();
  }
  
  private static int getNextSerialNumber() {
    currSerialNumber++;
    return currSerialNumber - 1;
  }
  
  public static void main(String[] args) {
    StudentAdvance ticket = new StudentAdvance(10);
    
    System.out.println(ticket.toString());
  }
}

class Advance extends Ticket {
  private double price;
  
  public Advance(int daysInAdvance) {
    super();
    
    final int discountDayRequirement = 10;
    if (daysInAdvance >= discountDayRequirement) {
      price = 30.00;
    } else {
      price = 40.00;
    }
  }
  
  public double getPrice() {
    return price;
  }
}

class StudentAdvance extends Advance {
  public StudentAdvance(int daysInAdvance) {
    super(daysInAdvance);
  }
  
  @Override
  public double getPrice() {
    return super.getPrice() / 2.0;
  }
  
  @Override
  public String toString() {
    return super.toString() + "\n(student ID required)";
  }
}