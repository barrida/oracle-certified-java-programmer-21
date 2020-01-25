package streams.chaining;

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
}
