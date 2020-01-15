package generics_and_collections.generic.collections.framework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Suleyman Yildirim
 */
public class MapMethods {

    public static void main(String args[]) {
        String[] str = {"aaa", "bb", "aaa", "c", "bb", "aaa"};
        Map<String, Integer> map = new HashMap<>();
        for (String value : str) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                int frequency = map.get(value);
                map.put(value, ++frequency);
            }
        }

        for (String key : map.keySet()) {
            System.out.print(key + ", "); //aaa, bb, c,
        }

        for (Integer value : map.values()) {
            System.out.print(value + ", "); // 3, 2, 1,
        }

        System.out.println();

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("11", 10);
        treeMap.put("gfds", 20);
        treeMap.put("gnh", 30);
        treeMap.put("100", 30);
        treeMap.put("567", 40);
        treeMap.put("hjk", 50);
        treeMap.put("aa", 60);
        treeMap.put("bf", 70);
        System.out.println(treeMap); // {100=30, 11=10, 567=40, aa=60, bf=70, gfds=20, gnh=30, hjk=50}


        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("11", 10);
        hashMap.put("gfds", 20);
        hashMap.put("gnh", 30);
        hashMap.put("100", 30);
        hashMap.put("567", 40);
        hashMap.put("hjk", 50);
        hashMap.put("aa", 60);
        hashMap.put("bf", 70);
        System.out.println(hashMap); // {11=10, gnh=30, aa=60, 100=30, bf=70, 567=40, hjk=50, gfds=20}


    }
}
