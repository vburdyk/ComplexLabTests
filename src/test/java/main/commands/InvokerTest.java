package main.commands;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class InvokerTest {

    @Test
    public void testInvokerCommands(){
        Command addDeviceCommand = mock(Command.class);
        Command switchOnCommand = mock(Command.class);
        Command switchOffCommand = mock(Command.class);
        Command sortDeviceAscendingCommand = mock(Command.class);
        Command sortDeviceDescendingCommand = mock(Command.class);
        Command findByRangeCommand = mock(Command.class);
        Command showDeviceCommand = mock(Command.class);

        Invoker invoker = new Invoker(addDeviceCommand, switchOnCommand, switchOffCommand,
                sortDeviceAscendingCommand, sortDeviceDescendingCommand, findByRangeCommand, showDeviceCommand);

        invoker.addDevice();
        invoker.switchOnDevice();
        invoker.switchOffDevice();
        invoker.sortAscendingDevice();
        invoker.sortDescendingDevice();
        invoker.findByRange();
        invoker.showDevice();

        verify(addDeviceCommand, times(1)).execute();
        verify(switchOnCommand, times(1)).execute();
        verify(switchOffCommand, times(1)).execute();
        verify(sortDeviceAscendingCommand, times(1)).execute();
        verify(sortDeviceDescendingCommand, times(1)).execute();
        verify(findByRangeCommand, times(1)).execute();
        verify(showDeviceCommand, times(1)).execute();
    }

}