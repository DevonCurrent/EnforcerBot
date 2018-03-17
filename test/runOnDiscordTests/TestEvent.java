package runOnDiscordTests;

import junit.framework.Assert;
import main.java.AccountCreator;
import main.java.CommandParser;
import main.java.RegexProcessor;
import main.java.SendMessages;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import org.junit.Test;

public class TestEvent {
    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();
    private SendMessages sendMessage = new SendMessages();

    //Tests that the SendMessages class will create a message "!help" and send it to Discord
    @Test
    public void testSendMessages(){
        SendMessages sendMessages = new SendMessages();
        sendMessages.sendHelpMessage(clientAccount);
        String helpMsg = sendMessages.getMessage().getContentRaw();
        Assert.assertEquals(helpMsg, "!help");
    }

    //Tests the RegexProcessor which searches for a regex and will remove it. Then passes it to the Parser
    @Test
    public void testProcessor(){
        sendMessage.sendHelpMessage(clientAccount);
        Message helpMsg = sendMessage.getMessage();
        RegexProcessor regexProcessor = new RegexProcessor();
        RegexProcessor.process(helpMsg);
        Message processedMsg = regexProcessor.getProcessedMsg();
        String processedMsgAsString = processedMsg.getContentRaw();
        Assert.assertEquals(processedMsgAsString, "help");
    }

    //Tests that the the message "!help" will have the bot reply with "Test"
    @Test
    public void testCommandRespondToHelp(){
        sendMessage.sendHelpMessage(clientAccount);
        Message helpMsg = sendMessage.getMessage();
        RegexProcessor regexProcessor = new RegexProcessor();
        RegexProcessor.process(helpMsg);
    }
}
