package main;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void executeSortAscending(){

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Main.printMenu();

        String expectedOutput = "Menu:\r\n1. Add Device\r\n2. Show Devices\r\n3. Switch On Device\r\n4. Switch Off Device\r\n5. Find By Power Range\r\n6. Sort Devices by ascending\r\n7. Sort Devices by descending\r\n8. Exit\r\nEnter your choice:\r\n";
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);
    }

}