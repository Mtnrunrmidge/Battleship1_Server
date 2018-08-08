package Game;

import Message.MessageHandler;
import Game.Player;

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
    public Queue<Player> gameWaitingQueue;

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
        gameWaitingQueue = new Queue<Game.Player>()
        {
            @Override
            public boolean add(Game.Player player)
            {
                return false;
            }

            @Override
            public boolean offer(Game.Player player)
            {
                return false;
            }

            @Override
            public Game.Player remove()
            {
                return null;
            }

            @Override
            public Game.Player poll()
            {
                return null;
            }

            @Override
            public Game.Player element()
            {
                return null;
            }

            @Override
            public Game.Player peek()
            {
                return null;
            }

            @Override
            public int size()
            {
                return 0;
            }

            @Override
            public boolean isEmpty()
            {
                return false;
            }

            @Override
            public boolean contains(Object o)
            {
                return false;
            }

            @Override
            public Iterator<Game.Player> iterator()
            {
                return null;
            }

            @Override
            public Object[] toArray()
            {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a)
            {
                return null;
            }

            @Override
            public boolean remove(Object o)
            {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c)
            {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Game.Player> c)
            {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c)
            {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c)
            {
                return false;
            }

            @Override
            public void clear()
            {

            }
        }
    }


    //call to MessageHandler to parse message
        //if a valid message
            //call method to handle username validations, creating new player, putting them in a queue, potentially matching them with another player and creating a new game/starting a new game
            //call a method to 
            //call method to handle guesses
        //else if not a valid message


}
