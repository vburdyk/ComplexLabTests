package main.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.devices.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddDeviceCommand implements Command{
    private final Scanner scanner = new Scanner(System.in);
    private final List<Device> devices = new ArrayList<>();
    Logger logger = LogManager.getLogger(AddDeviceCommand.class);

    public List<Device> getDevices(){
        return devices;
    }

    @Override
    public void execute() {
        System.out.println("Enter the name of the device: ");
        String name = scanner.nextLine();
        System.out.println("Enter the power of the device: ");
        float power = scanner.nextFloat();
        scanner.nextLine();

        Device newDevice = new Device();
        newDevice.setName(name);
        newDevice.setPower(power);

        devices.add(newDevice);
        System.out.println("Device " + newDevice.getName() + " successfully created!");
        logger.info("Додано новий пристрій: " + newDevice.getName());

        System.out.println("List of devices: ");

        for(int i = 0; i < devices.size(); i++)
        {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }

}
