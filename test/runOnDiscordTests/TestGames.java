package runOnDiscordTests;

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
        Assert.assertEquals(false, guild.getTextChannels());
        TicTacToe game;
        //Assert.assertEquals(true, game.startGame());
        int[][] board = new int[3][3];
        if (board[3][3] == 0){
            throw new RuntimeException("That spot is occupied.");
        }
    }

    @Test
    public void testRNG(){
        SendClientMessage sendMessage = new SendClientMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!rng 10");
        String rngMessage = sendMessage.getMessage().getContentRaw();
        Assert.assertEquals(rngMessage, "!rng 10");
        double random = Math.floor(Math.random() * 10) +1;
        sendMessage.sendMessageToDiscord(clientAccount, "The random number generator generates " + random + ".");
    }
}
