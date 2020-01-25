package common_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * @author Suleyman Yildirim
 */
public class OperatorInterface {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("fistik", "kus", "tomis");
        names.replaceAll(String::toLowerCase);

        UnaryOperator<String> un = String::toLowerCase;
        names.replaceAll(String::toLowerCase);
        System.out.println(un.apply("UNARY"));

        BinaryOperator<Integer> operator = (x, y) -> x + y;
        System.out.println(operator.apply(5, 10));
    }
}
