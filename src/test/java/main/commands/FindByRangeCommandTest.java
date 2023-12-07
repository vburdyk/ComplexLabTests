package main.commands;

import main.devices.Device;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class FindByRangeCommandTest {

    @Test
    public void testExecute() {
        InputStream input = new ByteArrayInputStream("20\n50\n".getBytes());
        InputStream systemIn = System.in;

        System.setIn(input);

        List<Device> devicesList = new ArrayList<>();
        devicesList.add(new Device("Device1", 30));
        devicesList.add(new Device("Device3", 50));
        devicesList.add(new Device("Device2", 40));
        devicesList.add(new Device("Device4", 60));

        float initPower = 20;
        float finalPower = 50;

        FindByRangeCommand findByRangeCommand = new FindByRangeCommand(devicesList);

        findByRangeCommand.execute();

        List<Device> foundDevices = findByRangeCommand.getDevicesWithinRange();
        assertEquals(3, foundDevices.size());
        for (Device foundDevice : foundDevices) {
            float power = foundDevice.getPower();
            assertTrue(power >= initPower && power <= finalPower);
        }
        System.setIn(systemIn);
    }
}