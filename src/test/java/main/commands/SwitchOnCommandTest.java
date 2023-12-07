package main.commands;

import main.devices.Device;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SwitchOnCommandTest {

    @Test
    public void execute() {

        InputStream input = new ByteArrayInputStream("Device1\n".getBytes());
        InputStream systemIn = System.in;

        System.setIn(input);

        List<Device> devices = new ArrayList<>();

        devices.add(new Device("Device1", 30));
        devices.add(new Device("Device2", 40));

        SwitchOnCommand switchOnCommandCommand = new SwitchOnCommand(devices);

        switchOnCommandCommand.execute();

        assertEquals(1, switchOnCommandCommand.getSwitchedOnDevices().size());
        assertEquals(30, switchOnCommandCommand.calculateTotalPower(), 0.001);
        assertTrue(switchOnCommandCommand.getSwitchedOnDevices().get(0).isOn());

        System.setIn(systemIn);
    }
}