package servlets;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
@WebServlet("/form")
public class formServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("Method GETr from AddServlet");
        String[] questions = req.getParameterValues("question");
        String[] rightAnswers = {"8","moscow", "france", "6"};
        int j = 0;
        for (int i=0; i<questions.length; i++)
        {
            questions[i] = questions[i].toLowerCase(Locale.ENGLISH);
            if(questions[i].equals(rightAnswers[i]))
            {
                j++;
            }
        }
        writer.println(" Number of correct answers : " + j );
    }
}