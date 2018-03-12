package runOnDiscordTests;

import main.java.Main;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.requests.restaction.MessageAction;
import org.junit.Assert;
import org.junit.Test;

import javax.security.auth.login.LoginException;

public class TestBot {

    //creates the accounts and tests their connections, if they are bots, and if they have access to the Test Channel ("general").
    //TODO: create a separate class for the accounts and call them to this test class
    //TODO: create test for sending client message to Discord and test that the listener works by retrieving the Admin Bot message

    private JDA botAccount;
    private JDA clientAccount;

    {
        try {
            botAccount = new JDABuilder(AccountType.BOT).setToken("NDE3NTI1MzM1MzQ5Nzg4Njcz.DXdamw.D7uf_Xgq__v6joVAkEoBLIvrmxc").buildBlocking();
            clientAccount = new JDABuilder(AccountType.CLIENT).setToken("MzU1ODMzNjQzNDQyMTEwNDY0.DKjfPQ.VU5t7ywdpi0kCENeqpGOPpg2X7c").buildBlocking();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    private User botID = botAccount.getUserById("417525335349788673");
    private User clientID = clientAccount.getUserById("355833643442110464");
    TextChannel CS222TextChannel = clientAccount.getTextChannelById("415502671483633666");

    @Test
    public void testBotIsConnected(){
        String botConnectedToDiscord = botAccount.getStatus().toString();
        Assert.assertEquals(botConnectedToDiscord, "CONNECTED");
    }

    @Test
    public void testClientIsConnected(){
        String clientConnectedToDiscord = clientAccount.getStatus().toString();
        Assert.assertEquals(clientConnectedToDiscord, "CONNECTED");
    }

    @Test
    public void testUsersInTextChannel(){
        String botInTextChannel = botAccount.getTextChannelById("415502671483633666").getName();
        String clientInTextChannel = clientAccount.getTextChannelById("415502671483633666").getName();
        Assert.assertEquals(clientInTextChannel, botInTextChannel, "general");  //test both are in general TextChannel
    }

    @Test
    public void testIsAdminBotABot(){
        Boolean adminBotABot = botID.isBot();
        Assert.assertTrue(adminBotABot);
    }

    @Test
    public void testIsClientABot(){
        Boolean clientABot = clientID.isBot();
        Assert.assertFalse(clientABot);
    }

    @Test
    public void testbotName(){
        String botName = botID.getName();
        Assert.assertEquals(botName, "Admin Bot");
    }

    @Test
    public void testClientName(){
        String clientName = clientID.getName();
        Assert.assertEquals(clientName, "SacredZoren");
    }
}
