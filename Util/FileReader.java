import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static Scanner getFileContents(String fileLocation) {
        try {
            File myObj = new File(fileLocation);
            return new Scanner(myObj);
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read file");
            e.printStackTrace();
            return null;
        }
    }

}
