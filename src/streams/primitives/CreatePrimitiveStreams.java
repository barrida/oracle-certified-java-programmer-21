package streams.primitives;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author Suleyman Yildirim
 */
public class CreatePrimitiveStreams {
    public static void main(String[] args) {

        //IntStream
        Stream<String> stream1 = Stream.of("suleyman", "yildirim");
        IntStream intStream = stream1.mapToInt(s -> s.length());
        intStream.forEach(System.out::println);

        Stream<String> stream2 = Stream.of("suleyman", "yildirim");
        DoubleStream doubleStream = stream2.mapToDouble(s -> s.length());
        doubleStream.forEach(System.out::println);

        Stream<String> stream3 = Stream.of("suleyman", "yildirim");
        LongStream longStream = stream3.mapToLong(s -> s.length());
        longStream.forEach(System.out::println);

    }
}
