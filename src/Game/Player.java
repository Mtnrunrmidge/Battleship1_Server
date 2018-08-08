package Game;

import java.lang.*;

public class Player {

    private Gameboard gameboard;
    private GuessesByPlayer guessesByPlayer;
    private Fleet fleet;
    private String username;
    private boolean isTurn;

    /**
     * Constructor for player object
     */
    public Player(String username, Gameboard gameboard, GuessesByPlayer guessesBoard, Fleet fleet, boolean isTurn){
        setUsername(username);
        setGameboard(gameboard);
        setGuessesByPlayerBoard(guessesBoard);
        setFleet(fleet);
        setIsTurn(isTurn);
    }

    public Player(){

    }

    //getters

    /**
     * Gets the username for the player
     * @return
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * gets the gameboard for the player
     * @return
     */
    public Gameboard getGameboard(){
        return this.gameboard;
    }

    /**
     * gets the Guesses by player board
     * @return
     */
    public GuessesByPlayer getGuessesByPlayerBoard(){
        return this.guessesByPlayer;
    }

    /**
     * Gets the fleet for the player
     * @return
     */
    public Fleet getFleet(){
        return this.fleet;
    }

    /**
     * Gets the true/false if its the player's turn.
     * @return
     */
    public boolean getIsTurn(){
        return this.isTurn;
    }


    //setters

    /**
     * Sets the username for the player
     * @param username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Game.Gameboard has the placement of ships by the player
     * @param gameboard
     */
    public void setGameboard(Gameboard gameboard){
        this.gameboard = gameboard;
    }

    /**
     * Set guesses By Game.Player to keep track of the guesses the player has made throughout the game
     * @param guessesByPlayerBoard
     */
    public void setGuessesByPlayerBoard(GuessesByPlayer guessesByPlayerBoard){
        this.guessesByPlayer = guessesByPlayerBoard;
    }

    /**
     * Sets the fleet for the player
     * @param fleet
     */
    public void setFleet(Fleet fleet){
        this.fleet = fleet;
    }

    /**
     * Sets whether or not it is the player's turn
     * @param isTurn
     */
    public void setIsTurn(boolean isTurn){
        this.isTurn = isTurn;
    }


}
