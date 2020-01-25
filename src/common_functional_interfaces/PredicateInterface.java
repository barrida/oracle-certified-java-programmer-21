package common_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Suleyman Yildirim
 */
public class PredicateInterface {
    public static void main(String[] args) {

        Predicate<String> p2 = String::isEmpty;
        System.out.println(p2.test(""));

        Predicate<String> p1 = (str) -> str.contains("s");
        System.out.println(p1.test("Suleyman"));

        BiPredicate<String, String> b1 = String::equalsIgnoreCase;
        System.out.println(b1.test("my string", "my string"));


        BiPredicate<String, String> b2 = (string, anotherString) -> string.equalsIgnoreCase(anotherString);
        System.out.println(b2.test("my string", "your string"));

    }
}
