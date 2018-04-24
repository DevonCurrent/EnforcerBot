package commands.TicTacToe;

// Board Sub-class
public class Board{
    private int rows;
    private int cols;
    private Piece[][] board;
    private int round;

    public Board(int r, int c) {
        rows = r;
        cols = c;
        board = new Piece[r][c];
        round = 0;
        Piece p;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                p = new Piece();
                addPiece(p, i, j);
            }
        }
    }

//    void drawBoard() {
//        EmbedBuilder embedgame = new EmbedBuilder().setColor(Color.green).setTitle(" Current Board (Round " + round + ")\n", null).setFooter(turn.getName() + " finished his/her turn.", null);
//        e.getChannel().sendMessage(embedgame.build()).queue();
//        round++;
//        StringBuilder line = new StringBuilder();
//
//        for (int i=0; i<rows; i++) {
//            for (int j=0; j<cols; j++) {
//                line.append(getEmojiPos(i, j)).append(" ");
//            }
//            line.append("\n");
//        }
//        e.getChannel().sendMessage(line.toString()).queue();
//    }

    void addPiece(Piece x, int r, int c) {
        board[r][c] = x;
    }

    Piece[][] getBoard() {
        return board;
    }

    public boolean isOccupied(int r, int c) {
        Piece p = board[r][c];
        String q = p.getID();
        return q.equals("	");
    }

    void clearBoard() {
        Piece p;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                p = new Piece();
                addPiece(p, i, j);
            }
        }
    }
}