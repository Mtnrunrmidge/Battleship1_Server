public class GameHandler {
    public Game game;

    public Player player1;
    public Player player2;

    public Gameboard player1Gameboard;
    public Gameboard player2Gameboard;

    public Fleet player1Fleet;
    public Fleet player2Fleet;

    public GuessesByPlayer player1Guesses;
    public GuessesByPlayer player2Guesses;

    //get message from clients
    //call to MessageHandler to parse message
        //if a valid message
            //call method to handle username validations, creating new player, putting them in a queue, potentially matching them with another player and creating a new game/starting a new game
            //call a method to 
            //call method to handle guesses
        //else if not a valid message


}
