package controller;

import db.StatusRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManageStatusServlet extends HttpServlet {

    private static final long serialVersionUTD = 1L;
    private StatusRepository statuses;

    public ManageStatusServlet(){
        super();
        this.statuses = new StatusRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("Status");
        response.getWriter().write(statuses.getStatus(status));
    }
}
