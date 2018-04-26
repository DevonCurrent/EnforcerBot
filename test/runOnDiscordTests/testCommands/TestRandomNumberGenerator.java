package runOnDiscordTests.testCommands;

import main.java.Bot;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;
import org.junit.Assert;
import org.junit.Test;
import testResources.CreateClientAccount;
import testResources.SendMessage;

import java.util.concurrent.TimeUnit;

//Tests that the bot will give a random number from 1 to n. Test exceptions thrown if an integer is not given.
public class TestRandomNumberGenerator {
    private JDA botAccount = Bot.getInstance();
    private JDA clientAccount = CreateClientAccount.createClientAccount();
    Guild testingGuild = botAccount.getGuildsByName("CS222Testing", true).get(0);
    TextChannel generalTextChannel = testingGuild.getTextChannelsByName("General", true).get(0);


    private String retrieveLatestMessage() {
        //retrieve the message that was sent to the discord testing guild.
        String latestMsgId = generalTextChannel.getLatestMessageId();
        Message latestMsg = generalTextChannel.getMessageById(latestMsgId).complete();
        return latestMsg.getContentRaw();
    }

    private int parseLatestMsg(String latestMsg) {
        //parse the last message of the guild to retrieve the number at the end of the message.
        String[] latestMsgContentAsArray = latestMsg.split(" ");
        return Integer.parseInt(latestMsgContentAsArray[5].replaceAll("!", ""));
    }

    private void sendRNGMessage(String s) throws InterruptedException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, s);

        TimeUnit.SECONDS.sleep(1);  //Wait to send message to discord. Time may vary based on computer/network
    }


    @Test   //Tests the default value of 6 will work.
    public void testRNGWithDefault() throws InterruptedException {

        for(int i=0; i<10; i++){        //Run through 10 times to make sure it is not a fluke.
            sendRNGMessage("!rng");
            String latestMsg = retrieveLatestMessage();
            int latestMsgNumber = parseLatestMsg(latestMsg);

            //test that the number is from 1 and 6
            boolean isPossibleValue = (0 < latestMsgNumber)  && (latestMsgNumber < 7);
            Assert.assertEquals(isPossibleValue, true);
        }
    }

    @Test   //Tests including a max value number works.
    public void testRNGWithNumber() throws InterruptedException {
        for(int i=0; i<10; i++){        //Run through 10 times to make sure it is not a fluke.
            sendRNGMessage("!rng 2");

            String latestMsg = retrieveLatestMessage();
            int latestMsgNumber = parseLatestMsg(latestMsg);

            //test that the number is from 1 and 2
            boolean isPossibleValue = (0 < latestMsgNumber)  && (latestMsgNumber < 3);
            Assert.assertEquals(isPossibleValue, true);
        }
    }

    @Test
    public void testZeroNumberException() throws InterruptedException {
        sendRNGMessage("!rng 0");

        String latestMsg = retrieveLatestMessage();
        String expectedResponse = "You want a random number and you are using 0? Ok... Here is a 0!";

        Assert.assertEquals(latestMsg, expectedResponse);
    }

    @Test
    public void testNegativeNumberException() throws InterruptedException {
        sendRNGMessage("!rng -1");

        String latestMsg = retrieveLatestMessage();
        String expectedResponse = "I'm sorry. I don't know how to deal with negative numbers...";

        Assert.assertEquals(latestMsg, expectedResponse);
    }



    @Test
    public void testSendTwoNumbersException() throws InterruptedException {
        sendRNGMessage("!rng 5 41");

        String latestMsg = retrieveLatestMessage();
        String expectedResponse = "You may only choose one number for the random number generator. Example: \"!rng 10\"";

        Assert.assertEquals(latestMsg, expectedResponse);
    }

    @Test
    public void testSendStringException() throws InterruptedException {
        sendRNGMessage("!rng 5123abc");

        String latestMsg = retrieveLatestMessage();
        String expectedResponse = "You must choose a number for the random number generator.";

        Assert.assertEquals(latestMsg, expectedResponse);
    }
}
