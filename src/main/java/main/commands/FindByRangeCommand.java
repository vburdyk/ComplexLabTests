package main.commands;

import main.devices.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindByRangeCommand implements Command {

    Logger logger = LogManager.getLogger(FindByRangeCommand.class);
    private final List<Device> devices;
    private final List<Device> rangeDevices = new ArrayList<>();

    public FindByRangeCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the initial limit: ");
        float initPower = scanner.nextFloat();

        System.out.println("Enter the final limit: ");
        float finalPower = scanner.nextFloat();

        logger.info("Showing devices from " + initPower + " watts to " + finalPower + " watts");

        System.out.println("Devices from " + initPower + " watts to " + finalPower + " watts");
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getPower() >= initPower && devices.get(i).getPower() <= finalPower) {
                System.out.println(i + 1 + ". " + devices.get(i));
                rangeDevices.add(devices.get(i));
            }
        }
    }

    public List<Device> getDevicesWithinRange() {
        return rangeDevices;
    }
}
