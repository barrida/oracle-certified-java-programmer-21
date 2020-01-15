package generics_and_collections.generic.collections.framework.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Suleyman Yildirim
 */
public class QueueMethods {
    public static void main(String args[]) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1); // [1]
        queue.add(2); // [1, 2]
        queue.offer(3); // [1, 2, 3]
        queue.offer(4); // [1, 2, 3, 4]
        queue.poll(); // [2, 3, 4]
        queue.peek(); // [2, 3, 4]
        queue.poll(); // 3, 4]
    }
}
