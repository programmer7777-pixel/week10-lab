import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentFileWriter {
    public static void main(String[] args) {
        File file = new File("students.txt");

        if (file.exists()) {
            System.out.println("Warning: File already exists and will be overwritten.");
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {

            writer.println("Ali Karimov 3.85 ComputerScience");
            writer.println("Sara Lee 3.67 Biology");
            writer.println("John Smith 3.45 Mathematics");
            writer.println("Emma Davis 3.92 Engineering");
            writer.println("Liam Brown 3.58 Physics");

            System.out.println("File written successfully.");

        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}