import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.IOException;
import java.util.List;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {
        Path folder = Paths.get("logs");
        Files.createDirectories(folder);
        Files.writeString(folder.resolve("app1.txt"), "INFO started\nERROR failed\nINFO ended\n");
        Files.writeString(folder.resolve("app2.txt"), "INFO ready\nERROR timeout\n");

        int totalLines = 0;
        int matches = 0;
        String keyword = "ERROR";

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folder, "*.txt")) {
            for (Path file : stream) {
                List<String> lines = Files.readAllLines(file);
                totalLines += lines.size();
                for (String line : lines) {
                    if (line.contains(keyword)) matches++;
                }
                BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
                System.out.println(file.getFileName() + " size: " + attrs.size() + " bytes");
            }
        }
        System.out.println("Total lines: " + totalLines);
        System.out.println("Lines containing " + keyword + ": " + matches);
    }
}
