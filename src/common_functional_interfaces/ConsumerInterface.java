package common_functional_interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Suleyman Yildirim
 */
public class ConsumerInterface {
    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Consume string");
        c2.accept("Consume string");

        BiConsumer<String, String> b1 = (x, y) -> System.out.println(x + y);
        b1.accept("1", "2");
    }
}
