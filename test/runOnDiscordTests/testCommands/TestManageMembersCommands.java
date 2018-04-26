package runOnDiscordTests.testCommands;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.utils.cache.SnowflakeCacheView;
import org.junit.Assert;
import org.junit.Test;
import testResources.CreateClientAccount;
import testResources.SendMessage;

import java.util.Iterator;
import java.util.List;


/*Test the administrator commands that manage members (ban, kick, unban, channels).
    Must manually invite a bot back into a guild -> could not use a Test Bot. This means kick and ban tests will only
    work once before manually re-inviting back members.
*/

public class TestManageMembersCommands {
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();
    private Guild testingGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);

    //kick member from the guild. Will test that they are part of the guild before and after being kicked.
    @Test
    public void testKickCommand() throws InterruptedException {
        User userToKick = botAccount.getUsersByName("PleaseDontBanMe", true).get(0);
        boolean isMember = testingGuild.isMember(userToKick);
        Assert.assertEquals(isMember, true);

        String memberToKickAsMention = userToKick.getAsMention();
        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!kick " + memberToKickAsMention);

        isMember = testingGuild.isMember(userToKick);
        Assert.assertEquals(isMember, false);
    }

    //Test a user is in the guild. Then the user is banned and tested that they are not in the guild and on the ban list.
    @Test
    public void testInBanList() throws InterruptedException {
        User userToBan = botAccount.getUsersByName("PleaseDontBanMe", true).get(0);
        boolean isMember = testingGuild.isMember(userToBan);
        Assert.assertEquals(isMember, true);    //Assert that the user is in the guild (before being banned).

        String userToBanAsMention = userToBan.getAsMention();

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!ban " + userToBanAsMention);

        isMember = testingGuild.isMember(userToBan);
        Assert.assertEquals(isMember, false);   //Assert that the user is no longer in the guild

        List<Guild.Ban> banList = testingGuild.getBanList().complete();

        User user = banList.get(0).getUser();
        Iterator<Guild.Ban> banListIterator = banList.iterator();
        boolean isUserInBanList = false;

        while(banListIterator.hasNext()){
            User bannedUser = banListIterator.next().getUser();
            String bannedUserName = bannedUser.getName();
            if(bannedUserName.equals("PleaseDontBanMe"))
                isUserInBanList = true;
        }

        Assert.assertEquals(isUserInBanList, true);   //Assert that the user is on the ban list of the guild.
    }

    //create 2 voice channels and test they are both in the test guild.
    @Test
    public void testCreateChannels() throws InterruptedException {

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!channels 2");

        SnowflakeCacheView<Guild> guilds = botAccount.getGuildCache();
        Guild testingGuild = guilds.getElementsByName("CS222Testing").get(0);

        SnowflakeCacheView<VoiceChannel> voiceChannels = testingGuild.getVoiceChannelCache();
        VoiceChannel channel1 = voiceChannels.getElementsByName("Channel 1").get(0);
        VoiceChannel channel2 = voiceChannels.getElementsByName("Channel 2").get(0);

        Assert.assertEquals(channel1.getName(), "Channel 1");
        Assert.assertEquals(channel1.getType(), ChannelType.VOICE);
        Assert.assertEquals(channel2.getName(), "Channel 2");
    }
}
