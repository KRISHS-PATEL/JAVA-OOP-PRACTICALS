import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        ItemService service = new ItemService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Add Item\n2. View Items\n3. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                try {
                    service.addItem(new Item(name));
                    System.out.println("Item added! Total count: " + service.getCount());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (choice.equals("2")) {
                System.out.println("List of items:");
                for (Item item : service.getItems()) {
                    System.out.println("- " + item.getName());
                }
            } else if (choice.equals("3")) {
                System.out.println("Exiting program...");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        scanner.close();
    }
}