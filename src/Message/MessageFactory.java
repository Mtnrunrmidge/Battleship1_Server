package Message;

public class MessageFactory {

    public static SystemMessage sendRejectedUserNameMessage(){

        return SystemMessage.rejectUserNameMessage();
    }

    public static SystemMessage sendAcceptedUserNameMessage(){

        return SystemMessage.acceptUserNameMessage();
    }

    public static SystemMessage sendDenyMessage(){

        return SystemMessage.denyMessage();
    }

    public static SystemMessage sendStartGameMessage(){

        return SystemMessage.gameHasBegun();
    }


    //client sends to server


    // result sent from server to the attacker


    // Game.Game message to the attackee, board to ensure integrity


    // ready to play signal from client to server


    // start game signal from server to clients
}
