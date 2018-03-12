package runOnDiscordTests;

import main.java.AccountCreator;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import org.junit.Assert;
import org.junit.Test;

import javax.security.auth.login.LoginException;

public class TestBot {

    //creates the accounts and tests their connections, if they are bots, and if they have access to the Test Channel ("general").
    //TODO: create test for sending client message to Discord and test that the listener works by retrieving the Admin Bot message

    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

    private User botID = botAccount.getUserById("417525335349788673");
    private User clientID = clientAccount.getUserById("355833643442110464");

    private String CS222TextChannelID = "415502671483633666";
    TextChannel CS222TextChannel = clientAccount.getTextChannelById(CS222TextChannelID);

    @Test
    public void testConnection(){
        String botConnectedToDiscord = botAccount.getStatus().toString();
        String clientConnectedToDiscord = clientAccount.getStatus().toString();
        Assert.assertEquals(clientConnectedToDiscord, botConnectedToDiscord, "CONNECTED");  //test both account connections to Discord
    }

    @Test
    public void testUsersInTextChannel(){
        String botInTextChannel = botAccount.getTextChannelById(CS222TextChannelID).getName();
        String clientInTextChannel = clientAccount.getTextChannelById(CS222TextChannelID).getName();
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
