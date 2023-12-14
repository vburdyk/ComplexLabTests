package main.commands;

import main.devices.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShowDeviceCommand implements Command {
    List<Device> devices;
    Logger logger = LogManager.getLogger(ShowDeviceCommand.class);
    public ShowDeviceCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        logger.info("Showing list of devices!");
        System.out.println("List of devices: ");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }
}
