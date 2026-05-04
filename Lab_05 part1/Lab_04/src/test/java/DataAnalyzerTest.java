import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataAnalyzerTest {
    DataAnalyzer dataAnalyzer;
    FileHandler fileHandler;

    @BeforeEach
    void setUp() {
        fileHandler = mock(FileHandler.class);
        dataAnalyzer = new DataAnalyzer(fileHandler);
    }

    @Nested
    class AverageTest {
        @Test
        void givenEmptyData_whenGetAverage_thenThrowException() {
            when(fileHandler.getData()).thenReturn(new Vector<>());

            assertThrows(ArithmeticException.class, () -> {
                dataAnalyzer.getAverage();
            });

        }
        @Test
        void givenDataWithOneNumber_whenGetAverage_thenReturnThatNumber() {
            Vector<Integer> data = new Vector<>();
            data.add(12);
            when(fileHandler.getData()).thenReturn(data);

            assertEquals(12, dataAnalyzer.getAverage());
        }
        @Test
        void givenDataWithMultipleNumbers_whenGetAverage_thenReturnAverage() {
            Vector<Integer> data = new Vector<>();
            data.add(12);
            data.add(31);
            data.add(45);
            data.add(121);
            data.add(4);
            when(fileHandler.getData()).thenReturn(data);

            assertEquals(42, dataAnalyzer.getAverage());
        }
    }

    @Nested
    class MinTest {
        @Test
        void givenEmptyData_whenGetMin_thenReturnIntegerMaxValue() {
            when(fileHandler.getData()).thenReturn(new Vector<>());

            assertEquals(Integer.MAX_VALUE, dataAnalyzer.getMin());
        }
        @Test
        void givenDataWithOneNumber_whenGetMin_thenReturnThatNumber() {
            Vector<Integer> data = new Vector<>();
            data.add(12);
            when(fileHandler.getData()).thenReturn(data);

            assertEquals(12, dataAnalyzer.getMin());
        }
        @Test
        void givenDataWithMultipleNumbers_whenGetMin_thenReturnMin() {
            Vector<Integer> data = new Vector<>();
            data.add(12);
            data.add(31);
            data.add(45);
            data.add(121);
            data.add(4);
            when(fileHandler.getData()).thenReturn(data);

            assertEquals(4, dataAnalyzer.getMin());
        }
    }

    @Nested
    class MaxTest {
        @Test
        void givenEmptyData_whenGetMax_thenReturnIntegerMinValue() {
            when(fileHandler.getData()).thenReturn(new Vector<>());

            assertEquals(Integer.MIN_VALUE, dataAnalyzer.getMax());
        }
        @Test
        void givenDataWithOneNumber_whenGetMax_thenReturnThatNumber() {
            Vector<Integer> data = new Vector<>();
            data.add(12);
            when(fileHandler.getData()).thenReturn(data);

            assertEquals(12, dataAnalyzer.getMax());
        }
        @Test
        void givenDataWithMultipleNumbers_whenGetMax_thenReturnMax() {
            Vector<Integer> data = new Vector<>();
            data.add(12);
            data.add(31);
            data.add(45);
            data.add(121);
            data.add(4);
            when(fileHandler.getData()).thenReturn(data);

            assertEquals(121, dataAnalyzer.getMax());
        }

    }
}
