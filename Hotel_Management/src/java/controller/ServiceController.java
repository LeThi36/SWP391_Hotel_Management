/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.ServiceDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Servicess;

/**
 *
 * @author lvhn1
 */
@WebServlet(name="ServiceController", urlPatterns={"/service"})
public class ServiceController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");

        List<Servicess> servicesList = new ServiceDAO().getServices();

        request.setAttribute("serviceList", servicesList);

        if (action != null) {
            switch (action) {
                case "add":
                    addService(request, response);
                    return;
                case "update":
                    updateService(request, response);
                    return;
                default:
                    // Handle unknown actions
                    break;
            }
        }

        // Forward the request to the room list JSP page
        request.getRequestDispatcher("service-list.jsp").forward(request, response);
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

    private void addService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String serviceName = request.getParameter("serviceName");
        String icon = request.getParameter("icon");
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        // Create a new service object
        Servicess newService = new Servicess(serviceName, status, icon, description);

        // Add the service to the database
        boolean success = new ServiceDAO().addService(newService);

        // Redirect to the service list page with success/failure parameter
        if (success) {
            response.sendRedirect("service?success");
            return;
        } else {
            response.sendRedirect("service?fail");
            return;
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        int seID = Integer.parseInt(request.getParameter("seID"));
        String serviceName = request.getParameter("serviceName");
        String icon = request.getParameter("icon");
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        // Create a new service object
        Servicess updatedService = new Servicess(seID, serviceName, status, icon, description);

        // Update the service in the database
        boolean success = new ServiceDAO().updateService(updatedService);

        // Redirect to the service list page with success/failure parameter
        if (success) {
            response.sendRedirect("service?success");
            return;
        } else {
            response.sendRedirect("service?fail");
            return;
        }
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