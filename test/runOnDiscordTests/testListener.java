package runOnDiscordTests;

import junit.framework.Assert;
import main.java.AccountCreator;
import main.java.Events;
import main.java.SendMessages;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.junit.Test;

public class testListener extends ListenerAdapter{

    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

    //tests that the listener is working for client messages on Discord
    //a message is sent to Discord and the listener gets the message
    @Test
    public void testListeningToClient() {
        SendMessages sendMessages = new SendMessages();
        sendMessages.sendHelpMessage(clientAccount);
        Message clientMessage = Events.retrieveMessage();
        String clientMessageAsString = clientMessage.getContentRaw();
        Assert.assertEquals(clientMessageAsString, "!help");
    }

    @Test
    public void testListeningToBot(){
    }
}
