public class MyMethods {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static double calculateArea(double radius) {
    return Math.PI + radius*radius;
  }
  
  public static int triple(int num) {
    return num*num*num;
  }
  
  public static boolean isEven(int num) {
    return (num % 2) == 0;
  }
  
  public static void greet(String name) {
    println(String.format("Hello, %s!", name));
  }
  
  public static double average(double num1, double num2, double num3) {
    return (num1 + num2 + num3) / 3d;
  }
  
  public static void main(String[] args) {
    println(triple(7));
    println(isEven(12));
    greet("AP Student");

    println(average(5d, 10d, 15d));
  }
}
