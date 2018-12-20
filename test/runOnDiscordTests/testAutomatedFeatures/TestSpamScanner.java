package runOnDiscordTests.testAutomatedFeatures;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import org.junit.Assert;
import org.junit.Test;
import testResources.SendMessage;

public class TestSpamScanner {
    private JDA botAccount = Bot.getInstance();
    private Guild testingGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);
    private TextChannel generalTextChannel = testingGuild.getTextChannelsByName("General", true).get(0);
    private SendMessage sendMessage = new SendMessage();

    private String retrieveLatestMessage() {
        //retrieve the message that was sent to the discord testing guild.
        String latestMsgId = generalTextChannel.getLatestMessageId();
        Message latestMsg = generalTextChannel.getMessageById(latestMsgId).complete();
        return latestMsg.getContentRaw();
    }

    @Test
    public void testKickSpammingMember() throws InterruptedException {
        sendMessage.sendTestClientMessage("spam");
        sendMessage.sendTestClientMessage("spam");
        sendMessage.sendTestClientMessage("spam");

        String latestMessage = retrieveLatestMessage();

        Assert.assertEquals(latestMessage, "I cannot ban you since you are my superior, but please stop spamming!");
    }
}
