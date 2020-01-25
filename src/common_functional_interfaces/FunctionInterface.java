package common_functional_interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Suleyman Yildirim
 */
public class FunctionInterface {
    public static void main(String[] args) {

        Function<String, Integer> f = Integer::parseInt;
        System.out.println(f.apply("2"));

        Function<String, Integer> f2 = (x) -> Integer.parseInt(x);
        System.out.println(f2.apply("2"));

        Function<String, Integer> f3 = String::length;
        System.out.println(f2.apply("my string"));

        BiFunction<String, CharSequence, Boolean> contains = String::contains;
        BiFunction<String, CharSequence, Boolean> contains2 = (string, charSequence) -> string.contains(charSequence);

        System.out.println(contains.apply("Suleyman", "man"));
        System.out.println(contains2.apply("Suleyman", "man"));

    }
}
