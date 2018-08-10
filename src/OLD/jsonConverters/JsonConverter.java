package OLD.jsonConverters;

import OLD.Message.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class JsonConverter {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

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

        return mw.getMessage();
    }
}