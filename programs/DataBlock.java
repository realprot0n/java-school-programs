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
  
  // make a "copy" of the original 
  public DataBlock(DataBlock<T> original) {
    // copying the arraylist cause it also is a reference type too :pensive:
    this(new ArrayList<T>(original.values));
    this.next = original.next;
  }
  
  public void setValues(ArrayList<T> values) {
    this.values = values;
  }
  
  public ArrayList<T> getValues() {
    return this.values;
  }
  
  public DataBlock<T> getNext() {
    return this.next;
  }
  
  // makes a copy of next if next is equal to this
  public void setNext(DataBlock<T> next) {
    if (this == next) {
      this.next = new DataBlock<T>(next);
      return;
    }
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
  
  public void append(T[] newArray) {
    getLast().setNext(
      new DataBlock<T>(newArray)
    );
  }
  
  @Override
  public String toString() {
    return toString(true);
  }
  
  public String toString(boolean addIndexes) {
    StringBuilder retString = new StringBuilder();
    
    int index = 0;
    DataBlock<T> current = this;
    while (current != null) {
      if (addIndexes) {
        retString.append(String.format(
          "%d: ",
          index));
        index++;
      }
      
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
    System.out.println(numbers + "\n");
    
    // random numbers !
    final int numbOfRandomNumbers = 20;
    Integer[] randomNumbArr = new Integer[numbOfRandomNumbers];
    for (int index = 0; index < numbOfRandomNumbers; index++) {
      randomNumbArr[index] = randomInt(0, 20);
    }
    
    numbers.append(new DataBlock<Integer>(
      randomNumbArr
    ));
    System.out.println(numbers + "\n");
    
    // meme numberseth
    Integer[] stupidNumbers = new Integer[] {
      15,     // number 15, burger king foot lettuce.
      21,     // 9 + 10
      24,     // not as funny as..
      25,     // funniest number in existance (according to 🧽)
      41,     // that one song on tiktok
      64,     // stack of something
      67,     // 🥭 phonk 67 67
      69,     // nice
      420,    // weeeeeeeee
      666,    // scary number
      1738,   // that one song that starts with 1738
      1983,   // WAS THAT THE BITE OF 83 ??
      1984,   // literally the UK rn
      1987,   // WAS THAT THE BITE OF 87 ??
      2763,   // miles to goiky? oh my goodness gracious
      8008,   // boo
      9001,   // over nine thousand !!
      58008,  // boos
      5318008 // bababooie
    };
    
    numbers.append(stupidNumbers);
    
    System.out.println(numbers + "\n");
  }
}
