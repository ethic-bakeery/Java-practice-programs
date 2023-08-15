import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadTextFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the text file: ");
        String filename = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            if (lines.isEmpty()) {
                System.out.println("The file is empty.");
            } else {
                System.out.println("Content of the file with line numbers:");
                for (int i = 0; i < lines.size(); i++) {
                    System.out.println((i + 1) + ". " + lines.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to open the file.");
        }

        // Close the scanner
        scanner.close();
    }
}
