package io.zoubaidas.overflowstack.ui.web.quetions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionsPageServlet", urlPatterns = "/QuestionsPage" )
public class QuestionsPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Questions Page</h3>");
        out.println("<h3>Ask new question</h3>");
        out.println("<h3>See recent questions</h3>");
    }
}
