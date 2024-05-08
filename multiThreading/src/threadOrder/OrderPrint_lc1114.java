package threadOrder;

import java.util.concurrent.Semaphore;

public class OrderPrint_lc1114 {

    // 提交答案的时候把构造方法改成Foo，或者不复制构造方法
    // synchronized+notifyAll的方法线程阻塞和切换、设置全局变量然后while死循环cpu空转，都不是最优雅解法
    // 最优雅解法是用信号量Semaphore和倒计时闩锁CountdownLatch
    public OrderPrint_lc1114() {

    }

    // 初始信号量设置为0，release方法可以释放一个，然后往上加
    // acquire()获取不到就先阻塞
    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        s1.acquire();
        printSecond.run();
        s2.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        s2.acquire();
        printThird.run();
    }



}
