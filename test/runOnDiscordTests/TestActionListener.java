package runOnDiscordTests;

import com.sun.xml.internal.bind.v2.TODO;
import commands.Command;
import main.java.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
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
    private SendMessage sendMessage = new SendMessage();
    private Message getSendMessage = sendMessage.getMessage();
    private String rawContent = getSendMessage.getContentRaw();
    private Message message;
    private Guild guild;

    //Test can build a "!test" message and send it to Discord, to test other features.
    @Test
    public void testSendMessages(){
        sendMessage.sendMessageToDiscord(clientAccount, "!test");
        String helpMsg = rawContent;
        Assert.assertEquals(helpMsg, "!test");
    }

    //TODO: pass the three tests below without refactoring classes in the performActions package
    //Sends "!ping" message, then tests that the bot responds with "pong"
    @Test
    public void testPingCommand(){
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
        sendMessage.sendMessageToDiscord(clientAccount, "!Invalid");
    }

    @Test
    public void testInvalidCommand(){

    }

    //Sends "This is not a command." The bot replies to this message with DoNotRespondCommand
    @Before
    public void sendMessageNotCommand(){
        sendMessage.sendMessageToDiscord(clientAccount, "This is not a command.");
    }

    @Test
    public void testDoNothingCommand(){

    }
    @Test
    public void testTicTacToe(){
        Assert.assertEquals(false, guild.getTextChannels());
        TicTacToe game;
        Assert.assertEquals(true, game.startGame());
        int x;
        int y;
        char board[][];
        if (board[x-1][y-1] == false){
            throw new RuntimeException("That spot is occupied.");
        }
    }

    @Test
    public void testRNG(){
        sendMessage.sendMessageToDiscord(clientAccount, "!rng 10");
        String rngMessage = rawContent;
        Assert.assertEquals(rngMessage, "!rng 10");
        double random = Math.floor(Math.random() * 10) +1;
        sendMessage.sendMessageToDiscord(clientAccount, "The random number generator generates " + random + ".");
    }
}
