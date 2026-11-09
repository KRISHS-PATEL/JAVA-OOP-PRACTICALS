import java.util.Scanner;

class DivideByZeroException extends Exception {
    DivideByZeroException() {
        super("Cannot divide by zero");
    }
}

public class GuardedCalculator {
    static double calculate(double a, double b, char op) throws DivideByZeroException {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) throw new DivideByZeroException();
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            try {
                System.out.print("Enter first number: ");
                double a = Double.parseDouble(sc.nextLine());
                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().trim().charAt(0);
                System.out.print("Enter second number: ");
                double b = Double.parseDouble(sc.nextLine());
                System.out.println("Result: " + calculate(a, b, op));
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers");
            } catch (DivideByZeroException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println("Attempt finished");
            }
        }
        sc.close();
    }
}
