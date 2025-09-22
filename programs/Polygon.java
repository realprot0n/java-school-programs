public class Polygon {
  int sides;
  public Polygon(int setSides) {
    sides = setSides;

    System.out.println(String.format("Created a polygon with %d sides.", sides));
  }

  public static void main(String[] args) {
    Polygon icosagon = new Polygon(20);
    Polygon square = new Polygon(4);
    Polygon triagle = new Polygon(3);
    Polygon pentagon = new Polygon(10);
  }
}
