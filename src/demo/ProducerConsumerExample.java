package demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 共享缓冲区类
 */
class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 生产者生产数据
     */
    public synchronized void produce(int value) throws InterruptedException {
        // 如果缓冲区已满，生产者等待
        while (queue.size() == capacity) {
            System.out.println("缓冲区已满，生产者等待...");
            this.wait();
        }

        // 生产数据
        queue.offer(value);
        System.out.println("生产者生产: " + value + "，当前缓冲区大小: " + queue.size());

        // 通知消费者可以消费了
        this.notify();
    }

    /**
     * 消费者消费数据
     */
    public synchronized int consume() throws InterruptedException {
        // 如果缓冲区为空，消费者等待
        while (queue.isEmpty()) {
            System.out.println("缓冲区为空，消费者等待...");
            this.wait();
        }

        // 消费数据
        int value = queue.poll();
        System.out.println("消费者消费: " + value + "，当前缓冲区大小: " + queue.size());

        // 通知生产者可以生产了
        this.notify();

        return value;
    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    private final Buffer buffer;
    private final int maxProductions;

    public Producer(Buffer buffer, int maxProductions) {
        this.buffer = buffer;
        this.maxProductions = maxProductions;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxProductions; i++) {
            try {
                buffer.produce(i);
                Thread.sleep((long) (Math.random() * 1000)); // 模拟生产耗时
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("生产者完成生产任务");
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {
    private final Buffer buffer;
    private final int maxConsumptions;

    public Consumer(Buffer buffer, int maxConsumptions) {
        this.buffer = buffer;
        this.maxConsumptions = maxConsumptions;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maxConsumptions; i++) {
            try {
                buffer.consume();
                Thread.sleep((long) (Math.random() * 1500)); // 模拟消费耗时
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("消费者完成消费任务");
    }
}

/**
 * 主类 - 测试生产者消费者模式
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        // 创建容量为5的缓冲区
        Buffer buffer = new Buffer(5);

        // 创建生产者和消费者，各生产/消费20个产品
        Producer producer = new Producer(buffer, 20);
        Consumer consumer = new Consumer(buffer, 20);

        // 创建线程
        Thread producerThread = new Thread(producer, "生产者线程");
        Thread consumerThread = new Thread(consumer, "消费者线程");

        // 启动线程
        producerThread.start();
        consumerThread.start();

        // 等待线程结束
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("程序执行完毕");
    }
}