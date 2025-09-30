public class StringAssignmentTwo {
  private static void println(Object obj) {
    System.out.println(obj);
  }

  private static void printf(String template, Object... args) {
    for (Object arg : args) {
      template = String.format(template, arg);
    }
    println(template);
  }

  public static void main(String[] args) {
    String helloWorld = "HelloWorld";
    printf("Original: %s", helloWorld);
    
    String hello = helloWorld.substring(0, 5);
    String world = helloWorld.substring(5);

    printf("First part: %s", hello);
    printf("Second part: %s", world);

    String newHelloWorld = hello + " " + world;

    printf("New string: %s", newHelloWorld);
  }
}
