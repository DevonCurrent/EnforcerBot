package runOnDiscordTests;

import commands.TicTacToe.Board;
import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import org.junit.Assert;
import org.junit.Test;

public class TestGames {
    private JDA clientAccount = AccountCreator.createClientAccount();

    @Test
    public void testTicTacToe(){
        JDA guild = null;
        try {
            Assert.assertNull(guild.getTextChannels());
        }
        catch (NullPointerException NPE){
            SendMessage sendMessage = new SendMessage();
            sendMessage.sendMessageToDiscord(clientAccount, "There must not be a text channel.");
        }

        Board board = new Board(3, 3);
        if (board.isOccupied(0, 0) || board.isOccupied(0, 1) || board.isOccupied(0, 2) || board.isOccupied(1, 0) || board.isOccupied(1, 1) || board.isOccupied(1, 2) || board.isOccupied(2, 0) || board.isOccupied(2, 1) || board.isOccupied(2, 2)){
            throw new RuntimeException("That spot is occupied.");
        }
    }

    @Test
    public void testRNG(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!rng 10");
        String rngMessage = sendMessage.getMessage().getContentRaw();
        Assert.assertEquals(rngMessage, "!rng 10");
        double random = Math.floor(Math.random() * 10) + 1;
        sendMessage.sendMessageToDiscord(clientAccount, "The random number generator generates " + random + ".");
    }
}
