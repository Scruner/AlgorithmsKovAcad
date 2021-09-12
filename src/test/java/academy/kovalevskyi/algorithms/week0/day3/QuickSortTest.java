package academy.kovalevskyi.algorithms.week0.day3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class QuickSortTest {

  @Test
  public void quickSort() {
    QuickSort quickSort = new QuickSort();
    Integer[] array = {3, 4, 45, 2, 8, 20, 43, 1};
    Integer[] expected = {1, 2, 3, 4, 8, 20, 43, 45};
    quickSort.sort(array, Integer::compareTo);
    Assertions.assertArrayEquals(expected, array);
  }

  @Test
  public void quickSortTwoZero() {
    QuickSort quickSort = new QuickSort();
    Integer[] array = {4, -3, 45, -2, 0, 20, 0, 1, 43};
    Integer[] expected = {-3, -2, 0, 0, 1, 4, 20, 43, 45};
    quickSort.sort(array, Integer::compareTo);
    Assertions.assertArrayEquals(expected, array);
  }
}
