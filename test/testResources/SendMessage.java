package testResources;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

//sends a built message to the testing channel "General" in the CS222Testing guild using a member account (bot or client)
public class SendMessage {
    private Message msg = null;

    public void sendMessageToDiscord(JDA memberAccount, String messageAsString){

        msg = new MessageBuilder().append(messageAsString).build();

        Guild memberInGuild = memberAccount.getGuildsByName("CS222Testing", true).get(0);
        TextChannel generalTextChannel = memberInGuild.getTextChannelsByName("general", true).get(0);

        MessageAction sendCorrectMessage = generalTextChannel.sendMessage(msg);
        sendCorrectMessage.queue();
    }

    public Message getMessage(){
        return this.msg;
    }
}