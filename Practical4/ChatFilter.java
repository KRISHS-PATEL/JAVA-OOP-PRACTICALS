import java.util.Scanner;

public class ChatFilter {
    public static void main(String[] args) {
        String[] logs = {
            "10:00 Alice hello everyone",
            "10:01 Bob Java is useful",
            "10:02 Carol I like java",
            "bad line",
            "10:03 Dan goodbye"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword to search in chat logs: ");
        String keyword = sc.nextLine().toLowerCase();
        StringBuilder report = new StringBuilder();
        int count = 0;

        for (String line : logs)
             {
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) continue;
            if (line.toLowerCase().contains(keyword)) {
                report.append(line).append(System.lineSeparator());
                count++;
            }
        }

        System.out.print(report);
        System.out.println("Matches: " + count);
        sc.close();
    }
}
