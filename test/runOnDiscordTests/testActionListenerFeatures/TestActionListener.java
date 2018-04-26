package runOnDiscordTests.testActionListenerFeatures;

import main.java.Bot;
import net.dv8tion.jda.core.entities.*;
import org.junit.Assert;
import org.junit.Test;
import testResources.SendMessage;


public class TestActionListener {
    private Bot botAccount = Bot.getInstance();
    private Guild testingGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);
    private TextChannel generalTextChannel = testingGuild.getTextChannelsByName("General", true).get(0);
    private SendMessage sendMessage = new SendMessage();

    private Message retrieveLatestMessage() {
        //retrieve the message that was sent to the discord testing guild.
        String latestMsgId = generalTextChannel.getLatestMessageId();
        return generalTextChannel.getMessageById(latestMsgId).complete();

    }

    //Test SendMessage can build a "!test" message and send it to Discord, to test other features.
    @Test
    public void testClientCanBuildMessage() throws InterruptedException {
        sendMessage.sendTestClientMessage("!test");
        String helpMsg = sendMessage.getMessage().getContentRaw();
        Assert.assertEquals(helpMsg, "!test");
    }

    @Test
    public void testDiscordReceivesMessage() throws InterruptedException {
        String msgToSend = "Did this get to Discord?";

        sendMessage.sendTestClientMessage(msgToSend);
        String latestMessage = retrieveLatestMessage().getContentRaw();

        Assert.assertEquals(latestMessage, msgToSend);
    }

    //Send "!invalid" message, which is a command that does not exist. Tests that bot will throw an exception
    @Test
    public void testInvalidCommand() throws InterruptedException {
        String msgToSend = "!invalid";

        sendMessage.sendTestClientMessage(msgToSend);
        String latestMessage = retrieveLatestMessage().getContentRaw();

        Assert.assertEquals(latestMessage, "That is an invalid request. If you need help knowing my functions, type '!help'");
    }

    @Test
    public void testBotRepliesToCommand() throws InterruptedException {
        String msgToSend = "!test";

        sendMessage.sendTestClientMessage(msgToSend);
        Message latestMessage = retrieveLatestMessage();
        Member latestMessageAuthor = latestMessage.getMember(); //Will be bot since it replied to the client message.
        String latestMessageAuthorName = latestMessageAuthor.getEffectiveName();

        SelfUser botUser = botAccount.getSelfUser();
        String botName = botUser.getName();
        Assert.assertEquals(latestMessageAuthorName, botName);
    }

    //Sends "This is not a command." The bot does not reply to this message (bot calls SpamScanner instead).
    @Test
    public void testDoNothingCommand() throws InterruptedException {
        String msgToSend = "This is not a command.";

        sendMessage.sendTestClientMessage(msgToSend);
        Message latestMessage = retrieveLatestMessage();
        Member latestMessageAuthor = latestMessage.getMember();
        User latestMessageUser = latestMessageAuthor.getUser();
        boolean isUserBot = latestMessageUser.isBot();  //is the last message from the bot (the bot responded) or not

        Assert.assertFalse(isUserBot);
    }
}