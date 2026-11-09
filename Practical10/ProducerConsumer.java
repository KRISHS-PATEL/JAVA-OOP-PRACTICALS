import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 3;

    synchronized void put(int value) throws InterruptedException {
        while (queue.size() == capacity) wait();
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    synchronized int take() throws InterruptedException {
        while (queue.isEmpty()) wait();
        int value = queue.remove();
        System.out.println("Consumed: " + value);
        notifyAll();
        return value;
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        SharedBuffer buffer = new SharedBuffer();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) buffer.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) buffer.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}
