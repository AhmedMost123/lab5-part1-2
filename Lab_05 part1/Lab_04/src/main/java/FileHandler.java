import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FileHandler {
    private String filePath;

    public Vector<Integer> getData() {
        File file = new File(filePath);
        Vector<Integer> data = new Vector<>();
        // or use BufferedReader
        try(Scanner reader = new Scanner(file)) {
            int n = reader.nextInt();
            for(int i = 0; i < n; i++) {
                data.add(reader.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. (File not found)");
        }
        return data;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
