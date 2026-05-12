package demo;

public class SyncWaitNotifyDemo {
    private static int state = 1; // 1:A, 2:B, 3:C
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        new Thread(() -> print("A", 1, 2), "Thread-A").start();
        new Thread(() -> print("B", 2, 3), "Thread-B").start();
        new Thread(() -> print("C", 3, 1), "Thread-C").start();
    }

    private static void print(String name, int currentFlag, int nextFlag) {
        for (int i = 0; i < 10; i++) {
            synchronized (LOCK) {
                while (state != currentFlag) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + "被中断");
                    }
                }
                System.out.println(name);
                state = nextFlag;
                LOCK.notifyAll();
            }
        }
    }
}