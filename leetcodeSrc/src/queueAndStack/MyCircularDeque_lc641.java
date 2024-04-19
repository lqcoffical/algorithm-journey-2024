package queueAndStack;

public class MyCircularDeque_lc641 {

    class MyCircularDeque {

        public int[] deque;

        // l/r表示最后一个有数字的位置
        public int l, r, size, limit;

        public MyCircularDeque(int k) {
            deque = new int[k];
            l = r = size = 0;
            limit = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                // 这里要判断是否为空，空的时候不管此时l、r在哪里，都重置回去位置
                if (isEmpty()) {
                    l = r = 0;
                    // 这块写l和0都可以，写l if会爆黄
                    deque[l] = value;
                } else {
                    // 三目运算符写括号吧，规范些
                    l = l == 0 ? (limit - 1) : (l - 1);
                    deque[l] = value;
                }
            }
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if (isEmpty()) {
                    l = r = 0;
                    deque[r] = value;
                } else {
                    r = r == (limit - 1) ? 0 : (r + 1);
                    deque[r] = value;
                }
            }
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                l = l == (limit - 1) ? 0 : l + 1;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                r = r == 0 ? (limit - 1) : (r - 1);
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque[l];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque[r];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }

}
