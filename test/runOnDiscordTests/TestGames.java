package runOnDiscordTests;

import commands.TicTacToe.Board;
import net.dv8tion.jda.core.JDA;
import org.junit.Assert;
import org.junit.Test;

public class TestGames{

    @Test
    public void testTicTacToe() throws NullPointerException{
        JDA guild = null;
        Assert.assertNull(guild.getTextChannels());
        Board board = new Board(3, 3);
        if (board.isOccupied(0, 0) || board.isOccupied(0, 1) || board.isOccupied(0, 2) || board.isOccupied(1, 0) || board.isOccupied(1, 1) || board.isOccupied(1, 2) || board.isOccupied(2, 0) || board.isOccupied(2, 1) || board.isOccupied(2, 2)){
            throw new RuntimeException("That spot is occupied.");
        }
    }
}
