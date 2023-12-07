package main.commands;

import main.devices.Device;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SwitchOffCommandTest {
    @Test
    public void execute() {
        InputStream input = new ByteArrayInputStream("Device1\n".getBytes());
        InputStream systemIn = System.in;
        System.setIn(input);

        List<Device> devices = new ArrayList<>();
        SwitchOnCommand switchOnCommandCommand = new SwitchOnCommand(devices);

        Device device = new Device("Device1", 30);
        device.turnOn();
        devices.add(device);

        SwitchOffCommand switchOffCommandCommand = new SwitchOffCommand(devices, switchOnCommandCommand.getSwitchedOnDevices());
        switchOffCommandCommand.execute();

        assertFalse(devices.get(0).isOn());
        System.setIn(systemIn);
    }
}