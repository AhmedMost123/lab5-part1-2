package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FileHandler 
{
    private String filePath;

    public Vector<Integer> getData() 
    {
        if (filePath == null) 
        {
            throw new IllegalStateException("File path is not set");
        }

        Vector<Integer> data = new Vector<>();
        File file = new File(filePath);

        try (Scanner reader = new Scanner(file)) 
        {
            if (!reader.hasNextInt()) 
            {
                throw new RuntimeException("Missing count at beginning");
            }

            int n = reader.nextInt();

            for (int i = 0; i < n; i++) 
            {
                if (!reader.hasNextInt()) 
                {
                    throw new RuntimeException("Not enough integers in file");
                }
                data.add(reader.nextInt());
            }

            if (reader.hasNext()) 
            {
                throw new RuntimeException("Extra data after expected numbers");
            }

        } 
        catch (FileNotFoundException e) 
        {
            throw new RuntimeException("Error, file not found: " + filePath, e);
        }

        return data;
    }

    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }
}