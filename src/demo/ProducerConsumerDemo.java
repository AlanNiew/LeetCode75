package demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * 生产者-消费者模式示例
 * 使用wait()/notify()机制实现线程间通信
 */
public class ProducerConsumerDemo {
    private static final int BUFFER_SIZE = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();

    public static void main(String[] args) {
        Producer producer = new Producer(buffer, BUFFER_SIZE);
        Consumer consumer = new Consumer(buffer);

        Thread producerThread = new Thread(producer, "Producer-Thread");
        Thread consumerThread = new Thread(consumer, "Consumer-Thread");

        producerThread.start();
        consumerThread.start();

        try {
            Thread.sleep(5000);
            producerThread.interrupt();
            consumerThread.interrupt();
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("程序结束");
    }

    /**
     * 生产者类
     */
    static class Producer implements Runnable {
        private final Queue<Integer> buffer;
        private final int maxSize;
        private final Random random = new Random();

        public Producer(Queue<Integer> buffer, int maxSize) {
            this.buffer = buffer;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            int value = 0;
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    produce(value);
                    Thread.sleep(random.nextInt(1000));
                    value++;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        private void produce(int value) throws InterruptedException {
            synchronized (buffer) {
                while (buffer.size() == maxSize) {
                    System.out.println("缓冲区已满，生产者等待...");
                    buffer.wait();
                }

                buffer.add(value);
                System.out.println("生产者生产: " + value + " | 当前缓冲区大小: " + buffer.size());
                buffer.notifyAll();
            }
        }
    }

    /**
     * 消费者类
     */
    static class Consumer implements Runnable {
        private final Queue<Integer> buffer;
        private final Random random = new Random();

        public Consumer(Queue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    consume();
                    Thread.sleep(random.nextInt(1500));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        private void consume() throws InterruptedException {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    System.out.println("缓冲区为空，消费者等待...");
                    buffer.wait();
                }

                int value = buffer.poll();
                System.out.println("消费者消费: " + value + " | 当前缓冲区大小: " + buffer.size());
                buffer.notifyAll();
            }
        }
    }
}
