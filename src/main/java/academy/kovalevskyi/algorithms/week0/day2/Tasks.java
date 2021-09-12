package academy.kovalevskyi.algorithms.week0.day2;

import java.util.OptionalInt;

public class Tasks {

  public static OptionalInt findIndex(int[] sortedArray, int target) {
    int low = 0;
    int high = sortedArray.length - 1;
    while (low <= high) {
      int middle = low + (high - low) / 2;
      if (target < sortedArray[middle]) {
        high = middle - 1;
      } else if (target > sortedArray[middle]) {
        low = middle + 1;
      } else {
        return OptionalInt.of(middle);
      }
    }
    return OptionalInt.of(-1);
  }
}
