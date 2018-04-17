package commands.TicTacToe;

    // We may need to make a few changes

import java.awt.Color;
import java.util.List;

import main.java.AccountCreator;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class TicTacToe {
    private Board game = new Board(3, 3);
    private static MessageReceivedEvent e;
    private static User starter;
    private static User opponent;
    private static String id;
    private static int row, column;
    private static User turn;

    private AccountCreator accountCreator = new AccountCreator();
    private JDA botAccount = accountCreator.createBotAccount();

    public TicTacToe(MessageReceivedEvent event) {
            e = event;
            startGame();
        }

    private void startGame() { // Keep the game progressing
        // Set Players
        starter = e.getAuthor();
        List<User> mentionedUsers = e.getMessage().getMentionedUsers();

        try {
            opponent = mentionedUsers.get(0);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            e.getChannel().sendMessage(" Please mention a person the start the game.").queue();
        }

        EmbedBuilder embedstatus = new EmbedBuilder().setColor(Color.green).addField(" Tic Tac Toe: Game Mode ON!", "Starter: " + starter.getAsMention() + "\nOpponent: " + opponent.getAsMention(), true);
        e.getChannel().sendMessage(embedstatus.build()).queue();
        turn = starter;
        e.getChannel().sendMessage("\n").queue();
        }

    public void endGame(){ //Stop the game{
        if(e.getAuthor() == starter || e.getAuthor() == opponent){
            new EmbedBuilder().setColor(Color.green).setTitle(" Tic Tac Toe: Game Mode OFF!", null).setFooter(e.getAuthor().getName() + " ended the game.", null);
            EmbedBuilder embedstatus = new EmbedBuilder().setColor(Color.green).addField(" Tic Tac Toe: Game Mode ON!", "Starter: " + starter.getAsMention() + "\nOpponent: " + opponent.getAsMention(), true);
            e.getChannel().sendMessage(embedstatus.build()).queue();
            }
        game.clearBoard();
        //botAccount.getGuild(e.getGuild()).resetTicTacToe();
    }

    public void sendInput(String[] in, MessageReceivedEvent event){	//Set the input called by TicTacToeCommand{
        try{
            switch (in[0]) {
                case "1" : row = 0; column = 0; break;
                case "2" : row = 0; column = 1; break;
                case "3" : row = 0; column = 2; break;
                case "4" : row = 1; column = 0; break;
                case "5" : row = 1; column = 1; break;
                case "6" : row = 1; column = 2; break;
                case "7" : row = 2; column = 0; break;
                case "8" : row = 2; column = 1; break;
                case "9" : row = 2; column = 2; break;
                default: throw new StringIndexOutOfBoundsException();
            }

            //Assign ID (Piece O/X name)
            if(event.getAuthor() == opponent)
                id = "O";
            else if(event.getAuthor() == starter)
                id = "X";

            //Check who's turn is it
            if(event.getAuthor() == starter || event.getAuthor() ==	 opponent) {
                if(event.getAuthor() != turn) {
                    e.getChannel().sendMessage(" It's not your turn yet!").queue();
                    return;
                }
            }

            else
                e.getChannel().sendMessage(" Do not interfere the game!").queue();


            if(game.isOccupied(row, column)) {
                game.addPiece(new Piece(id), row, column);
                //game.drawBoard();
            }
            else {
                e.getChannel().sendMessage(" The place is occupied. Use your eyes!").queue();
                return;
            }

            //Check for winner
            if(makeLine().equals("X"))	{
                e.getChannel().sendMessage("\n" + "Player " + starter.getAsMention() + " (X) Wins!").queue();
                game.clearBoard();
                //botAccount.getGuild(e.getGuild()).resetTicTacToe();
            }

            else if(makeLine().equals("O")) {
                e.getChannel().sendMessage("\n" + "Player " + opponent.getAsMention() +	 " Wins!").queue();
                game.clearBoard();
                //botAccount.getGuild(e.getGuild()).resetTicTacToe();
            }

            else if(catGame()) {
                e.getChannel().sendMessage("Cat game, no winner.").queue();
                game.clearBoard();
                //botAccount.getGuild(e.getGuild()).resetTicTacToe();
            }

            else
                switchTurn();

        }

            catch(StringIndexOutOfBoundsException | NumberFormatException es) {
                e.getChannel().sendMessage(" The 'Numbers' you enter is not valid.").queue();
            }

            catch(ArrayIndexOutOfBoundsException ea) {
                e.getChannel().sendMessage(" Invalid place!").queue();
            }
        }

    private void switchTurn() { //Switch turn between starter to opponent
        if(starter == turn)
            turn = opponent;
        else
            turn = starter;
        }

    //TicTacToe Methods
    //TODO: should use a switch
    private String makeLine(){ //Check for a line{
        Piece[][] board = game.getBoard();
        if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]))
            return board[0][0].getID();

        else if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]))
                return board[1][0].getID();

        else if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]))
            return board[2][0].getID();

        else if (board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]))
            return board[0][0].getID();

        else if (board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]))
            return board[0][1].getID();

        else if (board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]))
            return board[0][2].getID();

        else if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]))
            return board[0][0].getID();

        else if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]))
            return board[2][0].getID();

        else
            return "none";
        }


    private boolean catGame(){ //Check for cat GAME{
        Piece[][] end = game.getBoard();
        for(int i = 0; i < end.length; i ++) {
            for(int j = 0; j < end[0].length; j++)	{
                if(game.isOccupied(i,j))
                    return false;
            }
        }
        return true;
    }
}
