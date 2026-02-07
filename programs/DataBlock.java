import java.util.ArrayList;

public class DataBlock<T> {
  private ArrayList<T> values;
  private DataBlock<T> next;
  
  public DataBlock(ArrayList<T> values) {
    this.setValues(values);
  }
  
  public DataBlock(T[] values) {
    this.setValues(makeArrayList(values));
  }
  
  public void setValues(ArrayList<T> values) {
    this.values = values;
  }
  
  public ArrayList<T> getValues() {
    return values;
  }
  
  public DataBlock<T> getNext() {
    return this.next;
  }
  
  public void setNext(DataBlock<T> next) {
    this.next = next;
  }
  
  public DataBlock<T> getLast() {
    DataBlock<T> current = this;
    
    while (current.getNext() != null) {
      current = current.getNext();
    }
    
    return current;
  }

  public void append(DataBlock<T> newDataBlock) {
    getLast().setNext(newDataBlock);
  }
  
  @Override
  public String toString() {
    StringBuilder retString = new StringBuilder();
    
    DataBlock<T> current = this;
    while (current != null) {
      retString.append(current.getValues());
      current = current.getNext();
      
      if (current != null) {
        retString.append(" =>\n");
      }
    }
    
    return retString.toString();
  }
  
  private static <T> ArrayList<T> makeArrayList(T[] values) {
    ArrayList<T> arrayList = new ArrayList<T>();
    for (T value : values) {
      arrayList.add(value);
    }
    return arrayList;
  }
  
  // both lower and higher are INCLUSIVE !!
  private static int randomInt(int lower, int higher) {
    higher++;
    return (int) (lower + Math.random() * (higher-lower));
  }
  
  public static void main(String[] args) {
    
    // important numbers !
    DataBlock<Integer> numbers = new DataBlock<Integer>(
      new Integer[]{-1, 0, 1, 7, 13, 25, 1738, 2763}
    );

    // pi !
    DataBlock<Integer> pi = new DataBlock<>(
      new Integer[]{
        3, 1, 4, 1, 5, 9, 2, 6, 5, 3,
        5, 8, 9, 7, 9, 3, 2, 3, 8, 4,
      }
    );

    numbers.setNext(pi);
    System.out.println(numbers);
    
    // random numbers !
    final int numbOfRandomNumbers = 20;
    Integer[] randomNumbArr = new Integer[numbOfRandomNumbers];
    for (int index = 0; index < numbOfRandomNumbers; index++) {
      randomNumbArr[index] = randomInt(0, 20);
    }
    
    numbers.append(new DataBlock<Integer>(
      randomNumbArr
    ));
    System.out.println(numbers);
    
  }
}
