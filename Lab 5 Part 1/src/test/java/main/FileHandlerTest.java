package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {
    FileHandler fileHandler;
    Vector<Integer> expectedData;

    @BeforeEach
    void setUp() 
    {
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
    void givenInvalidFilePath_whenGetData_thenThrowException() {
        fileHandler.setFilePath("src/test/resources/noFile.txt");

        assertThrows(RuntimeException.class, () -> fileHandler.getData());
    }

    @Test
    void givenFileWithInvalidData_whenGetData_thenThrowException() 
    {
        fileHandler.setFilePath("src/test/resources/text.txt");

        assertThrows(RuntimeException.class, () -> fileHandler.getData());
    }

    @Test
    void givenEmptyFile_whenGetData_thenThrowException() 
    {
        fileHandler.setFilePath("src/test/resources/nothing.txt");

        assertThrows(RuntimeException.class, () -> fileHandler.getData());
    }

    @Test
    void givenFileWithOneNumber_whenGetData_thenReturnSingleElementVector() 
    {
        fileHandler.setFilePath("src/test/resources/number.txt");

        Vector<Integer> result = fileHandler.getData();

        assertEquals(1, result.size());
        assertEquals(0, result.get(0));
    }
}