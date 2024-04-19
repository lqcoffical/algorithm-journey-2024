package queueAndStack;

public class MyCircularQueue_lc622 {

    class MyCircularQueue {

        public int[] queue;
        // limit 就是限制队列里最多有多少数据，用size和limit给l和r解耦
        public int l, r, size, limit;

        public MyCircularQueue(int k) {
            queue = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                queue[r] = value;
                // 这里赋值语句就写成r+1，不写r++
                r = r == limit - 1 ? 0 : r + 1;
                size++;
                return true;
            }
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                // 不用改变值，只改变头标记:l即可，后面复用的时候也是覆盖这个位置
                l = l == limit - 1 ? 0 : l + 1;
                size--;
                return true;
            }
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                // l和r都在加入和删除方法里面维护了，这里直接取就可以
                return queue[l];
            }
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                int last = r == 0 ? (limit - 1) : (r - 1);
                return queue[last];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

}
