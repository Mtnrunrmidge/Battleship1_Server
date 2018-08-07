package Message;

import javafx.beans.binding.StringBinding;
import jsonConverters.JsonConverter;
import jsonConverters.MessageWrapper;

import java.io.*;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class MessageHandler implements Runnable, Comparable<MessageHandler> {

    private static Set<MessageHandler> connections = new ConcurrentSkipListSet<>();
    private String username;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    private MessageHandler(Socket socket) {
        this.socket = socket;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream(), "UTF-8"), true);
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(this).start();
    }

    public static MessageHandler handleConnection(Socket socket) {
        System.out.println("Connection from: " + socket.getRemoteSocketAddress());

        return new MessageHandler(socket);
    }

    public static void shutdown() {
        //GameHandler.shutdown();

        Iterator<MessageHandler> iterator = connections.iterator();
        while (iterator.hasNext()) {
            iterator.next().shutdownConnection();
            iterator.remove();
        }
    }

    private void shutdownConnection() {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {

            }
        }

        if (pw != null) {
            pw.close();
        }

        try {
            socket.close();
        } catch (IOException e) {

        }

        Iterator<MessageHandler> iterator = connections.iterator();
        while (iterator.hasNext()) {
            MessageHandler connection = iterator.next();
            if (this.equals(connection)) {
                iterator.remove();
            }
        }
    }

    private boolean processLogin() {
        boolean loginSuccess = false;
        if (br == null) {
            shutdownConnection();
            return false;
        }


        // receive and read json
        Message message = JsonConverter.readJson(jsonToString());

        if (message.getMessageType().equals(Message.MessageType.LOGIN)) {
            setUsername(message.getUsername());
        }

        if (getUsername() != null) {
            System.out.println("Adding " + getUsername() + " to clients");
            int connectionCount = connections.size();
            connections.add(this);

            // connections.contains(this)...??
            if (connections.size() <= connectionCount) {
                username = null;
            }
        }

        System.out.println(getUsername());

        if (getUsername() != null) {
          //  oos.writeObject(MessageFactory.getAckMessage());
            loginSuccess = true;

            broadcast(message, getUsername());
        } else {
           // oos.writeObject(MessageFactory.getDuplicateUsernameMessage());
            pw.flush();

            shutdownConnection();
        }
        pw.flush();

        return loginSuccess;
    }

    private static void broadcast(Message message, String username) {
        for (MessageHandler connection: connections) {
            if (username == null || !connection.getUsername().equals(username)) {
                connection.sendMessage(message);
            }
        }
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    // send the message to the user according to the username
    public void sendMessage(Message message) {
        // write and send Json
        pw.print(JsonConverter.writeJson(message));
        pw.flush();
    }

    private String jsonToString() {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageHandler that = (MessageHandler) o;
        if (username == null) {
            if (that.getUsername() != null) {
                return false;
            }
        } else if (!username.equals(that.getUsername())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((username == null) ? 0 : username.hashCode());
      return result;
    }

    @Override
    public int compareTo(MessageHandler o) {
        if (this.equals(o)) {
            return 0;
        } else if (o != null) {
            return this.getUsername().compareTo(o.getUsername());
        }

        return 0;
    }

    @Override
    public void run() {
        if (processLogin()) {
            while (!Thread.interrupted() && socket.isConnected() && !socket.isClosed()) {
                // receive and read json
                Message message = JsonConverter.readJson(jsonToString());

                if (Message.MessageType.CHAT.equals(message.getMessageType())) {
                    broadcast(message, this.getUsername());
                    sendMessage(message);
                } else if (Message.MessageType.SYSTEM.equals(message.getMessageType())) {
                    //GameHandler.handleSystemMessage((SystemMessage) message, this);
                } else if (Message.MessageType.GAME_ACTION.equals(message.getMessageType())) {
                   // GameHandler.handleActionMessage((GridStatusMessage) message, this);
                }
            }
        }
    }
}
