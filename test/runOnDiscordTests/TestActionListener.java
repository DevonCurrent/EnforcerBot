package runOnDiscordTests;

import commands.Command;
import main.java.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import performActions.CommandParser;
import testResources.SendClientMessage;


//TODO: pass testPingCommand, testInvalidCommand, and testDoNothingCommand
public class TestActionListener {

    private AccountCreator accountCreator = new AccountCreator();
    JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

    //Test SendClientMessage can build a "!test" message and send it to Discord, to test other features.
    @Test
    public void testClientCanSendMessage(){
        SendClientMessage sendMessages = new SendClientMessage();
        sendMessages.sendMessageToDiscord(clientAccount, "!test");
        String helpMsg = sendMessages.getMessage().getContentRaw();
        Assert.assertEquals(helpMsg, "!test");
    }



    //Sends "!ping" message, then tests that the bot responds with "pong"
    @Test
    public void testPingCommand(){
        SendClientMessage sendMessage = new SendClientMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!ping");
        Command ac = CommandParser.parse(sendMessage.getMessage());
        ac.getSentMessage();
        Message sentMessage = ac.getSentMessage();
        String messageAsString = sentMessage.getContentDisplay();
        Assert.assertEquals(messageAsString, "pong");
    }

    //Send "!invalid" message, which has a wrong command. Tests that bot will throw an exception
    @Test
    public void testInvalidCommand(){
        SendClientMessage sendMessage = new SendClientMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!Invalid");
    }

    //Sends "This is not a command." The bot replies to this message with DoNotRespondCommand
    @Test
    public void testDoNothingCommand(){
        SendClientMessage sendMessage = new SendClientMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "This is not a command.");
    }
}