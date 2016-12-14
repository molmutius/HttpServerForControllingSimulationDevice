package com.github.molmutius.commands;

import java.util.ArrayList;
import java.util.List;

import static com.github.molmutius.commands.CommandList.Command.IGNITION_ON;

/**
 * @author Molmu on 14.12.2016.
 */
public class CommandList implements Commands
{
    public enum Command
    {
        IGNITION_ON("ignition_on", "ignite");

        public String httpCommand;
        public String pythonCommand;

        Command(String httpCommand, String pythonCommand)
        {
            this.httpCommand = httpCommand;
            this.pythonCommand = pythonCommand;
        }
    }

    private List<Command> commands;

    @Override
    public List<Command> getCommands()
    {
        if (commands == null)
        {
            initCommands();
        }
        return commands;
    }

    private void initCommands()
    {
        commands = new ArrayList<>();
        commands.add(IGNITION_ON);
    }
}
