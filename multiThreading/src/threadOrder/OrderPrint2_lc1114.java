package threadOrder;

import java.util.concurrent.CyclicBarrier;

public class OrderPrint2_lc1114 {

    class Foo {

        // CyclicBarrier的写法，初始化为2，有2线程等待就可以触发
        private CyclicBarrier cy1, cy2;

        public Foo() {
            cy1 = new CyclicBarrier(2);
            cy2 = new CyclicBarrier(2);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            try {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                cy1.await();
            } catch (Exception exception) {

            }

        }

        public void second(Runnable printSecond) throws InterruptedException {
            try {
                cy1.await();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                cy2.await();
            } catch (Exception exception) {

            }

        }

        public void third(Runnable printThird) throws InterruptedException {
            try {
                cy2.await();
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            } catch (Exception exception) {

            }

        }
    }
}
