package generics_and_collections.generic.collections.framework.set;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Suleyman Yildirim
 */
public class SetMethods {
    public static void main(String args[]) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Suleyman");
        hashSet.add("Canan");
        hashSet.add("Fatma");
        hashSet.add("Omur");
        hashSet.add("Fatma");

        System.out.print("HashSet values: ");
        for (String value : hashSet) {
            System.out.print(value + " ");
        }

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Suleyman");
        treeSet.add("Canan");
        treeSet.add("Fatma");
        treeSet.add("Omur");
        treeSet.add("Fatma");

        System.out.print("\nTreeSet values: ");
        for (String value : treeSet) {
            System.out.print(value + " ");
        }

    }
}
