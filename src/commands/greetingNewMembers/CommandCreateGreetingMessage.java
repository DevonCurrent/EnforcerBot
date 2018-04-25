package commands.greetingNewMembers;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;

public class CommandCreateGreetingMessage implements commands.Command {
    private Message msg;

    @Override
    public void doAction() {

        String greetingMessageContents = msg.getContentRaw().substring(11);
        Guild guild = msg.getGuild();

        GreetingMessages greetingMessages = new GreetingMessages();
        greetingMessages.updateGreetingMessages(guild, greetingMessageContents);
    }

    @Override
    public void setMessage(Message msg) {
        this.msg = msg;
    }

    @Override
    public Message getSentMessage() {
        return null;
    }
}
