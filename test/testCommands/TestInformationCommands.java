package testCommands;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import org.junit.Assert;
import org.junit.Test;
import runOnDiscordTests.testResources.CreateClientAccount;
import runOnDiscordTests.testResources.SendMessage;

import java.util.concurrent.TimeUnit;

//Tests information commands ("!help", "!ping") will have the bot send messages to the users.
public class TestInformationCommands {
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();
    Guild testingGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);

    //Sends "!ping" message, then tests that the bot responds with a message of its latency to the general channel.
    @Test
    public void testPingCommand() throws InterruptedException {
        long ping = botAccount.getPing();

        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!ping");

        TimeUnit.SECONDS.sleep(3);

        TextChannel generalTextChannel = testingGuild.getTextChannelsByName("General", true).get(0);
        String latestMsgID = generalTextChannel.getLatestMessageId();
        Message latestMsg = generalTextChannel.getMessageById(latestMsgID).complete();

        Assert.assertEquals(latestMsg.getContentRaw(), "My ping is " + ping + " ms!");
    }

}
