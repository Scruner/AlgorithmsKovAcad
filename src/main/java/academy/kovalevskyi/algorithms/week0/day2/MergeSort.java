package academy.kovalevskyi.algorithms.week0.day2;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Arrays;
import java.util.Comparator;

public class MergeSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    T[] currentSrc = target;
    T[] currentDest = target.clone();
    T[] temp;

    int size = 1;
    while (size < target.length) {
      for (int i = 0; i < target.length; i += 2 * size) {
        merge(currentSrc, i, currentSrc, i + size, currentDest, i, size, comparator);
      }
      temp = currentSrc;
      currentSrc = currentDest;
      currentDest = temp;

      size = size * 2;
    }
  }

  @Override
  public <T> T[] createSortedArray(T[] target, Comparator<T> comparator) {
    T[] array = Arrays.copyOf(target, target.length);
    sort(array, comparator);
    return array;
  }

  @Override
  public String complexityBest() {
    return "N*log(N)";
  }

  @Override
  public String complexityAverage() {
    return "N*log(N)";
  }

  @Override
  public String complexityWorst() {
    return "N";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N";
  }

  private static <T> void merge(
      T[] src1,
      int src1Start,
      T[] src2,
      int src2Start,
      T[] dest,
      int destStart,
      int size,
      Comparator<T> comparator) {
    int index1 = src1Start;
    int index2 = src2Start;
    int src1End = Math.min(src1Start + size, src1.length);
    int src2End = Math.min(src2Start + size, src2.length);
    if (src1Start + size > src1.length) {
      for (int i = src1Start; i < src1End; i++) {
        dest[i] = src1[i];
      }
      return;
    }
    int iterationCount = src1End - src1Start + src2End - src2Start;
    for (int i = destStart; i < destStart + iterationCount; i++) {
      if (index1 < src1End
          && (index2 >= src2End || comparator.compare(src1[index1], src2[index2]) < 0)) {
        dest[i] = src1[index1];
        index1++;
      } else {
        dest[i] = src2[index2];
        index2++;
      }
    }
  }
}
