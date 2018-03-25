package commands;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import performActions.ParsedMessage;

//command for bot to respond to a ping message.
public class CommandRespondToPing implements Command {

    private ParsedMessage parsedMessage;
    private Message sentMessage;

    @Override
    public void doAction() {
        sentMessage = new MessageBuilder().append("pong").build();

        TextChannel textChannel = parsedMessage.getTextChannel();
        textChannel.sendMessage(sentMessage).queue();
    }

    @Override
    public void setParsedMessage(ParsedMessage parsedMessage) {
        this.parsedMessage = parsedMessage;
    }

    @Override
    public Message getSentMessage(){
        return this.sentMessage;
    }
}
