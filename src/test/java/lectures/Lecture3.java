package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer min = numbers.stream()
            .min(Comparator.naturalOrder())
           // .min((number1, number2)-> number1 > number2 ? 1: -1)
            .get();
    System.out.println("min = " + min);
  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer max = numbers.stream()
            .max(Comparator.naturalOrder())
            .get();
    System.out.println("max = " + max);
  }
}
