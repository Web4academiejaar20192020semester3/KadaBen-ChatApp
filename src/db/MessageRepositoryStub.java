package db;

import java.util.ArrayList;

public class MessageRepositoryStub implements MessageRepository {

    private ArrayList<String[]> messages;
    //string[0] = from
    //string[1] = to
    //string[2] = msg

    public MessageRepositoryStub() {
        this.messages = new ArrayList<>();
    }

    @Override
    public ArrayList<String[]> getMessages() {
        return this.messages;
    }

    @Override
    public boolean sendMessage(String userIdFrom, String userIdTo, String message) {
        if (userIdFrom == null || userIdFrom.trim().isEmpty()) throw new DbException("please fill in a valid from");
        if (userIdTo == null || userIdTo.trim().isEmpty()) throw new DbException("please fill in a valid to");
        if (message == null || message.trim().isEmpty()) throw new DbException("please fill in a valid msg");
        return getMessages().add(new String[] {userIdFrom, userIdTo, message});
    }

    @Override
    public ArrayList<String[]> getMessagesFrom(String userIdOf, String userIdTo) {
        ArrayList<String[]> result = new ArrayList<>();
        //todo fix  meerdere convos

        for (String[] conversation : getMessages()) {
            if (conversation[0].equals(userIdOf) && conversation[1].equals(userIdTo)) {
                result.add(conversation);
            }
            else if (conversation[0].equals(userIdTo) && conversation[1].equals(userIdOf)) {
                result.add(conversation);
            }
        }

        return result;
    }
}
