import java.io.*;

public class FileReadWriteExample {
    public static void main(String[] args) {
        // String to append to the file
        String newText = "This is additional text to append.";
        // Append new text to the file
        appendToFile("example.txt", newText);
        // Read and print the contents of the file
        
    }

    // Function to append text to a file
    public static void appendToFile(String fileName, String textToAppend) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write("\n" + textToAppend); // Add newline character for clarity
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}
