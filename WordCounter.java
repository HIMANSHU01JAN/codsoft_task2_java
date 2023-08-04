import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Enter '1' to input text manually, or '2' to provide a file path:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.println("Enter the text:");
                input = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the file path:");
                String filePath = scanner.nextLine();
                try {
                    input = readFile(filePath);
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        // Remove punctuation and convert input to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        String[] words = cleanedInput.split("\\s+"); // Split the input into words

        int wordCount = words.length; // Initialize word count

        System.out.println("Total word count: " + wordCount);
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }

        scanner.close();
        return content.toString();
    }
}
