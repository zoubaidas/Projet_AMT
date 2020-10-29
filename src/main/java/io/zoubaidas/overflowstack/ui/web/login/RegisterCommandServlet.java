package io.zoubaidas.overflowstack.ui.web.login;

import io.zoubaidas.overflowstack.application.ServiceRegistry;
import io.zoubaidas.overflowstack.application.user.UserDTO;
import io.zoubaidas.overflowstack.application.user.signinup.LoginAndRegisterFacade;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginCommand;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginFailedException;
import io.zoubaidas.overflowstack.application.user.signinup.register.RegisterCommand;
import io.zoubaidas.overflowstack.application.user.signinup.register.RegistrationFailedException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterCommandServlet", urlPatterns = "/register.do")
public class RegisterCommandServlet extends HttpServlet {

    LoginAndRegisterFacade loginAndRegisterFacade = ServiceRegistry.getLoginAndRegisterFacade();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RegisterCommand command = RegisterCommand.builder()
                    .username(request.getParameter("username"))
                    .password(request.getParameter("password"))
                    .firstName(request.getParameter("firstName"))
                    .email(request.getParameter("email"))
                    .lastName(request.getParameter("lastName"))
                    .build();
            try {
                UserDTO user = loginAndRegisterFacade.register(command);
                request.getSession().setAttribute("currentUser", user);
                String targetUrl = "/questions";
                response.sendRedirect(request.getContextPath() + targetUrl);
                return;
            } catch (RegistrationFailedException e) {
                request.getSession().setAttribute("errors", List.of(e.getMessage()));
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
        }
    }
