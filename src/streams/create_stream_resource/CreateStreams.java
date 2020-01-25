package streams.create_stream_resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Suleyman Yildirim
 */
public class CreateStreams {

    public static void main(String[] args) {

        Stream.empty()
                .forEach(System.out::println);

        Stream.of("finite stream")
                .forEach(System.out::println);

        List<String> list = Arrays.asList("q", "w", "e", "r");
        list.stream().forEach(System.out::println);

        //infinite streams
        Stream.generate(() -> "infinite stream")
                .forEach(System.out::println);

        Stream.iterate(1, x -> x + 2)
                .forEach(System.out::println);

    }
}
