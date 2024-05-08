package queueAndStack.basic;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack_lc225 {

    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            while (n > 0) {
                queue.offer(queue.poll());
                n--;
            }
        }

        public int pop() {
            if (queue.isEmpty()) {
                return -1;
            } else {
                return queue.poll();
            }
        }

        public int top() {
            if (queue.isEmpty()) {
                return -1;
            } else {
                return queue.peek();
            }
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

}
