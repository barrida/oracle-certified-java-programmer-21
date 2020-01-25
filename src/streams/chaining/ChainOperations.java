package streams.chaining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Suleyman Yildirim
 */
public class ChainOperations {
    public static void main(String[] args) {
//        Stream.of("Suleyman")
//                .filter(n -> n.length() == 4)
//                .sorted()
//                .limit(2)
//                .forEach(System.out::println);

        Stream.generate(() -> "Suleyman")
                .filter(s -> s.contains("a"))
                .limit(4)
                .forEach(System.out::println);
    }

    List<Integer> numbers = Arrays.asList(10, 3, 6, 8, 11);
    List<Integer> filteredNumbers = numbers.stream()
            .filter(number -> number.intValue() > 5)
            .collect(Collectors.toList());

    //System.out.println("Predicate - single filter: "+filteredNumbers);

    List<Integer> multipleFilters = numbers.stream()
            .filter(number -> number.intValue() < 10)
            .filter(number -> number.intValue() % 2 == 0)
            .collect(Collectors.toList());
    //System.out.println("Predicate - multiple filters: "+multipleFilters);
}
