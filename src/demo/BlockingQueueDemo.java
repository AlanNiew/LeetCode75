package demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> q1 = new LinkedBlockingQueue<>(1);
        BlockingQueue<String> q2 = new LinkedBlockingQueue<>(1);
        BlockingQueue<String> q3 = new LinkedBlockingQueue<>(1);

        // 初始启动信号
        try { q1.put("start"); } catch (InterruptedException e) {}

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    q1.take(); // 阻塞等待
                    System.out.print("A");
                    q2.put("next");
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    q2.take();
                    System.out.print("B");
                    q3.put("next");
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    q3.take();
                    System.out.print("C");
                    q1.put("next");
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }).start();
    }
}