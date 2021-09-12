package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class QuickSort implements Sort {

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    int minEl = 0;
    int maxEl = target.length - 1;
    quickSort(target, minEl, maxEl, comparator);
  }

  private static <T> void quickSort(T[] array, int from, int to, Comparator<T> comparator) {
    if (from >= to) {
      return;
    }
    int pivotIndex = partition(array, from, to, comparator);
    quickSort(array, from, pivotIndex - 1, comparator);
    quickSort(array, pivotIndex, to, comparator);
  }

  private static <T> int partition(T[] arr, int from, int to, Comparator<T> comparator) {
    T supportEl = arr[from];
    int rightIndex = to;
    int leftIndex = from;

    while (leftIndex <= rightIndex) {
      while (comparator.compare(arr[leftIndex], supportEl) < 0) {
        leftIndex++;
      }
      while (comparator.compare(arr[rightIndex], supportEl) > 0) {
        rightIndex--;
      }
      if (leftIndex <= rightIndex) {
        swap(arr, rightIndex, leftIndex);
        leftIndex++;
        rightIndex--;
      }
    }
    return leftIndex;
  }

  public static <T> void swap(T[] array, int index1, int index2) {
    T tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
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
    return "N^2";
  }
}
