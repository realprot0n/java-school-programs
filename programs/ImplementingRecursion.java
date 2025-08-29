import java.math.BigInteger;

public class ImplementingRecursion {
  public static void println(Object obj) {
    System.out.println(obj);
  }

  public static void print(Object obj) {
    System.out.print(obj);
  }

  public static boolean isPrime(int num) {
    double sqrtOfNum =  Math.ceil(Math.sqrt(num));

    if (Math.abs(num) <= 2) {
      return true;
    }

    for (int currNumb = 2; currNumb <= sqrtOfNum; currNumb++) {
      if (num % currNumb == 0) {
        return false;
      }
    }

    return true;
  }

  public static int recursiveFibonacci(int num) {
    if (num <= 2) {
      return 1;
    }

    return recursiveFibonacci(num-1) + recursiveFibonacci(num-2);
  }

  public static BigInteger forLoopFibonacci(int num) {
    if (num <= 2) {
      return BigInteger.ONE;
    }
    BigInteger a, b, c;
    a = new BigInteger("0");
    b = new BigInteger("1");
    for (int index = 0; index < num; index++) {
      c = b;
      b = a.add(b);
      a = c;
    }
    return a;
  }

  public static void main(String[] args) {
    BigInteger a, b, c;
    a = BigInteger.ZERO;
    b = BigInteger.ONE;

    for (int i = 0; i<100000; i++) {
      c = b;
      b = a.add(b);
      a = c;
      
      if (!isPrime(i)) {
        continue;
      }

      println(i);
      //println(": ");
      //println(a);
    }
  }
}
