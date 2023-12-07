package main.commands;

public class Invoker {
    private final Command addDeviceCommand;
    private final Command switchOnCommand;
    private final Command switchOffCommand;
    private final Command sortDeviceAscendingCommand;
    private final Command sortDeviceDescendingCommand;
    private final Command findByRangeCommand;
    private final Command showDeviceCommand;

    public Invoker(Command addDeviceCommand, Command switchOnCommand, Command switchOffCommand, Command sortDeviceAscendingCommand,Command sortDeviceDescendingCommand, Command findByRangeCommand, Command showDeviceCommand) {
        this.addDeviceCommand = addDeviceCommand;
        this.switchOnCommand = switchOnCommand;
        this.switchOffCommand = switchOffCommand;
        this.sortDeviceAscendingCommand = sortDeviceAscendingCommand;
        this.sortDeviceDescendingCommand = sortDeviceDescendingCommand;
        this.findByRangeCommand = findByRangeCommand;
        this.showDeviceCommand = showDeviceCommand;
    }

    public void addDevice() {
        addDeviceCommand.execute();
    }
    public void switchOnDevice() {
        switchOnCommand.execute();
    }
    public void switchOffDevice() {
        switchOffCommand.execute();
    }
    public void sortAscendingDevice() {
        sortDeviceAscendingCommand.execute();
    }
    public void sortDescendingDevice() {
        sortDeviceDescendingCommand.execute();
    }
    public void findByRange(){
        findByRangeCommand.execute();
    }
    public void showDevice(){
        showDeviceCommand.execute();
    }
}
