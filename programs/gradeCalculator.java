import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class gradeCalculator {
  public int minutes;
  public int hours;

  public static double averageListOfInts(List<Integer> grades) {
    int sum = 0;
    for (Integer grade : grades) {
      sum += grade;
    }

    return ((double) sum)/grades.size();
  }
  
  public static double averageListOfDoubles(List<Double> grades) {
    int sum = 0;
    for (Double grade : grades) {
      sum += grade;
    }

    return ((double) sum)/grades.size();
  }

  public static int[] getMinutesAndHours() {
    int minutes = MyInput.askForInt("Please enter the average time spent in a week for this course in minutes.\n");

    return new int[] {minutes%60, minutes/60};
  }
  
  public static double getHomeworkAverage() {
    List<Integer> homeworkGrades = new ArrayList<Integer>(); // Why wont it take just an int??? thats so stupid
    int numOfHomeworkGrades = MyInput.askForInt("How many homework grades do you have?\n");

    Output.println("Please enter each homework grade.");
    for (int gradeIndex = 0; gradeIndex < numOfHomeworkGrades; gradeIndex++) {
      homeworkGrades.add(MyInput.askForInt(String.format("%d: ", gradeIndex + 1)));
    }

    return averageListOfInts(homeworkGrades);
  }

  public static double getQuizAverage() {
    List<Double> quizGrades = new ArrayList<Double>();
    int numOfQuizGrades = MyInput.askForInt("How many quiz grades do you have?\n");

    Output.println("Please enter each quiz grade.");
    for (int gradeIndex = 0; gradeIndex < numOfQuizGrades; gradeIndex++) {
      quizGrades.add(MyInput.askForDouble(String.format("%d: ", gradeIndex)));
    }

    return averageListOfDoubles(quizGrades);
  }


  public static void displayCourseInfo(String courseName, int[] minutesAndHours, double homeworkAverage, double quizAverage, double finalExamGrade) {
    Output.println(String.format("Course name: %s", courseName));
    Output.println(String.format("Weekly time spent: %dh%dm", minutesAndHours[1], minutesAndHours[0]));
    Output.println(String.format("Average homework grade: %s", homeworkAverage));
    Output.println(String.format("Average quiz grade: %s", quizAverage));
    Output.println(String.format("Final exam grade: %s", finalExamGrade));

    int overallGrade = (int) (((homeworkAverage * .35) + (quizAverage * .15) + (finalExamGrade * .5)) + .5);

    Output.println(String.format("Overall grade: %d", overallGrade));
  }

  public static void main(String[] args) {
    MyInput.initialize();
    
    String courseName = MyInput.askForString("Please enter the course name.\n");
    
    int[] minutesAndHours = getMinutesAndHours();
    double homeworkAverage = getHomeworkAverage();
    
    double quizAverage = getQuizAverage();
    
    double finalExamGrade = MyInput.askForDouble("Please enter the final exam grade for this course.\n");

    displayCourseInfo(courseName, minutesAndHours, homeworkAverage, quizAverage, finalExamGrade);
  }
}

class Output {
  public static void println(Object obj) {
    System.out.println(obj);
  }
  
  public static void println() {
    println("");
  }
  
  public static void print(Object obj) {
    System.out.print(obj);
  }
}

class MyInput {
  public static Scanner scanner;
  private static boolean initialized = false;
  
  public static void initialize() {
    if (initialized) {
    return;
    }
    scanner = new Scanner(System.in);
    initialized = true;
  }
  
  public static int askForInt(String stem) {
    if (scanner == null) {
    return -1;
    }
    Output.print(stem);
    int userMyInput = scanner.nextInt();
    scanner.nextLine();
    return userMyInput;
  }

  public static double askForDouble(String stem) {
    if (scanner == null) {
    return -1;
    }
    Output.print(stem);
    double userMyInput = scanner.nextDouble();
    scanner.nextLine();
    return userMyInput;
  }
  
  public static String askForString(String stem) {
    if (scanner == null) {
    return null;
    }
    
    Output.print(stem);
    return scanner.nextLine();
  }
}