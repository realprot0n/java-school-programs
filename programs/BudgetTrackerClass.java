class BudgetTracker {
  public int items;
  public double totalCost;

  public BudgetTracker() {
    items = 0;
    totalCost = 0;
  }

  public void addPurchase(int quantity, double price) {
    items += quantity;
    totalCost += price * quantity;
  }

  public double averageCostPerItem() {
    if (items == 0) {
      return 0.0;
    }

    return totalCost / (double) items;
  }
}

public class BudgetTrackerClass {
  public static void main(String[] args) {

    // Code
    BudgetTracker b = new BudgetTracker();
    b.addPurchase(3, 0.50);   // 3 apples, $0.50 each
    b.addPurchase(2, 0.75);   // 2 bananas, $0.75 each
    System.out.println(b.averageCostPerItem());
  }
}
