package threadOrder;

import java.util.concurrent.CountDownLatch;

public class OrderPrint3_lc1114 {

    // CountDownLatch的写法，减到0触发
    class Foo {
        private CountDownLatch latch1;
        private CountDownLatch latch2;
        public Foo() {
            latch1 = new CountDownLatch(1);
            latch2 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            latch1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            latch1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            latch2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            latch2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }
}
