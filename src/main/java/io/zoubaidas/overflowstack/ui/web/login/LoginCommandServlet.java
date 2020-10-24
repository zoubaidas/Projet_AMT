package io.zoubaidas.overflowstack.ui.web.login;

import io.zoubaidas.overflowstack.application.user.login.LoginCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginCommandServlet", urlPatterns = "/Login")
public class LoginCommandServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginCommand command = LoginCommand.builder()
                .email(request.getParameter("Username"))
                .password(request.getParameter("Password"))
                .build();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
