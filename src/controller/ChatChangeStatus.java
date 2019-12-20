package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChatChangeStatus extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String status = request.getParameter("status");
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        person.setStatus(status);
        System.out.println(status);
        return "{}";
    }
}
