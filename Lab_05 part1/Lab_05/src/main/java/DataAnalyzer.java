import java.util.Vector;

public class DataAnalyzer {
    private final FileHandler fileHandler;

    public DataAnalyzer(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public Integer getAverage() {
        Vector<Integer> data = fileHandler.getData();
        Integer sum = 0;

        for(Integer i : data) {
            sum += i;
        }
        return sum / data.size();
    }

    public Integer getMin() {
        Vector<Integer> data = fileHandler.getData();
        Integer min = Integer.MAX_VALUE;

        for(Integer i : data) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }

    public Integer getMax() {
        Vector<Integer> data = fileHandler.getData();
        Integer max = Integer.MIN_VALUE;

        for(Integer i : data) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }
}
