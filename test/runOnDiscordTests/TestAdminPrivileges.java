package runOnDiscordTests;

import com.sun.xml.internal.ws.resources.SenderMessages;
import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;
import org.junit.Assert;
import org.junit.Test;
import testResources.SendMessage;

import java.util.concurrent.TimeUnit;

public class TestAdminPrivileges {

    private AccountCreator accountCreator = new AccountCreator();
    JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

    //Tests for all four main Admin functionalities
    @Test
    public void testKickPrivileges() throws InterruptedException {
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
    
    //TODO: have the test class append to banned list and create assert argument inorder to check it is in the banned list. needs fixing.
    @Test
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

        bannedMembers = Collections.singletonList(bannedMembers.add(isMember));
        System.out.println(bannedMembers);
        isMember = guild.isMember(userToBan);
        Assert.assertEquals(isMember, false);
    }



}
