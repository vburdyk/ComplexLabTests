package main;

import java.util.Scanner;

import main.commands.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddDeviceCommand addDeviceCommand = new AddDeviceCommand();
        SwitchOnCommand switchOnCommand = new SwitchOnCommand(addDeviceCommand.getDevices());
        SwitchOffCommand switchOffCommand = new SwitchOffCommand(addDeviceCommand.getDevices(), switchOnCommand.getSwitchedOnDevices());
        SortDeviceAscendingCommand sortDeviceAscendingCommand = new SortDeviceAscendingCommand(addDeviceCommand.getDevices());
        SortDeviceDescendingCommand sortDeviceDescendingCommand = new SortDeviceDescendingCommand(addDeviceCommand.getDevices());
        FindByRangeCommand findByRangeCommand = new FindByRangeCommand(addDeviceCommand.getDevices());
        ShowDeviceCommand showDeviceCommand = new ShowDeviceCommand(addDeviceCommand.getDevices());

        Invoker invoker = new Invoker(addDeviceCommand, switchOnCommand, switchOffCommand, sortDeviceAscendingCommand, sortDeviceDescendingCommand, findByRangeCommand, showDeviceCommand);

        while (true) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    invoker.addDevice();
                    break;
                case 2:
                    invoker.showDevice();
                    break;
                case 3:
                    invoker.switchOnDevice();
                    break;
                case 4:
                    invoker.switchOffDevice();
                    break;
                case 5:
                    invoker.findByRange();
                    break;
                case 6:
                    invoker.sortAscendingDevice();
                    break;
                case 7:
                    invoker.sortDescendingDevice();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Device");
        System.out.println("2. Show Devices");
        System.out.println("3. Switch On Device");
        System.out.println("4. Switch Off Device");
        System.out.println("5. Find By Power Range");
        System.out.println("6. Sort Devices by ascending");
        System.out.println("7. Sort Devices by descending");
        System.out.println("8. Exit");
        System.out.println("Enter your choice:");
    }
}
