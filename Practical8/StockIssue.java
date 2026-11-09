import java.util.HashMap;
import java.util.Map;

class OutOfStockException extends Exception {
    private int shortfall;
    OutOfStockException(int shortfall) {
        super("Not enough stock. Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }
    int getShortfall() { return shortfall; }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException() {
        super("Quantity must be positive");
    }
}

class Warehouse {
    private Map<String, Integer> stock = new HashMap<>();

    Warehouse() {
        stock.put("pen", 10);
        stock.put("book", 5);
    }

    void issue(String item, int qty) throws OutOfStockException, InvalidQuantityException {
        if (qty <= 0) throw new InvalidQuantityException();
        int available = stock.getOrDefault(item, 0);
        if (qty > available) throw new OutOfStockException(qty - available);
        stock.put(item, available - qty);
        System.out.println("Issued " + qty + " " + item);
    }
}

public class StockIssue {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        String[][] requests = {{"pen", "3"}, {"book", "8"}, {"pen", "0"}, {"book", "2"}};
        for (String[] request : requests) {
            try {
                warehouse.issue(request[0], Integer.parseInt(request[1]));
            } catch (OutOfStockException | InvalidQuantityException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
