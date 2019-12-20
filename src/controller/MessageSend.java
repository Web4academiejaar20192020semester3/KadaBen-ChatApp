package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MessageSend extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String from = person.getUserId();

        String to = request.getParameter("to");
        String msg = request.getParameter("msg");
        System.out.println("Message from: "+from+", to: "+to+". Contents: "+msg);

        getPersonService().sendMessage(from, to, msg);
        return "{}";
    }
}
