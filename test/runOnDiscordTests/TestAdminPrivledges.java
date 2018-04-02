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
    @Test
    public void testKickPrivledge(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!kick");
        String testMsg = sendMessage.getMessage().getContentRaw();
        //if (clientAccount.isAdmin){
//                Assert.assertEquals(testMsg, "!kick");
//                return;
//            }
        //  else return false;
    }

    @Test
    public void testBanPrivledge(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!ban");
        String banMsg = sendMessage.getMessage().getContentRaw();
    }

    @Test
    public void testUnbanPrivledge(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!unban");
        String unbanMsg = sendMessage.getMessage().getContentRaw();
    }

}

