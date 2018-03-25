package commands;

import net.dv8tion.jda.core.entities.Message;
import performActions.ParsedMessage;

public class NoResponseCommand implements Command {
    @Override
    public void doAction() {

    }

    @Override
    public void setParsedMessage(ParsedMessage parsedMessage) {

    }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
