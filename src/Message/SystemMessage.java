package Message;

public class SystemMessage extends Message {

    private SystemResponse response;

    public SystemMessage(SystemResponse response)
    {
        super(null);
        this.response = response;
    }

    public enum SystemResponse {ACK, DENY, READY, START, GAMEOVER, DENYLOGIN, ACKLOGIN}

    public static SystemMessage rejectUserNameMessage() {
        return new SystemMessage(SystemResponse.DENYLOGIN);
    }

    public static SystemMessage acceptUserNameMessage() {
        return new SystemMessage(SystemResponse.ACKLOGIN);
    }

    public static SystemMessage denyMessage() {
        return new SystemMessage(SystemResponse.DENY);
    }

    @Override
    public MessageType getMessageType()
    {
        return MessageType.SYSTEM;
    }

}

