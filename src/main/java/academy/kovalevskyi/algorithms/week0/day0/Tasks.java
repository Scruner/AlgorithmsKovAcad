package academy.kovalevskyi.algorithms.week0.day0;

public class Tasks {

  public static boolean sameCharactersSorting(String left, String right) {
    Sort sortVariable = new Sort() {};
    Character[] arraysLeftString = left.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    Character[] arraysRightString = right.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    sortVariable.sort(arraysLeftString);
    sortVariable.sort(arraysRightString);
    if (arraysLeftString.length != arraysRightString.length) {
      return false;
    }
    for (int i = 0; i < arraysLeftString.length; i++) {
      if (arraysLeftString[i] != arraysRightString[i]) {
        return false;
      }
    }
    return true;
  }

  public static boolean sameCharactersO1(String left, String right) {
    if (left.length() != right.length()) {
      return false;
    }
    int[] arrayOnLeftString = new int[255];
    for (int i = 0; i < left.length(); i++) {
      arrayOnLeftString[left.charAt(i)]++;
    }
    for (int i = 0; i < right.length(); i++) {
      arrayOnLeftString[right.charAt(i)]--;
      if (arrayOnLeftString[right.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }
}
