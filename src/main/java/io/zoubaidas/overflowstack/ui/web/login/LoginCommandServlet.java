package io.zoubaidas.overflowstack.ui.web.login;

import io.zoubaidas.overflowstack.application.ServiceRegistry;
import io.zoubaidas.overflowstack.application.user.UserDTO;
import io.zoubaidas.overflowstack.application.user.signinup.LoginAndRegisterFacade;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginCommand;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginFailedException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginCommandServlet", urlPatterns = "/login.do")
public class LoginCommandServlet extends HttpServlet {
    ServiceRegistry serviceRegistry = new ServiceRegistry();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginAndRegisterFacade identityManagementFacade = serviceRegistry.getLoginAndRegisterFacade();

        LoginCommand command = LoginCommand.builder()
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .build();

        try {

            UserDTO user = identityManagementFacade.login(command);
            request.getSession().setAttribute("currentUser", user);
            String targetUrl = "/questions";
            response.sendRedirect(targetUrl);
            return;
        } catch (LoginFailedException e) {
            request.getSession().setAttribute("errors", List.of(e.getMessage()));
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
    }

}
