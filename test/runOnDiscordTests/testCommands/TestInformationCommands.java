package runOnDiscordTests.testCommands;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import org.junit.Assert;
import org.junit.Test;
import testResources.CreateClientAccount;
import testResources.SendMessage;

import java.util.concurrent.TimeUnit;

//Tests information commands ("!help", "!ping") will have the bot send messages to the users.
public class TestInformationCommands {
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();
    Guild testingGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);

    //client sends "!ping" message, then tests that the bot responds with a message of its latency to the general channel.
    @Test
    public void testPingCommand() throws InterruptedException {
        long ping = botAccount.getPing();

        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!ping");

        TimeUnit.SECONDS.sleep(3);  //Wait to send message to discord. Time may vary based on computer/network

        TextChannel generalTextChannel = testingGuild.getTextChannelsByName("General", true).get(0);
        String latestMsgID = generalTextChannel.getLatestMessageId();
        Message latestMsg = generalTextChannel.getMessageById(latestMsgID).complete();

        Assert.assertEquals(latestMsg.getContentRaw(), "My ping is " + ping + "ms!");
    }

    //client sends "!help" message, then tests that the bot responds with a message about its functions
    @Test
    public void testHelpCommand() throws InterruptedException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!help");

        TimeUnit.SECONDS.sleep(3);  //Wait to send message to discord. Time may vary based on computer/network

        TextChannel generalTextChannel = testingGuild.getTextChannelsByName("General", true).get(0);
        String latestMsgID = generalTextChannel.getLatestMessageId();
        Message latestMsg = generalTextChannel.getMessageById(latestMsgID).complete();
        String latestMsgContents = latestMsg.getContentRaw();
        String latestMsgBeginningContents = latestMsgContents.substring(0, 16);

        Assert.assertEquals(latestMsgBeginningContents, "My commands are:");
    }

}
