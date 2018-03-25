package commands;

import net.dv8tion.jda.core.entities.Message;
import performActions.ParsedMessage;

public interface Command {
    void doAction();
    void setParsedMessage(ParsedMessage parsedMessage);
    Message getSentMessage();
}
