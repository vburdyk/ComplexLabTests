package main.commands;

import main.devices.Device;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class AddDeviceCommandTest {

    @Test
    public void execute() {

        InputStream input = new ByteArrayInputStream("Device1\n1\n".getBytes());
        InputStream systemIn = System.in;
        System.setIn(input);

        AddDeviceCommand addDeviceCommand = new AddDeviceCommand();
        List<Device> devices = addDeviceCommand.getDevices();
        addDeviceCommand.execute();

        assertEquals(1, devices.size());
        assertEquals("Device1", devices.get(0).getName());
        assertEquals(1, devices.get(0).getPower(), 0.001);

        System.setIn(systemIn);
    }
}