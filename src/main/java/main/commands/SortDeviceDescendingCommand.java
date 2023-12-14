package main.commands;

import main.devices.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;


public class SortDeviceDescendingCommand implements Command {

    Logger logger = LogManager.getLogger(SortDeviceDescendingCommand.class);
    private final List<Device> devices;

    public SortDeviceDescendingCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("There are no devices to sort.");
            logger.warn("There are no devices to sort!");
            return;
        }
        sortByPowerDescending(devices);
        System.out.println("Devices sorted by power in descending order.");
        logger.debug("Sorting of devices by decreasing power is done!");
        printSortedDevices(devices);
    }

    public static void sortByPowerDescending(List<Device> devices) {
        devices.sort(Comparator.comparing(Device::getPower).reversed());
    }

    public static void printSortedDevices(List<Device> devices) {
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }
}
