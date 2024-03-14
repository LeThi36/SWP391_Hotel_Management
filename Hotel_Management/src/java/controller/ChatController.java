package controller;

import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name="ChatController", urlPatterns={"/chat"})
public class ChatController extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String conversationId = request.getParameter("id");
        
        if (conversationId == null) {
            User userSession = (User) request.getSession().getAttribute("User");
            
            if (userSession == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            
            User user = new UserDAO().readUserByUsername(userSession.getEmail());
            
            conversationId = user.getUserId()+"";
            request.setAttribute("user", user);
        }
        
        request.setAttribute("conversationId", conversationId);
        
        request.getRequestDispatcher("chat.jsp").forward(request, response);
        
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }


}
