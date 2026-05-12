package demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionDemo {
    private static int state = 1;
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition conditionA = LOCK.newCondition();
    private static final Condition conditionB = LOCK.newCondition();
    private static final Condition conditionC = LOCK.newCondition();

    public static void main(String[] args) {
        new Thread(() -> print("A", 1, conditionA, conditionB), "Thread-A").start();
        new Thread(() -> print("B", 2, conditionB, conditionC), "Thread-B").start();
        new Thread(() -> print("C", 3, conditionC, conditionA), "Thread-C").start();
    }

    private static void print(String name, int currentFlag, Condition currentCond, Condition nextCond) {
        for (int i = 0; i < 10; i++) {
            LOCK.lock();
            try {
                while (state != currentFlag) {
                    currentCond.await();
                }
                System.out.print(name);
                state = (state % 3) + 1;
                nextCond.signal(); // 精准唤醒下一个线程
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            } finally {
                LOCK.unlock();
            }
        }
    }
}