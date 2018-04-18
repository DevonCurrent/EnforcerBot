package runOnDiscordTests;

import commands.TicTacToe.Board;
import commands.TicTacToe.TicTacToe;
import main.java.AccountCreator;
import net.dv8tion.jda.core.JDA;
import org.junit.Assert;
import org.junit.Test;
import commands.InviteCommand.SendClientMessage;

public class TestGames {
    private AccountCreator accountCreator = new AccountCreator();
    private JDA clientAccount = accountCreator.createClientAccount();

    @Test
    public void testTicTacToe(){
        JDA guild = null;
        try {
            Assert.assertNull(guild.getTextChannels());
        }
        catch (NullPointerException NPE){
            SendClientMessage sendMessage = new SendClientMessage();
            sendMessage.sendMessageToDiscord(clientAccount, "There must not be a text channel.");
        }

        Board board = new Board(3, 3);
        if (board.isOccupied(0, 0) || board.isOccupied(0, 1) || board.isOccupied(0, 2) || board.isOccupied(1, 0) || board.isOccupied(1, 1) || board.isOccupied(1, 2) || board.isOccupied(2, 0) || board.isOccupied(2, 1) || board.isOccupied(2, 2)){
            throw new RuntimeException("That spot is occupied.");
        }
    }

    @Test
    public void testRNG(){
        SendClientMessage sendMessage = new SendClientMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!rng 10");
        String rngMessage = sendMessage.getMessage().getContentRaw();
        Assert.assertEquals(rngMessage, "!rng 10");
        double random = Math.floor(Math.random() * 10) + 1;
        sendMessage.sendMessageToDiscord(clientAccount, "The random number generator generates " + random + ".");
    }
}
