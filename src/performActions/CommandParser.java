package performActions;

import commands.Command;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

//parses the message and calls on the respective command for the message
public class CommandParser {

    public static Command parse(Message msg) throws RuntimeException {
        String msgString = msg.getContentRaw();

        if (msgString.startsWith("!")){
            String msgText = msg.getContentRaw();
            TextChannel textChannel = msg.getTextChannel();
            ParsedMessage parsedMessage = new ParsedMessage(msgText, textChannel);
            CommandCreator commandCreator = new CommandCreator();
            return commandCreator.create(parsedMessage);
        }

        //if there is no regex ('!'), return NoResponseCommand
        CommandCreator commandCreator = new CommandCreator();
        return commandCreator.doNothingCommand();
    }
}
