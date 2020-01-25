package common_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @author Suleyman Yildirim
 */
public class SupplierInterface {
    public static void main(String[] args) {

        //create a Supplier to assign to an intermediate variable s
        Supplier<String> s = () -> "Produce string";
        String d = s.get();
        System.out.println(d);

        Supplier<List<Integer>> intListSupplier = ArrayList<Integer>::new;
        System.out.println(intListSupplier);
        System.out.println(intListSupplier.get());

        List<String> supplements = Arrays.asList("bcaa", "creatin", "fish oil", "vitamin C");
        supplements.stream().forEach(supplement -> {
            printSupplements(() -> supplement);
        });

    }

    private static void printSupplements(Supplier<String> supplier) {
        System.out.println(supplier.get());
    }

}
