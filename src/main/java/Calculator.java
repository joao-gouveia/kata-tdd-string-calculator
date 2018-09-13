import java.util.Arrays;
import java.util.List;

/**
 * Calculator
 */
public class Calculator {

  static final String DEFAULT_DELIMITER = ",";
  static final String INITIAL_CUSTOM_DELIMITER = "//";

  public int add(String numbers) {
    if(numbers.isEmpty()) return 0;

    String delimiter = DEFAULT_DELIMITER;

    if(numbers.startsWith(INITIAL_CUSTOM_DELIMITER)) {
      int index = numbers.indexOf("\n");
      delimiter = numbers.substring(2, index);
      numbers = numbers.substring(index + 1, numbers.length());
    }

    numbers = numbers.replace("\n", delimiter);
    int[] numbersParsed = Arrays.asList(numbers.split(delimiter))
                                .stream()
                                .mapToInt(Integer::parseInt)
                                .toArray();

    int result = 0;
    for(int number : numbersParsed) {
      result += number;
    }
    
    return result;
  }
}