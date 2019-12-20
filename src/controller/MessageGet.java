package controller;

import domain.JSon;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MessageGet extends AsyncRequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String from = person.getUserId();

        String to = request.getParameter("to");

        if (getPersonService().getMessagesBetween(from, to).size() == 0) {
            return "{}";
        } else {
            return JSon.messagesToJSON(getPersonService().getMessagesBetween(from, to));
        }

    }
}
