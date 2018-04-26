package runOnDiscordTests.testActionListenerFeatures;

import net.dv8tion.jda.core.JDA;
import org.junit.Assert;
import org.junit.Test;
import testResources.CreateClientAccount;
import testResources.SendMessage;


//TODO: pass testInvalidCommand, and testDoNothingCommand
public class TestActionListener {

    private JDA clientAccount = CreateClientAccount.createClientAccount();

    //Test SendMessage can build a "!test" message and send it to Discord, to test other features.
    @Test
    public void testClientCanSendMessage(){
        SendMessage sendMessages = new SendMessage();
        sendMessages.sendMessageToDiscord(clientAccount, "!test");
        String helpMsg = sendMessages.getMessage().getContentRaw();
        Assert.assertEquals(helpMsg, "!test");
    }

    //Send "!invalid" message, which has a wrong command. Tests that bot will throw an exception
    @Test
    public void testInvalidCommand(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!Invalid");
    }

    //Sends "This is not a command." The bot replies to this message with DoNotRespondCommand
    @Test
    public void testDoNothingCommand(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "This is not a command.");
    }
}