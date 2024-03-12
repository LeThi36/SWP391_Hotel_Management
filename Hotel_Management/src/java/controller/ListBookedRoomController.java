/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.RoomDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Rooms;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name="ListBookedRoomController", urlPatterns={"/listbooked"})
public class ListBookedRoomController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListBookedRoomController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListBookedRoomController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //initial DAO object
        RoomDAO rdao = new RoomDAO();
        
        
        //Get page index
        String index_raw = request.getParameter("index");
        int index;
        if(index_raw == null) {
            index = 1;
        }
        else index = Integer.parseInt(index_raw);
        
        String email = ((User) request.getSession().getAttribute("User")).getEmail();
        User user = new UserDAO().readUserByUsername(email);
        
        //get end page
        int totalRoom = rdao.getNumberOfRooms(user.getUserId());
        int endPage = totalRoom % 6 == 0 ? totalRoom / 6 : totalRoom / 6 + 1;
        
        //Get room by paging
        List<Rooms> roomList = rdao.getRoomsForPage(index, 6, user.getUserId());
        
        
        //request to view
        request.setAttribute("index", index);
        request.setAttribute("endPage", endPage);
        
        if(request.getAttribute("msg") != null) {
            request.setAttribute("msg", request.getAttribute("msg"));
        }
        
        request.setAttribute("feedback", request.getAttribute("feedback"));
        
        request.setAttribute("roomList", roomList);
        request.getRequestDispatcher("bookedroom.jsp").forward(request, response);
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
