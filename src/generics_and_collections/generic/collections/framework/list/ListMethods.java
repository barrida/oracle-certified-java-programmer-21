package generics_and_collections.generic.collections.framework.list;

import java.util.*;

/**
 * @author Suleyman Yildirim
 */
public class ListMethods {

    public static void main(String args[]) {

        ///ArrayList
        List<String> list = new ArrayList<>();
        list.add("suleyman");
        System.out.println(list);// suleyman
        list.add(1, "yildirim");
        System.out.println(list); // [suleyman, yildirim]
        System.out.println(list.get(1)); //yildirim
        //list.set(2, "asd"); // java.lang.IndexOutOfBoundsException
        list.set(1, "DDD");
        System.out.println(list); //[suleyman, DDD]
        System.out.println(list.indexOf("DDD")); // 1
        System.out.println(list.lastIndexOf("suleyman")); // 1
        list.remove(0);
        System.out.println(list); // [DDD]
        list.remove("DDD");
        System.out.println(list); // []

        ////LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(5);

        ///Stack
        Deque<String> stack = new ArrayDeque<>();
        stack.push("1");
        stack.push("2");
        stack.pop(); // 2

    }
}
