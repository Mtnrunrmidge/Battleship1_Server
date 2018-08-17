package demo1.jsonConverters;

import demo1.GridStatus;
import demo1.TestGUI;
import demo1.message.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class JsonConverter {

    private static RuntimeTypeAdapterFactory<Message> messageAdapterFactory = RuntimeTypeAdapterFactory
            .of(Message.class, "type")
            .registerSubtype(LoginMessage.class, "Login")
            .registerSubtype(ResultMessage.class, "Result")
            .registerSubtype(GridStatusMessage.class, "GridStatus")
            .registerSubtype(GameActionMessage.class, "GameAction")
            .registerSubtype(ChatMessage.class, "Chat")
            .registerSubtype(SystemMessage.class, "System");

    private static Gson gson = new GsonBuilder().registerTypeAdapterFactory(messageAdapterFactory).create();

    public static String writeJson(Message message) {
        MessageWrapper mw = new MessageWrapper(message);

        String content = gson.toJson(mw);

        return content;
    }

    public static Message readJson(String jsonFile) {
        MessageWrapper mw;

        try {
            mw = gson.fromJson(jsonFile, MessageWrapper.class);
        } catch (JsonSyntaxException e) {
            throw new JsonSyntaxException("Json data corrupted.");
        }

        if (mw != null) {
            return mw.getMessage();
        } else {
            return null;
        }
    }

    public static MessageWrapper readJson2(String jsonFile) {
        MessageWrapper mw;

        try {
            mw = gson.fromJson(jsonFile, MessageWrapper.class);
        } catch (JsonSyntaxException e) {
            throw new JsonSyntaxException("Json data corrupted.");
        }

        return mw;
    }

    public static void main(String[] args) {
        GridStatus[][] gt = new GridStatus[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gt[i][j] = GridStatus.EMPTY;
            }
        }

        gt[2][5] = GridStatus.Cruiser;
        gt[2][6] = GridStatus.Cruiser;
        gt[1][2] = GridStatus.Battleship;
        gt[2][2] = GridStatus.Battleship;
        gt[3][4] = GridStatus.Carrier;
        gt[3][5] = GridStatus.Carrier;
        gt[3][6] = GridStatus.Carrier;
        gt[3][7] = GridStatus.Carrier;
        gt[3][8] = GridStatus.Carrier;
        gt[4][1] = GridStatus.Destroyer;
        gt[5][1] = GridStatus.Destroyer;
        gt[9][2] = GridStatus.Submarine;
        gt[9][3] = GridStatus.Submarine;
        GridStatus[] result = {GridStatus.HIT, GridStatus.Carrier, null};
        System.out.println(JsonConverter.writeJson(MessageFactory.getAttemptMessage("username",2, 3)));
//        System.out.println(JsonConverter.writeJson(MessageFactory.getDuplicateUsernameMessage()));
//        System.out.println(JsonConverter.writeJson(MessageFactory.getStartMessage()));
//        System.out.println(JsonConverter.writeJson(MessageFactory.getLoginMessage("Username")));
    }
}
