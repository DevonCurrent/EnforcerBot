package runOnDiscordTests;

import net.dv8tion.jda.core.JDA;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import testResources.SendClientMessage;


public class TestGames {
    @Test
    public void testTicTacToe(){
        JDA guild = null;
        Assert.assertEquals(false, guild.getTextChannels());
        TicTacToe game;
        Assert.assertEquals(true, game.startGame());
        int x;
        int y;
        char board[][];
        if (board[x-1][y-1] == false){
            throw new RuntimeException("That spot is occupied.");
        }
    }

    @Test
    public void testRNG(){
        SendClientMessage sendMessage = new SendClientMessage();
        sendMessage.sendMessageToDiscord(clientAccount, "!rng 10");
        String rngMessage = rawContent;
        Assert.assertEquals(rngMessage, "!rng 10");
        double random = Math.floor(Math.random() * 10) +1;
        sendMessage.sendMessageToDiscord(clientAccount, "The random number generator generates " + random + ".");
    }
}
