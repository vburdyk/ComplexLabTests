package main.commands;

import main.devices.Device;

import java.util.Comparator;
import java.util.List;

public class SortDeviceAscendingCommand implements Command {

    private final List<Device> devices;

    public SortDeviceAscendingCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("There are no devices to sort.");
            return;
        }

        sortByPowerAscending(devices);
        System.out.println("Devices sorted by power in ascending order.");
        printSortedDevices(devices);

    }


    public static void sortByPowerAscending(List<Device> devices) {
        devices.sort(Comparator.comparing(Device::getPower));
    }


    public static void printSortedDevices(List<Device> devices) {
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }
}
