package controller;

import domain.JSon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersGet extends AsyncRequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return JSon.usersToJSON(getPersonService().getPersons());
    }
}
