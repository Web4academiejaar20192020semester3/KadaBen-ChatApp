package controller;

import domain.Person;
import domain.PersonService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChatAddFriend extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        Person newFriend = getPersonService().getPerson(email);
        getPersonService().getPerson(person.getUserId()).addFriend(newFriend);
        getPersonService().getPerson(newFriend.getUserId()).addFriend(person);
        return "{}";
    }
}
