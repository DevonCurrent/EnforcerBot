package runOnDiscordTests;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.SelfUser;
import net.dv8tion.jda.core.entities.TextChannel;
import org.junit.Assert;
import org.junit.Test;
import testResources.CreateClientAccount;

public class TestBot {

    //creates the accounts and tests their connections, if they are bots, and if they have access to the Test Channel ("general").
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();

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
        SelfUser botAsUser = botAccount.getSelfUser();
        boolean isAdminBotABot = botAsUser.isBot();
        Assert.assertTrue(isAdminBotABot);
    }

    @Test
    public void testIsClientABot(){
        SelfUser clientAsUser = clientAccount.getSelfUser();
        Boolean isClientABot = clientAsUser.isBot();
        Assert.assertFalse(isClientABot);
    }

    @Test
    public void testbotName(){
        SelfUser botAsUser = botAccount.getSelfUser();
        String botName = botAsUser.getName();
        Assert.assertEquals(botName, "Admin Bot");
    }

    @Test
    public void testClientName(){
        SelfUser clientAsUser = clientAccount.getSelfUser();
        String clientName = clientAsUser.getName();
        Assert.assertEquals(clientName, "SacredZoren");
    }
}
