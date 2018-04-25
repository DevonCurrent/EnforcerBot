package performActions;

import commands.Command;
import net.dv8tion.jda.core.entities.Message;

//parses the message and calls on the respective command for the message
public class CommandParser {

    public static Command parse(Message msg) throws RuntimeException {
        String msgString = msg.getContentRaw();

        if (msgString.startsWith("!")){
            String requestedMessage = msg.getContentRaw();
            String[] separatedWords = requestedMessage.split(" ");

            CommandCreator commandCreator = new CommandCreator();
            commandCreator.setCommandName(separatedWords);
            return commandCreator.create(msg);
        }

        //if there is no regex ('!'), return NoResponseCommand
        CommandCreator commandCreator = new CommandCreator();
        return commandCreator.spamScannerCommand();
    }
}
