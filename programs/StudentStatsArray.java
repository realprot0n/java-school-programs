class Student {
  public static final double MIN_GPA = 0;
  public static final double MAX_GPA = 4;
  
  public static final int FRESHMAN = 1;
  public static final int SOPHOMORE = 2;
  public static final int JUNIOR = 3;
  public static final int SENIOR = 4;
  
  private String name;
  private double gpa;
  private int year;
  
  public Student(String name, double gpa, int year) {
    this.name = name;
    this.gpa = gpa;
    this.year = year;
  }
  
  public String getName() {
    return this.name;
  }
  
  public double getGPA() {
    return this.gpa;
  }
  
  public double getYear() {
    return this.year;
  }
  
  @Override
  public String toString() {
    return String.format(
      "{\n    name: %s,\n    gpa: %s,\n    year: %s\n}",
      this.name, this.gpa, this.year
    );
  }
}

public class StudentStatsArray {
  private Student[] students;
  
  public StudentStatsArray(Student[] students) {
    this.students = students;
  }
  
  public double averageGPA() {
    double sum = 0;
    for (Student student : students) {
      sum += student.getGPA();
    }
    return sum/students.length;
  }
  
  public double getGPARange() {
    double minGPA = Student.MAX_GPA;
    double maxGPA = Student.MIN_GPA;
    
    for (Student student : students) {
      if (minGPA > student.getGPA()) {
        minGPA = student.getGPA();
      }
      
      if (maxGPA < student.getGPA()) {
        maxGPA = student.getGPA();
      }
    }
    
    return maxGPA - minGPA;
  }
  
  public String getLongestName() {
    String longest = "";
    
    for (Student student : students) {
      if (student.getName().length() > longest.length()) {
        longest = student.getName();
      }
    }
    return longest;
  }
  
  public int getNumFreshman() {
    int count = 0;
    
    for (Student student : students) {
      if (student.getYear() == Student.FRESHMAN) {
        count++;
      }
    }
    
    return count;
  }
  
  public int search(String name) {
    for (int studentIndex = 0; studentIndex < students.length; studentIndex++) {
      if (students[studentIndex].getName() == name) {
        return studentIndex;
      }
    }
    return -1;
  } 
  
  private boolean sortedAscending() {
    for (int index = 1; index < students.length; index++) {
      if (students[index-1].getGPA() > students[index].getGPA()) {
        return false;
      }
    }
    return true;
  }
  
  private boolean sortedDescending() {
    for (int index = 1; index < students.length; index++) {
      if (students[index-1].getGPA() < students[index].getGPA()) {
        return false;
      }
    }
    return true;
  }
  
  private boolean equalGPAs() {
    for (int index = 1; index < students.length; index++) {
      if (students[index-1].getGPA() != students[index].getGPA()) {
        return false;
      }
    }
    return true;
  }
  
  public int sortStatus() {
    if (sortedAscending()) {
      return 1;
    } else if (sortedDescending()) {
      return -1;
    } else if (equalGPAs()) {
      return 1;
    }
      
    return 0;
  }
  
  @Override
  public String toString() {
    // i've seen stringbuilders everywhere so i wanted to try one out
    StringBuilder builder = new StringBuilder();
    builder.append("[\n");
    for (int index = 0; index < students.length; index++) {
      builder.append(students[index].toString());
      if (index != students.length - 1) {
        builder.append(",");
      }
      builder.append("\n");
    }
    builder.append("]");
    return builder.toString();
    // stringbuilders are actually kinda nice...
  }

  public static void main(String[] args) {
    StudentStatsArray arr = new StudentStatsArray(new Student[] {
      new Student("James", 3, 4),
      new Student("John", 1.2, 3),
      new Student("Juan", 3.2, 2),
    });
    
    System.out.println(arr.toString());
  }
}
