package academy.kovalevskyi.algorithms.week0.day0;

import java.util.Arrays;
import java.util.Comparator;

public interface Sort {
  default <T extends Comparable<? super T>> void sort(final T[] target) {
    sort(target, T::compareTo);
  }

  default <T> void sort(final T[] target, final Comparator<T> comparator) {
    boolean indicatorLoop = true;
    for (int i = 0; indicatorLoop; i++) {
      indicatorLoop = false;
      for (int j = 0; j < target.length - 1 - i; j++) {
        if (comparator.compare(target[j], target[j + 1]) > 0) {
          T temp = target[j];
          target[j] = target[j + 1];
          target[j + 1] = temp;
          indicatorLoop = true;
        }
      }
    }
  }

  default <T> T[] createSortedArray(final T[] target, final Comparator<T> comparator) {
    T[] array = Arrays.copyOf(target, target.length);
    sort(array, comparator);
    return array;
  }

  default Integer[] generateIntegerArray(int size) {
    Integer[] array = new Integer[size];
    for (int i = 0; i < size; i++) {
      array[i] = (int) (Math.random() * 20);
    }
    return array;
  }

  default String complexityBest() {
    return "N";
  }

  default String complexityAverage() {
    return "N^2";
  }

  default String complexityWorst() {
    return "N^2";
  }

  default String spaceComplexityWorst() {
    return "N";
  }
}
