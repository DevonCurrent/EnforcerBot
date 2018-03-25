package performActions;


import commands.Command;
import commands.CommandRespondToPing;
import commands.NoResponseCommand;

import java.util.HashMap;

//TODO: add commands for "!kick", "!invite", "!ban" and add Command classes for these respective command names

public class CommandCreator {

    //creates HashMap that stores all command names with the Command objects
    private HashMap<String, Command> commands = new HashMap<>();

    CommandCreator() {
        commands.put("!ping", new CommandRespondToPing());
        commands.put("null", new NoResponseCommand());
    }

    //returns a command that is created by calling the name of the command from the HashMap
    public Command create(ParsedMessage parsedMessage) {
        Command command = commands.get(parsedMessage.getText());

        //if the command does not exist, throw an exception
        if(command == null) {
            throw new RuntimeException();
        }

        command.setParsedMessage(parsedMessage);
        return command;
    }

    //if a user does not use a regex ('!') in their text, then the return will be NoResponseCommand
    public Command doNothingCommand() {
        Command command = commands.get("null");
        command.doAction();
        return command;
    }
}