package Game;

import Message.MessageFactory;
import Message.MessageHandler;
import Game.Player;
import Game.Game;
import Message.SystemMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class GameHandler{
    public Game game;

    public Player player1;
    public Player player2;

    public Gameboard player1Gameboard;
    public Gameboard player2Gameboard;
    public Gameboard gameboard;
    public GuessesByPlayer guessesBoard;
    public Fleet fleet;
    public ArrayList<Player> gameWaitingQueue = new ArrayList<Player>();
    public ArrayList<Game> activeGames = new ArrayList<Game>();
    public int gameID = 0;


    public Fleet player1Fleet;
    public Fleet player2Fleet;

    public GuessesByPlayer player1Guesses;
    public GuessesByPlayer player2Guesses;

    //get message from clients
    public void addNewPlayerToGameWaitingQueue(Player player) {
        gameboard = new Gameboard(Gameboard.createNewEmptyGameboard());
        guessesBoard = new GuessesByPlayer(GuessesByPlayer.createNewEmptyGuessesBoard());
        fleet = new Fleet();
        player = new Player(player.getUsername(), gameboard, guessesBoard, fleet, false);
        gameWaitingQueue.add(player);
        if(enoughPlayersReady()){
            startNewGame();
        }
    }

    public boolean enoughPlayersReady() {
       if (gameWaitingQueue.size() >= 2) {
           return true;
       } else
       {
           return false;
       }
    }

    public void startNewGame() {
        player1 = gameWaitingQueue.get(0);
        player2 = gameWaitingQueue.get(1);
        removePlayersFromQueue(gameWaitingQueue);
        Game game = new Game(player1, player2, gameID);
        gameID++;
        activeGames.add(game);
        sendStartGameMessage();
    }

    public static void sendStartGameMessage(){
        MessageHandler.sendMessage(MessageFactory.sendStartGameMessage());
    }

    public static void handleSystemMessage(){
        
    }

    public void removePlayersFromQueue(ArrayList<Player> listOfPlayers) {
        listOfPlayers.remove(0);
        listOfPlayers.remove(1);
    }

    //call to MessageHandler to parse message
        //if a valid message
            //call method to handle username validations, creating new player, putting them in a queue, potentially matching them with another player and creating a new game/starting a new game
            //call a method to 
            //call method to handle guesses
        //else if not a valid message


}
