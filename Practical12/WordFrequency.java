import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "java is easy and java is useful and easy to learn";
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : paragraph.toLowerCase().split("\\W+")) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> words = new ArrayList<>(frequency.entrySet());
        words.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> entry : words) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
