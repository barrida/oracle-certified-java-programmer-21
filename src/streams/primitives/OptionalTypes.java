package streams.primitives;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.DoubleSupplier;
import java.util.stream.IntStream;

/**
 * @author Suleyman Yildirim
 */
public class OptionalTypes {
    public static void main(String[] args) {
        IntStream stream = IntStream.rangeClosed(1, 10);
        OptionalDouble optional = stream.average();
        double doubleValue = optional.getAsDouble();
        System.out.println(doubleValue);
        optional.ifPresent(System.out::println);
        optional.orElseGet(() -> Double.NaN);

        IntStream stream2 = IntStream.of(10, 32, 13, 44);
        OptionalInt optionalInt = stream2.max();
        System.out.println(optionalInt.orElseGet(() -> 0));

        optionalInt.ifPresent(System.out::println);

        //statistics
        IntStream stream3 = IntStream.of(10, 32, 13, 44);
        IntSummaryStatistics stats = stream3.summaryStatistics();
        System.out.println(stats);
    }
}
