package File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
    public static String FileToString(String filePath) {
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
            return new String(fileBytes);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return "";
    }

    public static boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    public static void createFile(String filename) {
        try {
            File file = new File(filename);
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    public static void writeFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void appendToFile(String filename, String content) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error appending to file: " + e.getMessage());
        }
    }


}
