public class FinalGradeCalculator {
  public static int finalGrade(int examGrade, int numOfProjects) {
    if ((examGrade > 90) || (numOfProjects > 10)) {
      return 100;
    } else if ((examGrade > 75) && (numOfProjects >= 5)) {
      return 90;
    } else if ((examGrade > 50) && (numOfProjects >= 2)) {
      return 75;
    }
    
    return 0;
  }
  
  public static void printGradeResult(int examGrade, int numOfProjects) {
    System.out.println(
      String.format(
        "%d, %d ---> %d",
        examGrade, numOfProjects, finalGrade(examGrade, numOfProjects)
      ));
  }
  
  public static void main(String[] args) {
    printGradeResult(100, 12);
    printGradeResult(99, 0);
    printGradeResult(10, 15);
    
    System.out.println();
    
    printGradeResult(85, 5);
    
    System.out.println();
    
    printGradeResult(55, 3);
    
    System.out.println();
    
    printGradeResult(55, 0);
    printGradeResult(20, 2);
  }
}