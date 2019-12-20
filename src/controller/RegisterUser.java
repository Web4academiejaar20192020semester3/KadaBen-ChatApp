package controller;

import domain.Person;
import domain.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRepeat = request.getParameter("passwordRepeat");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");

        if (!password.equals(passwordRepeat)) {
            throw new IllegalArgumentException("wachtwoorden komen niet overeen");
        }

        else {
            Person newPerson = new Person(email, password, firstname, lastname, age, gender, Role.LID);
            getPersonService().addPerson(newPerson);
            System.out.println((getPersonService().getPerson(email)));
        }

        return "index.jsp";

    }
}
