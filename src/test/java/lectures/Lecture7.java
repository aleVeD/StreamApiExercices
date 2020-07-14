package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    long co = MockData.getPeople()
            .stream()
            .filter(person -> person.getGender().equalsIgnoreCase("female"))
            .count();
    System.out.println("co = " + co);
  }

  @Test
  public void min() throws Exception {
    double min = MockData.getCars()
                      .stream()
                      .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
                      .mapToDouble(Car::getPrice)
                      .min()
                      .getAsDouble();
    System.out.println("min = " + min);
  }

  @Test
  public void max() throws Exception {
    double max = MockData.getCars()
                          .stream()
                          .filter(car -> car.getColor().equalsIgnoreCase("red"))
                          .mapToDouble(Car::getPrice)
                          .max()
                          .getAsDouble();
    System.out.println("max = " + max);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double price = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println("cars = " + price);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println("average "+statistics.getAverage());
    System.out.println("count "+statistics.getCount());
    System.out.println("max " +statistics.getMax());
    System.out.println("min "+statistics.getMin());
    System.out.println("sum " +BigDecimal.valueOf(statistics.getSum()));
  }

}