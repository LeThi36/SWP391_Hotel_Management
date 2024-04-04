/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.RoomDAO;
import dao.ServiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Invoices;
import model.Rooms;
import model.Servicess;
import model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/addcart"})
public class AddToCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String checkIn = request.getParameter("checkIn");
        String checkOut = request.getParameter("checkOut");
        String numPeople = request.getParameter("numPeople");
        String numRoom_raw = request.getParameter("numRoom");
        String id_raw = request.getParameter("id");
        
        User u = ((User) request.getSession().getAttribute("User"));
        
        RoomDAO rdao = new RoomDAO();
        try {
            int id = Integer.parseInt(id_raw);
            int numRoom = Integer.parseInt(numRoom_raw);
            int numPerson = Integer.parseInt(numPeople);
            
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            
            Rooms room = rdao.getRoomById(id);
            
            double total = room.getPrice() * numRoom;
            
            String[] skillIds = request.getParameterValues("svId");
            List<Servicess> listService = new ArrayList<>();
            if (skillIds != null && skillIds.length != 0) {
                for (String skillId : skillIds) {
                    int serviceId = Integer.parseInt(skillId);
                    Servicess servicess = new ServiceDAO().getServiceById(serviceId);
                    listService.add(servicess);
                }
            }else {
                listService = room.getListServiceInListType();
                for (Servicess servicess : listService) {
                    total *= 0.95;
                }
                listService.clear();
            }
            
            List<Invoices> roomCart = (List<Invoices>) request.getSession().getAttribute("roomCart");
            Invoices invoices = new Invoices();
            invoices.setInID(roomCart.size() + 1);
            invoices.setRoomID(id);
            invoices.setNumberPerson(numPerson);
            invoices.setNumberRoom(numRoom);
            invoices.setReservationStatus(-1);
            invoices.setUserID(u.getUserId());
            invoices.setCheckInDate(formater.parse(checkIn));
            invoices.setCheckOutDate(formater.parse(checkOut));
            invoices.setTotal(total);
            invoices.setListService(listService);
            roomCart.add(invoices);
            request.getSession().setAttribute("roomCart", roomCart);
            
        } catch (Exception e) {
            System.out.println("ConfirmBookingController: " + e.getMessage());
        }
        
        response.sendRedirect("home");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        List<Invoices> roomCart = (List<Invoices>) request.getSession().getAttribute("roomCart");
        for (Invoices invoices : roomCart) {
            if (id.equalsIgnoreCase(invoices.getInID() + "")) {
                roomCart.remove(invoices);
            }
        }
        response.sendRedirect("home");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
