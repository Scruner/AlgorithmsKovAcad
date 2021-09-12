package academy.kovalevskyi.algorithms.week0.day3;

import academy.kovalevskyi.algorithms.week0.day0.Sort;
import java.util.Comparator;

public class HeapSort implements Sort {
  private static int heapSize;

  @Override
  public <T> void sort(T[] target, Comparator<T> comparator) {
    buildHeap(target, comparator);
    while (heapSize > 1) {
      QuickSort.swap(target, 0, heapSize - 1);
      heapSize--;
      heapify(target, 0, comparator);
    }
  }

  private static <T> void buildHeap(T[] array, Comparator<T> comparator) {
    heapSize = array.length;
    for (int i = array.length / 2; i >= 0; i--) {
      heapify(array, i, comparator);
    }
  }

  private static <T> void heapify(T[] arr, int i, Comparator<T> comparator) {
    int leftVariable = left(i);
    int rightVariable = right(i);
    int largest = i;
    if (leftVariable < heapSize && comparator.compare(arr[i], arr[leftVariable]) < 0) {
      largest = leftVariable;
    }
    if (rightVariable < heapSize && comparator.compare(arr[largest], arr[rightVariable]) < 0) {
      largest = rightVariable;
    }
    if (i != largest) {
      QuickSort.swap(arr, i, largest);
      heapify(arr, largest, comparator);
    }
  }

  private static int right(int i) {
    return 2 * i + 1;
  }

  private static int left(int i) {
    return 2 * i + 2;
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
    return "N*log(N)";
  }

  @Override
  public String spaceComplexityWorst() {
    return "N";
  }
}
