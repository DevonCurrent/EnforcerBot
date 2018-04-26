package runOnDiscordTests;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;
import org.junit.Assert;
import org.junit.Test;
import testResources.CreateClientAccount;
import testResources.SendMessage;

import java.util.List;
import java.util.concurrent.TimeUnit;


//Test greeting command functionalities. Can set a greeting message for new members that join the guild.
public class TestGreetingMessage {

    private JDA botAccount = Bot.getInstance();
    Guild testingGuild = botAccount.getGuildsByName("CS222Testing",true).get(0);
    private SendMessage sendMessage = new SendMessage();


    //Test setting a greeting message and calling it by having bot send a private message to the recipient.
    @Test
    public void testCallGreetingMessage() throws InterruptedException {
        String greetingMessage = "Hi, this is a test for when people get invited to my testing guild";
        sendMessage.sendTestClientMessage("!greetings " + greetingMessage);
        sendMessage.sendTestClientMessage("!greetings?");

        //go through bot's latest private channel and receive last message(cannot access a client's private channels)
        PrivateChannel privateChannel = botAccount.getPrivateChannels().get(0);
        String latestMessageId = privateChannel.getLatestMessageId();
        Message latestMessage = privateChannel.getMessageById(latestMessageId).complete();
        String latestMessageContents = latestMessage.getContentRaw();

        Assert.assertEquals(latestMessageContents, greetingMessage);
    }
}
