package runOnDiscordTests;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import org.junit.Assert;
import org.junit.Test;

public class TestBot {

    //creates the accounts and tests their connections, if they are bots, and if they have access to the Test Channel ("general").
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();

    private User botID = botAccount.getUserById("417525335349788673");
    private User clientID = clientAccount.getUserById("355833643442110464");

    private String CS222TextChannelID = "415502671483633666";
    TextChannel CS222TextChannel = clientAccount.getTextChannelById(CS222TextChannelID);



    //tests that there is a connection between Discord and the users (bot and client)
    @Test
    public void testConnection(){
        String botConnectedToDiscord = botAccount.getStatus().toString();
        String clientConnectedToDiscord = clientAccount.getStatus().toString();
        Assert.assertEquals(clientConnectedToDiscord, botConnectedToDiscord, "CONNECTED");  //test both account connections to Discord
    }

    //tests that the users are in the correct TextChannel ("general")
    @Test
    public void testUsersInTextChannel(){
        Guild clientInGuild = clientAccount.getGuildsByName("CS222Testing", true).get(0);
        TextChannel clientInTextChannel = clientInGuild.getTextChannelsByName("general", true).get(0);

        Guild botInGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);
        TextChannel botInTextChannel = botInGuild.getTextChannelsByName("general", true).get(0);

        Assert.assertEquals(clientInTextChannel, botInTextChannel);  //test both are in general TextChannel
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
