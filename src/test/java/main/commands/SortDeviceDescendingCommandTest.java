package main.commands;

import main.devices.Device;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortDeviceDescendingCommandTest {

    @Test
    public void executeSortAscending() {
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Device2", 40));
        devices.add(new Device("Device1", 30));
        devices.add(new Device("Device3", 50));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SortDeviceDescendingCommand sortDeviceDescendingCommand = new SortDeviceDescendingCommand(devices);
        sortDeviceDescendingCommand.execute();

        String expectedOutput = "Devices sorted by power in descending order.\r\n1. Device{name='Device3', power=50.0, isOn=false}\r\n2. Device{name='Device2', power=40.0, isOn=false}\r\n3. Device{name='Device1', power=30.0, isOn=false}\r\n";
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);

        System.setOut(System.out);
    }

}