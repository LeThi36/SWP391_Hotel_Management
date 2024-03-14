/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.User;

/**
 *
 * @author lvhn1
 */
@WebServlet(name="UserController", urlPatterns={"/user"})
public class UserController extends HttpServlet {

    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // default action
        }

        switch (action) {
            case "list":
                listUsers(request, response);
                break;
            case "showForm":
                showUserForm(request, response);
                break;
            case "create":
                createUser(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateUser(request, response);
                break;
            case "ban":
                banUser(request, response);
                break;
            default:
                listUsers(request, response);
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> userList = userDAO.readAllUsers();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher("user-list.jsp").forward(request, response);
    }

    private void showUserForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String role = request.getParameter("role");
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        // Perform any validation if needed

        int userId = userDAO.createUser(role, phonenumber, password, fullName, email, gender, dob);

        if (userId > 0) {
            response.sendRedirect("user?action=list&success");
        } else {
            // Handle failure
            response.sendRedirect("user?action=list&fail");
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDAO.readUserById(userId);
        request.setAttribute("user", user);
        request.getRequestDispatcher("user-form.jsp").forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String role = request.getParameter("role");
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        // Perform any validation if needed

        User user = new User(userId, Integer.parseInt(role), password, fullName, email, phonenumber, gender, dob);
        userDAO.updateUser(user);
        response.sendRedirect("user?action=list&success");
    }

     private void banUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String role = request.getParameter("role");
        String phonenumber = request.getParameter("phonenumber");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");

        // Perform any validation if needed

        User user = new User(userId, Integer.parseInt(role), password, fullName, email, phonenumber, gender, dob);
        userDAO.updateUser(user);
        response.sendRedirect("user?action=list&success");
    }
}