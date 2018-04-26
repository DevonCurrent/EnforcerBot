package performActions;

import commands.*;
import commands.greetingNewMembers.CommandCallGreetingMessage;
import commands.greetingNewMembers.CommandCreateGreetingMessage;
import monitorSpam.SpamScanner;
import net.dv8tion.jda.core.entities.Message;
import java.util.HashMap;

//Part of the Command Model. Will look at parsed messages and call on the corresponding commands.
public class CommandCreator {

    private String commandName = null;

    //creates HashMap that stores all command names with the Command objects
    private HashMap<String, Command> commands = new HashMap<>();

    CommandCreator() {
        commands.put("!ping", new CommandSendPingStatus());
        commands.put("spam", new SpamScanner());
        commands.put("!kick", new CommandKickUser());
        commands.put("!ban", new CommandBanUser());
        commands.put("!unban", new CommandUnbanUser());
        commands.put("!channels", new CommandCreateChannels());
        commands.put("!help", new CommandSendHelpMessage());
        commands.put("!greetings", new CommandCreateGreetingMessage());
        commands.put("!greetings?", new CommandCallGreetingMessage());
        commands.put("!rng", new CommandCreateRandomNumber());
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
    public Command spamScannerCommand(Message msg)  {
        Command command = commands.get("spam");
        command.setMessage(msg);
        return command;
    }

    public void setCommandName(String[] commandName){
        this.commandName = commandName[0];
    }

}