@@ -0,0 +1,96 @@
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Rooms;

/**
 *
 * @author lvhn1
 */
@WebServlet(name="RoomController", urlPatterns={"/room"})
public class RoomController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Instantiate DAO for accessing rooms
        RoomDAO roomsDAO = new RoomDAO();

        // Retrieve all rooms
        List<Rooms> roomList = roomsDAO.getAllRooms();

        // Set rooms attribute to be accessed in JSP
        request.setAttribute("roomList", roomList);

        // Check if an action parameter is present in the request
        String action = request.getParameter("action");

        if (action != null) {
            // Perform actions based on the provided action parameter
            switch (action) {
                case "add":
                    break;
                case "update":
                    break;
                // Add more cases for other actions if needed
                default:
                    // Handle unknown actions
                    break;
            }
        }

        // Forward the request to the room list JSP page
        request.getRequestDispatcher("room-list.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}