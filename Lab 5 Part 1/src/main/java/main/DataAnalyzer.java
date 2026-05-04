package main;


import java.util.Vector;

public class DataAnalyzer 
{
    private final FileHandler fileHandler;

    public DataAnalyzer(FileHandler fileHandler) 
    {
        this.fileHandler = fileHandler;
    }

    public Integer getAverage() 
    {
        Vector<Integer> data = fileHandler.getData();

        if (data.isEmpty()) 
        {
            throw new IllegalStateException("No data available");
        }

        int sum = 0;
        for (int v : data) 
        {
            sum += v;
        }

        return sum / data.size(); 

    }

    public Integer getMin() 
    {
        Vector<Integer> data = fileHandler.getData();

        if (data.isEmpty()) 
        {
            throw new IllegalStateException("No data available");
        }

        int min = data.get(0);
        for (int v : data) 
        {
            if (v < min) 
            {
                min = v;
            }
        }

        return min;
    }

    public Integer getMax() 
    {
        Vector<Integer> data = fileHandler.getData();

        if (data.isEmpty()) 
        {
            throw new IllegalStateException("No data available");
        }

        int max = data.get(0);
        for (int v : data) 
        {
            if (v > max) 
            {
                max = v;
            }
        }

        return max;
    }
}