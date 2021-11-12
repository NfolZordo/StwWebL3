package ua.edu.chdtu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher view = req.getRequestDispatcher("static/index.html");
        view.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String emailAddress = req.getParameter("emailAddress");
        String phoneNumberCod = req.getParameter("phoneNumberCod");
        String phoneNumber = req.getParameter("phoneNumber");
        String selectJabType = req.getParameter("selectJabType");
        String createPassword = req.getParameter("createPassword");
        String repeatPassword = req.getParameter("repeatPassword");
        phoneNumber = phoneNumberCod + phoneNumber;

        if (repeatPassword.equals(createPassword)) {
            resp.getWriter().write("<h1>JSON: " + convertDataToJSON(fullName, emailAddress, phoneNumber, selectJabType, createPassword) + "</h1>");
        }
        else {resp.getWriter().write("Passwords do not match");}
    }
    private String convertDataToJSON(String fullName, String emailAddress, String phoneNumber, String selectJabType, String createPassword) {
        StringBuilder jsonData = new StringBuilder();
        jsonData.append("{");

        jsonData.append("\"fullName\": \""+fullName+"\",");
        jsonData.append("\"emailAddress\": \""+emailAddress+"\",");
        jsonData.append("\"phoneNumber\": \""+phoneNumber+"\",");
        jsonData.append("\"selectJabType\": \""+selectJabType+"\",");
        jsonData.append("\"Password\": \""+createPassword+"\"");
        jsonData.append("}");

        return jsonData.toString();
    }

}
