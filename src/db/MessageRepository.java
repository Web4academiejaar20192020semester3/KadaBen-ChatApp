package db;

import java.util.ArrayList;

public interface MessageRepository {

    ArrayList<String[]> getMessages();

    // add message from userIdFrom to userIdTo
    boolean sendMessage(String userIdFrom, String userIdTo, String message);

    // get all messages between userIdOf and userIdTo
    ArrayList<String[]> getMessagesFrom(String userIdOf, String userIdTo);

}