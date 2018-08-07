public class GuessesByPlayer
{
    private int [][] guessesByPlayer;
    private final static int BOARDSIZE = 10;

    public GuessesByPlayer(int[][] guessesByPlayer)
    {
        this.guessesByPlayer = guessesByPlayer;
    }

    public int[][] getGuessesByPlayer()
    {
        return guessesByPlayer;
    }

    public void setGuessesByPlayer(int[][] guessesByPlayer)
    {
        this.guessesByPlayer = guessesByPlayer;
    }

    public static void toString(int[][] board) {

        if (board != null) {
            for (int row = 0; row < BOARDSIZE; row++) {
                for (int column = 0; column < BOARDSIZE; column++) {
                    System.out.print(board[row][column] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Null board");
        }
    }
}
