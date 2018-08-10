package OLD.Message;

public class SystemMessage extends Message {

    private SystemResponse response;

    public SystemMessage(SystemResponse response)
    {
        super(null);
        this.response = response;
    }

    public enum SystemResponse {ACK, DENY, GAMEOVER, DENYLOGIN, ACKLOGIN, CONNECTED_STARTGAME}

    public static SystemMessage rejectUserNameMessage() {
        return new SystemMessage(SystemResponse.DENYLOGIN);
    }

    public static SystemMessage acceptUserNameMessage() {
        return new SystemMessage(SystemResponse.ACKLOGIN);
    }

    public static SystemMessage denyMessage() {
        return new SystemMessage(SystemResponse.DENY);
    }

    public static SystemMessage gameHasBegun() {
        return new SystemMessage(SystemResponse.CONNECTED_STARTGAME);
    }

    @Override
    public MessageType getMessageType()
    {
        return MessageType.SYSTEM;
    }

}

