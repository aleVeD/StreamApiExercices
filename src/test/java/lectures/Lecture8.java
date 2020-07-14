package lectures;


import beans.Car;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    List<Car> cars = MockData.getCars();
    Map<String, List<Car>> group = cars.stream()
                                       .collect(Collectors.groupingBy(Car::getMake));
    group.forEach((make, car)->{
      System.out.println(make);
      car.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );
    Map<String, Long> counts = names.stream()
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    counts.forEach((name, count)-> System.out.println(name+" - "+count));

  }

  @Test
  public void groupAndCountString(){
    String name = "roma";
    String[] na = name.split("");
    String n = Arrays.stream(na).reduce( (a, b)-> b +a).get();
    System.out.println("n = " + n);
    Map<String, Long> map = Arrays.stream(na)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    map.forEach((letter, count)-> System.out.println(letter+" - "+ count));
  }

}