package runOnDiscordTests;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Invite;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;
import org.junit.Test;
import runOnDiscordTests.testResources.CreateClientAccount;
import runOnDiscordTests.testResources.SendMessage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestGreetingMessage {

    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();


    @Test
    public void testSendGreetingMessage() throws InterruptedException {
        SnowflakeCacheView<Guild> guilds = botAccount.getGuildCache();
        Guild testingGuild = guilds.getElementsByName("CS222Testing").get(0);

        SnowflakeCacheView<TextChannel> textChannels = testingGuild.getTextChannelCache();
        TextChannel generalChannel = textChannels.getElementsByName("general").get(0);
        generalChannel.createInvite().setMaxUses(1).complete();
        List<Invite> guildInvites = generalChannel.getInvites().complete();

        TimeUnit.SECONDS.sleep(3);  //may need to adjust time for slower computers/networks

        Invite invite = guildInvites.get(0);

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(botAccount, String.valueOf(invite));
    }
}
