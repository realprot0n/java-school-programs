import java.util.*;

public class Simon {
  public static int getItemSubArrayIndex(List<List<String>> array, String obj) {
    int objectIndex = -1;
    for (Collection<String> subArray : array) {
      objectIndex++;
      if (subArray.contains(obj)) {
        return objectIndex;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    List<List<String>> groups = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    
    int pairs = Integer.parseInt(scan.nextLine());
    
    for (int pairIndex = 0; pairIndex < pairs; pairIndex++) {
      String line = scan.nextLine();
      String name1 = line.split(" ")[0];
      String name2 = line.split(" ")[1];
      
      int name1Index = -1;
      
      name1Index = getItemSubArrayIndex(groups, name1);
      
      if (name1Index != -1) {
        if (!groups.get(name1Index).contains(name2)) {
          if (getItemSubArrayIndex(groups, name2) != -1) {
            int name2Index = getItemSubArrayIndex(groups, name2);
            groups.get(name1Index)
                  .addAll(groups.get(name2Index));
            groups.remove(name2Index);
          }
          groups.get(name1Index)
                .add(name2);
        }
        continue;
      }
      
      int name2Index = -1;
      
      name2Index = getItemSubArrayIndex(groups, name2);
      
      if (name2Index != -1) {
        if (!groups.get(name2Index).contains(name1)) {
          groups.get(name2Index)
                .add(name1);
        } else if (getItemSubArrayIndex(groups, name1) != -1) {
          name1Index = getItemSubArrayIndex(groups, name1);
          groups.get(name2Index)
                .addAll(groups.get(name1Index));
          groups.remove(name1Index);
        }
        continue;
      }
      
      List<String> groupToAdd = new ArrayList<>();
      groupToAdd.add(name1);
      groupToAdd.add(name2);
      groups.add(groupToAdd);
    }

    System.out.println(groups);
    scan.close();
  }
}