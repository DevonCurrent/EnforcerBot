package runOnDiscordTests;

import com.sun.xml.internal.bind.v2.TODO;
import commands.Command;
import main.java.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import performActions.CommandParser;
import testResources.SendMessage;

//TODO: create new class testAdminPrivilages that tests the invite, kick, and ban Commands

public class TestActionListener {

    private AccountCreator accountCreator = new AccountCreator();
    JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

    //Test can build a "!test" message and send it to Discord, to test other features.
    @Test
    public void testSendMessages(){
        SendMessage sendMessages = new SendMessage();
        sendMessages.sendMessageToDiscord(clientAccount, "!test");
        String helpMsg = sendMessages.getMessage().getContentRaw();
        Assert.assertEquals(helpMsg, "!test");
    }

    //TODO: pass the three tests below without refactoring classes in the performActions package
    //Sends "!ping" message, then tests that the bot responds with "pong"
    @Test
    public void testPingCommand(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!ping");
        Command ac = CommandParser.parse(sendMessage.getMessage());
        ac.doAction();
        Message sentMessage = ac.getSentMessage();
        String messageAsString = sentMessage.getContentRaw();
        Assert.assertEquals(messageAsString, "pong");
    }


    //Send "!invalid" message, which has a wrong command. Tests that bot will throw an exception
    @Before
    public void sendInvalidCommand(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!Invalid");
    }

    @Test
    public void testInvalidCommand(){

    }


    //Sends "This is not a command." The bot replies to this message with DoNotRespondCommand
    @Before
    public void sendMessageNotCommand(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "This is not a command.");
    }
    @Test
    public void testDoNothingCommand(){

    }
}
