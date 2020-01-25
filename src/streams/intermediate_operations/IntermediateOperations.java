package streams.intermediate_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Suleyman Yildirim
 */
public class IntermediateOperations {

    public static void main(String[] args) {

        //map
        Stream<String> str = Stream.of("monkey", "gorilla", "bonobo");
        str.map(String::length).forEach(System.out::print); // 676

        //flatmap
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(one, two);
        animals.flatMap(s -> s.stream()).forEach(System.out::println);

        //sorted
        Stream<String> s = Stream.of("burhan", "altintop");
        s.sorted().forEach(System.out::println);

        //sorted with Comparator
        Stream<String> s2 = Stream.of("burhan", "altintop");
        s2.sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //peek
        Stream<String> peek = Stream.of("asd","asd","geg");
        long count = peek.distinct().peek(System.out::println).count();
//        System.out.println(count);
    }
}
