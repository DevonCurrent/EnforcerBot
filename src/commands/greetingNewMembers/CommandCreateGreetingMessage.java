package commands.greetingNewMembers;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;

//creates a greeting message for the guild the message is sent from.
public class CommandCreateGreetingMessage implements commands.Command {
    private Message msg;

    @Override
    public void doAction() {

        String greetingMessageContents = msg.getContentRaw().substring(11);
        Guild guild = msg.getGuild();

        GreetingMessages.updateGreetingMessages(guild, greetingMessageContents);
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
