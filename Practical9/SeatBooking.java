class Booking {
    int seatsLeft = 5;

    void bookUnsafe() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            seatsLeft--;
            System.out.println("Unsafe booking accepted");
        } else {
            System.out.println("No seats left");
        }
    }

    synchronized void bookSafe() {
        if (seatsLeft > 0) {
            seatsLeft--;
            System.out.println("Safe booking accepted");
        } else {
            System.out.println("No seats left");
        }
    }
}

public class SeatBooking {
    public static void main(String[] args) throws InterruptedException {
        Booking unsafe = new Booking();
        Thread[] users = new Thread[10];
        for (int i = 0; i < users.length; i++) {
            users[i] = new Thread(unsafe::bookUnsafe);
            users[i].start();
        }
        for (Thread t : users) t.join();
        System.out.println("Unsafe seats left: " + unsafe.seatsLeft);

        Booking safe = new Booking();
        for (int i = 0; i < users.length; i++) {
            users[i] = new Thread(safe::bookSafe);
            users[i].start();
        }
        for (Thread t : users) t.join();
        System.out.println("Safe seats left: " + safe.seatsLeft);
    }
}
