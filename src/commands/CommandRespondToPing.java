package commands;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

//command for bot to respond to a ping message.
public class CommandRespondToPing implements Command {

    private Message sentMessage;
    private Message msg;

    @Override
    public void doAction() {
        sentMessage = new MessageBuilder().append("pong").build();

        TextChannel textChannel = msg.getTextChannel();
        textChannel.sendMessage(sentMessage).queue();
    }

    @Override
    public void setMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public Message getSentMessage(){
        return this.sentMessage;
    }
}
