import java.util.Scanner;

public class PasswordChecker {
    static String strength(String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[^a-zA-Z0-9].*")) score++;

        if (score <= 1) return "Weak";
        if (score <= 3) return "Medium";
        return "Strong";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.println("Strength: " + strength(password));
        sc.close();
    }
}
