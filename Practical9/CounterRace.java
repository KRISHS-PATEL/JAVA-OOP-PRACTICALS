class Counter {
    int value = 0;

    void increment() {
        value++;
    }

    synchronized void safeIncrement() {
        value++;
    }
}

public class CounterRace {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[8];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) counter.increment();
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Without synchronization: " + counter.value);

        counter.value = 0;
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) counter.safeIncrement();
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("With synchronization: " + counter.value);
    }
}
