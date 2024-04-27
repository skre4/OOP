package servlets;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/web")
public class web extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        ServletContext servletContext = getServletContext();
        String name = request.getParameter("name");
        System.out.println(request.getParameter("name"));
        String path = "";
        switch (name)
        {
            case "about":
            {
                path = "/views/about.jsp";
                break;
            }
            case "contact":
            {
                path = "/views/contact.jsp";
                break;
            }
            case "back":
            {
                path = "/views/back.jsp";
                break;
            }
            case "services":
            {
                path = "/views/services.jsp";
                break;
            }
            default:
            {
                path = "/index.html";
                break;
            }
        }
// writer.print(request.getRequestURI());
        RequestDispatcher requestDispatcher =
                servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
    }