package performActions;


import commands.*;
import net.dv8tion.jda.core.entities.Message;

import java.util.HashMap;

public class CommandCreator {

    private String commandName = null;

    //creates HashMap that stores all command names with the Command objects
    private HashMap<String, Command> commands = new HashMap<>();

    CommandCreator() {
        commands.put("!ping", new CommandRespondToPing());
        commands.put("null", new SpamScanner());
        commands.put("!kick", new CommandRespondToKick());
        commands.put("!ban", new CommandRespondToBan());
        commands.put("!unban", new CommandRespondToUnban());
        commands.put("!channels", new CommandRespondtoChannels());
        commands.put("!help", new CommandRespondToHelp());
    }

    //returns a command that is created by calling the name of the command from the HashMap
    public Command create(Message msg) {
        Command command = commands.get(commandName);

        //if the command does not exist, throw an exception
        if(command == null) {
            throw new RuntimeException();
        }

        command.setMessage(msg);
        return command;
    }

    //if a user does not use a regex ('!') in their text, then the return will be SpamScanner
    public Command spamScannerCommand() {
        Command command = commands.get("null");
        command.doAction();
        return command;
    }

    public void setCommandName(String[] commandName){
        this.commandName = commandName[0];
    }

}