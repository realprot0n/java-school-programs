import java.util.Scanner;

public class varsAndDataTypes {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }

  public static void printItemPriceLine(String itemName, float itemPrice, int numOfItems) {
    println(String.format("$%.2f: %d %s", itemPrice*numOfItems, numOfItems, itemName));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    float coffeePrice = 2.50f;
    float pastryPrice = 3.00f;

    int numberOfCoffees = 2;
    int numberOfPastries = 1;

    double subtotal = (coffeePrice * numberOfCoffees) + (pastryPrice * numberOfPastries);
    
    double total = subtotal * 1.08f;
    
    println("YOU BOUGHT:");
    printItemPriceLine("Coffees", coffeePrice, numberOfCoffees);
    printItemPriceLine("Pastry", pastryPrice, numberOfPastries);
    println(String.format("Subtotal: %.2f", subtotal));
    println(String.format("Tax:      %.2f", subtotal * 1.08f));
    
    print("hwat do you want to tip? %");

    double tipPercent = scanner.nextDouble();
    scanner.close();
    
    double tipAmount = subtotal * tipPercent/100;
    println(String.format("Tip:      %.2f", tipAmount));

    double finalTotal = total + tipAmount;
    println(String.format("Total:    %.2f", finalTotal));
    
  }
}
