import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    FileHandler fileHandler;
    Vector<Integer> expectedData;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandler();
        expectedData = new Vector<>();
    }

    @Test
    void givenFileWithInts_whenGetFileData_thenReturnVector() {
        expectedData.add(12);
        expectedData.add(31);
        expectedData.add(45);
        expectedData.add(121);
        expectedData.add(4);

        fileHandler.setFilePath("src/test/resources/numbers.txt");

        Vector<Integer> actualData = fileHandler.getData();

        assertEquals(expectedData, actualData);
    }

    @Test
    void givenFilePathWithNoFile_whenGetFilePath_thenReturnEmptyVector() {
        fileHandler.setFilePath("src/test/resources/noFile.txt");
        assertEquals(expectedData, fileHandler.getData());
    }

    @Test
    void givenFileWithSomethingOtherThanInts_whenGetFileData_thenThrowException() {
        fileHandler.setFilePath("src/test/resources/text.txt");
        assertThrows(InputMismatchException.class, () -> fileHandler.getData());
    }

    @Test
    void givenEmptyFile_whenGetFileData_thenThrowException() {
        fileHandler.setFilePath("src/test/resources/nothing.txt");
        assertThrows(NoSuchElementException.class, () -> fileHandler.getData());
        // As we read n without seeing if there is something to read
    }

    @Test
    void givenFileWithOneNumber_whenGetFileData_thenReturnEmptyVector() {
        fileHandler.setFilePath("src/test/resources/number.txt");
        assertEquals(expectedData, fileHandler.getData());
    }
}
