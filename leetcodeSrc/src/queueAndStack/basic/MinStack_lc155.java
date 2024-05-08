package queueAndStack.basic;

public class MinStack_lc155 {

    class MinStack {

        // 这个最大值，栈里面能保存元素最多的个数是试出来的，如果是Integer.MAX_VALUE会内存超出限制
        private int MAX_SIZE = 8001;
        private int[] data;
        private int[] min;

        private int size;

        public MinStack() {
            data = new int[MAX_SIZE];
            min = new int[MAX_SIZE];
            size = 0;
        }

        public void push(int val) {
            data[size] = val;
            // 这里要小于最小栈的当前栈顶元素，因为这个值是一直维护最小
            if (size == 0 || val <= min[size - 1]) {
                min[size] = val;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            // 不弹出，只返回栈顶
            return data[size - 1];
        }

        public int getMin() {
            // 不弹出，只返回栈顶
            return min[size - 1];
        }
    }

}
