package demo;

import java.util.concurrent.atomic.AtomicInteger;

public class CasSpinDemo {
    private static final AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread(() -> print("A", 1)).start();
        new Thread(() -> print("B", 2)).start();
        new Thread(() -> print("C", 0)).start(); // 3 % 3 = 0
    }

    private static void print(String name, int targetRemainder) {
        int currentLoop = 0;
        while (currentLoop < 10) {
            int current = count.get();
            if (current % 3 == targetRemainder) {
                // CAS 尝试更新：如果 current 没变，就变成 current+1
                if (count.compareAndSet(current, current + 1)) {
                    System.out.print(name);
                    currentLoop++;
                }
            }
            // 可以在这里加 Thread.yield() 让出 CPU 时间片，避免空转占用过高 CPU
        }
    }
}