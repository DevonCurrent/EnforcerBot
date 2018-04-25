package runOnDiscordTests;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


//Test that the administrator commands (ban, kick, create channels) work. Test exceptions.

public class TestAdminCommands {

    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();

    //Tests for all four main Admin functionalities

    //TODO: have this test pass by having it call a bot account that will automatically join using a event action listener.
    //TODO: abstract the guilds variable and the above three lines to a separate class so they are not called every time.
    @Test
    public void testInviteCommand() throws InterruptedException {

        SnowflakeCacheView<Guild> guilds = botAccount.getGuildCache();
        Guild testingGuild = guilds.getElementsByName("CS222Testing").get(0);

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!invite TestBot");

        TimeUnit.SECONDS.sleep(3);  //may need to adjust time for slower computers/networks

        Member testBot = testingGuild.getMembersByName("TestBot", true).get(0);

        Assert.assertEquals(testBot.getEffectiveName(), "TestBot");
    }



    @Test
    public void testKickCommand() throws InterruptedException {
        Guild guild = botAccount.getGuildById("415502671483633664");
        Member memberToKick = guild.getMemberById("428266347101945887");
        User userToKick = guild.getJDA().getUserById("428266347101945887");
        boolean isMember = guild.isMember(userToKick);

        Assert.assertEquals(isMember, true);

        String memberToKickAsMention = memberToKick.getAsMention();

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!kick " + memberToKickAsMention);

        TimeUnit.SECONDS.sleep(3);

        isMember = guild.isMember(userToKick);
        Assert.assertEquals(isMember, false);

    }

    //TODO: have the test class append to banned list and create assert argument inorder to check it is in the banned list
    @Test
    public void testInBanList() throws InterruptedException {
        List<Boolean> bannedMembers = null;
        Guild guild = botAccount.getGuildById("415502671483633664");
        Member memberToBan = guild.getMemberById("428266347101945887");
        User userToBan = guild.getJDA().getUserById("428266347101945887");
        boolean isMember = guild.isMember(userToBan);

        Assert.assertEquals(isMember, true);

        String memberToKickAsMention = memberToBan.getAsMention();

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!ban " + memberToKickAsMention);

        TimeUnit.SECONDS.sleep(3);

        assert bannedMembers != null;
        bannedMembers = Collections.singletonList(bannedMembers.add(isMember));
        System.out.println(bannedMembers);
        isMember = guild.isMember(userToBan);
        Assert.assertEquals(isMember, false);
    }

    //create 2 voice channels and test they are both in the test guild. Do NOT have the bot launced to discord or 2 instances will run.
    @Test
    public void testCreateChannels() throws InterruptedException {

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!channels 2");

        TimeUnit.SECONDS.sleep(3);  //may need to adjust time for slower computers/networks

        SnowflakeCacheView<Guild> guilds = botAccount.getGuildCache();
        Guild testingGuild = guilds.getElementsByName("CS222Testing").get(0);

        SnowflakeCacheView<VoiceChannel> voiceChannels = testingGuild.getVoiceChannelCache();
        VoiceChannel channel1 = voiceChannels.getElementsByName("Channel 1").get(0);
        VoiceChannel channel2 = voiceChannels.getElementsByName("Channel 2").get(0);

        Assert.assertEquals(channel1.getName(), "Channel 1");
        Assert.assertEquals(channel1.getType(), ChannelType.VOICE);
        Assert.assertEquals(channel2.getName(), "Channel 2");
    }

    @Test
    public void testCreateChannelException(){

    }
}
