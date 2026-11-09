import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        String[] logins = {"riya", "amit", "riya", "het", "neha", "amit", "jay"};
        Set<String> unique = new HashSet<>();
        LinkedHashSet<String> order = new LinkedHashSet<>();
        for (String login : logins) {
            unique.add(login);
            order.add(login);
        }

        System.out.println("Unique count: " + unique.size());
        int count = 0;
        for (String name : order) {
            if (count == 3) break;
            System.out.println(name);
            count++;
        }
    }
}
