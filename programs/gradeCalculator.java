import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class gradeCalculator {
  public int minutes;
  public int hours;

  public static double averageList(List<Integer> grades) {
    int sum = 0;
    for (Integer grade : grades) {
      sum += grade;
    }

    return ((double) sum)/grades.size();
  }
  
  public static double getHomeworkAverage() {
    List<Integer> homeworkGrades = new ArrayList<Integer>(); // Why wont it take just an int??? thats so stupid
    int numOfHomeworkGrades = Input.askForInt("How many homework grades do you have?\n");

    Output.println("Please enter each homework grade.");
    for (int gradeIndex = 0; gradeIndex < numOfHomeworkGrades; gradeIndex++) {
      homeworkGrades.add(Input.askForInt(String.format("%d: ", gradeIndex)));
    }

    return averageList(homeworkGrades);
  }

  public static double getQuizAverage() {
    List<Double> homeworkGrades = new ArrayList<Double>();
    int numOfQuizGrades = Input.askForInt("How many quiz grades do you have?\n");

    Output.println("Please enter each quiz grade.");
    for (int gradeIndex = 0; gradeIndex < numOfHomeworkGrades; gradeIndex++) {
      homeworkGrades.add(Input.askForInt(String.format("%d: ", gradeIndex)));
    }
  }

  public static void main(String[] args) {
    String courseName = Input.askForString("Please enter the course name.\n");
    double homeworkAverage = getHomeworkAverage();


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

class Input {
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
    int userInput = scanner.nextInt();
    scanner.nextLine();
    return userInput;
  }

  public static double askForDouble(String stem) {
    if (scanner == null) {
    return -1;
    }
    Output.print(stem);
    double userInput = scanner.nextDouble();
    scanner.nextLine();
    return userInput;
  }
  
  public static String askForString(String stem) {
    if (scanner == null) {
    return null;
    }
    
    Output.print(stem);
    return scanner.nextLine();
  }
}