package generics_and_collections.generic.bounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Suleyman Yildirim
 */
public class Food {

    /**
     * This method that works on lists of Integer and the supertypes of Integer, such as Integer, Number, and Object
     * <p>
     * A lower bounded wildcard is expressed using List< ? super Integer>
     *
     * @param list
     */
    private static void lowerBound(List<? super Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
        }
        System.out.println(list);
    }

    /**
     * This method works on lists of Number and the subtypes of Number, such as Integer, Double, and Float
     * <p>
     * An upper bounded wildcard is specified using List< ? extends Integer>
     *
     * @param list
     */
    private static double upperBound(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    /**
     * The unbounded wildcard type is specified using the wildcard character (?), for example, List< ?>. This is called a list of unknown type
     * <p>
     * The goal of the function is to print a list of any type
     *
     * @param list
     */
    private static void unboud(List<?> list) {
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<Integer> intList = Arrays.<Integer>asList(1, 2, 3);
        System.out.println(upperBound(intList));

        List<Double> doubleList = Arrays.<Double>asList(4.3, 7.1, 2.4);
        System.out.println(upperBound(doubleList));

        lowerBound(intList);
        //lowerBound(doubleList); // compile error

        unboud(intList);
        unboud(doubleList);
    }
}