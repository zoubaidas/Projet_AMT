package io.zoubaidas.overflowstack.ui.web.quetions;

import io.zoubaidas.overflowstack.application.ServiceRegistry;
import io.zoubaidas.overflowstack.application.question.QuestionDTO;
import io.zoubaidas.overflowstack.application.question.QuestionFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "QuestionsPageServlet", urlPatterns = "/questions")
public class QuestionsQueryServlet extends HttpServlet {
    private QuestionFacade questionFacade = ServiceRegistry.getQuestionFacade();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<QuestionDTO> questionsDTO = questionFacade.listQuestions();
        request.setAttribute("questions", questionsDTO);
        request.getRequestDispatcher("/WEB-INF/views/questions.jsp").forward(request, response);
    }
}
