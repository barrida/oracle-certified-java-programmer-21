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

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add = (value) -> value + 3;

        //Returns a composed function that first applies the before function to its input, and then applies this function to the result.
        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        //Applies this function to the given argument.
        Integer result1 = addThenMultiply.apply(3);
        System.out.println("Function: (3 + 3) * 2 " + result1);

        //Returns a composed function that first applies this function to its input, and then applies the after function to the result.
        Function<Integer, Integer> multiplyThenAdd = multiply.andThen(add);

        //Applies this function to the given argument.
        Integer result2 = multiplyThenAdd.apply(3);
        System.out.println("Function: 3 * 2 + 3 " + result2);

    }
}
