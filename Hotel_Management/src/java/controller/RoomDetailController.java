/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.FeedbackDAO;
import dao.RoomDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Feedback;
import model.Rooms;

/**
 *
 * @author Admin
 */
@WebServlet(name="RoomDetailController", urlPatterns={"/roomdetail"})
public class RoomDetailController extends HttpServlet {
   
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
            out.println("<title>Servlet RoomDetailController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoomDetailController at " + request.getContextPath () + "</h1>");
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
        
        String checkInDate = request.getParameter("checkInDate");
        String checkOutDate = request.getParameter("checkOutDate");
        String numPeople = request.getParameter("numPeople");
        String numRoom = request.getParameter("numRoom");
        //get the room id
        String id_raw = request.getParameter("id");
        
        //initial dao
        RoomDAO rdao = new RoomDAO();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        if(checkInDate == null ||  checkInDate.isEmpty()) {
            checkInDate = format.format(new Date());
            checkOutDate = format.format(new Date());
        }
        
        
        List<Feedback> listFeedback = new FeedbackDAO().getFeedbackByRoom(id_raw);
        
        
        try {
            int id = Integer.parseInt(id_raw);
            Rooms room = rdao.getRoomById(id, checkInDate, checkOutDate, "0");
            request.setAttribute("room", room);
        } catch (Exception e) {
            System.out.println("RoomDetailController: " +e.getMessage());
        }
        request.setAttribute("checkInDate", checkInDate);
        request.setAttribute("checkOutDate", checkOutDate);
        request.setAttribute("numPeople", numPeople);
        request.setAttribute("numRoom", numRoom);
        request.setAttribute("listFeedback", listFeedback);
        request.getRequestDispatcher("roomdetail.jsp").forward(request, response);
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
