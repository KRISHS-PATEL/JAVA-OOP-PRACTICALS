import java.util.Scanner;

record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int bike = 0;
        int car = 0;
        int truck = 0;

        while (true) {
            System.out.println("Enter vehicle number and type (bike/car/truck), or type done to finish:");
            String number = sc.next();
            if (number.equalsIgnoreCase("done")) break;
            String type = sc.next().toLowerCase();
            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case "bike" -> 20;
                case "car" -> 50;
                case "truck" -> 150;
                default -> 0;
            };

            if (toll == 0) continue;
            total += toll;
            switch (v.type()) {
                case "bike" -> bike++;
                case "car" -> car++;
                case "truck" -> truck++;
            }
        }

        String frequent = "bike";
        int highest = bike;
        if (car > highest) {
            frequent = "car";
            highest = car;
        }
        if (truck > highest) frequent = "truck";

        System.out.println("Total toll: " + total);
        System.out.println("Most frequent: " + frequent);
        sc.close();
    }
}
