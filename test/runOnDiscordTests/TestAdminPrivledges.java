package runOnDiscordTests;

import com.sun.xml.internal.ws.resources.SenderMessages;
import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import org.junit.Assert;
import org.junit.Test;
import testResources.SendMessage;

public class TestAdminPrivledges {

    private AccountCreator accountCreator = new AccountCreator();
    JDA botAccount = accountCreator.createBotAccount();
    private JDA clientAccount = accountCreator.createClientAccount();

    //Tests for all four main Admin functionalities
    public void testKickPrivledge(){

        Member member = guild.getMemberById("428960077794246656");
        Assert.assertEquals(member, true);

        SendMessage sentMessage = new SendMessage();
        sentMessage.sendMessageToDiscord(clientAccount, "!kick Manyemjyeb#9108");

        Assert.assertEquals(member, null);

        
    }

    @Test
    public void testBanPrivledge(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!ban");
        String banMsg = sendMessage.getMessage().getContentRaw();
    }

    

}
