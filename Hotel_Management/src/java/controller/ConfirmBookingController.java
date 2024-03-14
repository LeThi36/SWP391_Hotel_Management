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
import java.util.ArrayList;
import java.util.List;
import model.Rooms;
import model.Servicess;
import model.User;


@WebServlet(name = "ConfirmBookingController", urlPatterns = {"/confirmbooking"})
public class ConfirmBookingController extends HttpServlet {

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
            out.println("<title>Servlet ConfirmBookingController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConfirmBookingController at " + request.getContextPath() + "</h1>");
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

        String[] skillIds = request.getParameterValues("svId");
        List<Servicess> listService = new ArrayList<>();
        if(skillIds != null && skillIds.length != 0) {
            for (String skillId : skillIds) {
                int serviceId = Integer.parseInt(skillId);
                Servicess servicess = new ServiceDAO().getServiceById(serviceId);
                listService.add(servicess);
            }
        }
        RoomDAO rdao = new RoomDAO();
        try {
            int id = Integer.parseInt(id_raw);
            Rooms room = rdao.getRoomById(id);
            request.setAttribute("room", room);
            System.out.println(room.getPrice());
        } catch (Exception e) {
            System.out.println("ConfirmBookingController: " + e.getMessage());
        }
        
        User u = ((User) request.getSession().getAttribute("User"));
        
        request.setAttribute("checkIn", checkIn);
        request.setAttribute("checkOut", checkOut);
        request.setAttribute("numPeople", numPeople);
        request.setAttribute("numRoom", numRoom_raw);
        request.setAttribute("email", u.getEmail());
        request.setAttribute("phone", u.getPhone());
        
        request.getRequestDispatcher("bookingroom.jsp").forward(request, response);
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
        processRequest(request, response);
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
