package academy.kovalevskyi.algorithms.week1.day0;

import java.util.function.Function;

public class OptimaFinder {

  public static double findOptima(
      Function<Double, Double> f, double start, double end, double precision) {
    double prev = 0;
    double current = 0;
    double next = 0;
    double low = start;
    double high = end;
    double middle = 0;
    while (low <= high) {
      middle = low + (high - low) / 2;
      current = f.apply(middle);
      prev = f.apply(middle - precision);
      next = f.apply(middle + precision);
      if (current < prev && current < next) {
        return middle;
      }
      if (current < prev) {
        low = middle + precision;
      } else if (current > prev) {
        high = middle - precision;
      }
    }
    return middle;
  }
}
