package io.zoubaidas.overflowstack.ui.web.question;

import io.zoubaidas.overflowstack.application.ServiceRegistry;
import io.zoubaidas.overflowstack.application.question.AskQuestionCommand;
import io.zoubaidas.overflowstack.application.question.QuestionDTO;
import io.zoubaidas.overflowstack.application.question.QuestionFacade;
import io.zoubaidas.overflowstack.application.user.UserDTO;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginCommand;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginFailedException;
import io.zoubaidas.overflowstack.domain.question.QuestionId;
import io.zoubaidas.overflowstack.domain.user.UserId;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddQuestionCommandServlet", urlPatterns = "question.do")
public class AddQuestionCommandServlet extends HttpServlet {
    QuestionFacade questionFacade = ServiceRegistry.getQuestionFacade();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AskQuestionCommand command = AskQuestionCommand.builder()
                .title(request.getParameter("title"))
                .body(request.getParameter("body"))
                .build();
        UserDTO author = (UserDTO) request.getSession().getAttribute("currentUser");
        questionFacade.submitQuestion(command, author.getId());
        String targetUrl = "/questions";
        response.sendRedirect(targetUrl);
    }
}
