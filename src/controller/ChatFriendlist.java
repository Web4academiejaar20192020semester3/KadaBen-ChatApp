package controller;

import domain.JSon;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ChatFriendlist extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        List<Person> friends = new ArrayList<>();
        for (Person p : person.getFriends()) {
            friends.add(getPersonService().getPerson(p.getUserId()));
        }
        if (friends.size() != 0) {
            return JSon.friendsToJSON(friends);
        } else {
            return "{ \"friends\": [] }";
        }
    }
}
