package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {
final Predicate<Car> carF = car->car.getPrice() < 10000;
  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> filterCars = cars.stream()
                                .filter(carF)
                                .collect(Collectors.toList());
   filterCars.forEach(System.out::println);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    Function<Person, PersonDTO> transformFunction = person -> new PersonDTO(person.getId(), person.getFirstName(), person.getAge());

    List<PersonDTO> dtos = people.stream()
            .map(transformFunction)
            //.map(PersonDTO::map)
           // .map(person -> {
              //PersonDTO dto = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
             // return dto;
            //})
            .collect(Collectors.toList());
    dtos.forEach(System.out::println);


  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> list = MockData.getCars();
   double precio= list.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);

    System.out.println("precio = " + precio);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



