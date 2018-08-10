package OLD.jsonConverters;

import OLD.Message.Message;

public class MessageWrapper {

    private Message message;
    private String type;

    public MessageWrapper(Message message) {
        this.message = message;
        this.type = "application";
    }

    Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
