package demo;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        new Thread(() -> print("A", semaphoreA, semaphoreB)).start();
        new Thread(() -> print("B", semaphoreB, semaphoreC)).start();
        new Thread(() -> print("C", semaphoreC, semaphoreA)).start();
    }

    private static void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < 10; i++) {
            try {
                current.acquire(); // 获取当前许可（阻塞直到获取）
                System.out.print(name);
                next.release();   // 释放下一个线程的许可
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}