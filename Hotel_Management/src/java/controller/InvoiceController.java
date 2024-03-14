package controller;

import dao.InvoicesDAO;
import dao.RoomDAO;
import dao.ServiceDAO;
import dao.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import model.Invoices;


@WebServlet(name = "InvoiceController", urlPatterns = {"/invoice"})
public class InvoiceController extends HttpServlet {

    private InvoicesDAO invoicesDAO;

    public void init() {
        invoicesDAO = new InvoicesDAO();
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
                listInvoices(request, response);
                break;
            case "update":
                updateInvoiceStatus(request, response);
                break;
            case "add":
                addInvoice(request, response);
                break;
            default:
                listInvoices(request, response);
        }
    }

    private void listInvoices(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Invoices> invoiceList = invoicesDAO.getAllInvoices();
        request.setAttribute("invoicesList", invoiceList);
        request.setAttribute("listUser", new UserDAO().readAllUsers());
        request.setAttribute("listRoom", new RoomDAO().getAllRooms());
        request.setAttribute("listService", new ServiceDAO().getServices());
        request.getRequestDispatcher("invoice-list.jsp").forward(request, response);
    }

    private void updateInvoiceStatus(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            boolean updated = invoicesDAO.updateInvoiceStatusById(Integer.parseInt(id), 0);

            if (updated) {
                response.sendRedirect("invoice?action=list&success");
            } else {
                response.sendRedirect("invoice?action=list&fail");
            }
        } else {
            response.sendRedirect("invoice?action=list&fail");
        }
    }

    private void addInvoice(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from request
        int userId = Integer.parseInt(request.getParameter("userId"));
        int roomId = Integer.parseInt(request.getParameter("roomId"));
        Date checkInDate = Date.valueOf(request.getParameter("checkInDate"));
        Date checkOutDate = Date.valueOf(request.getParameter("checkOutDate"));
        int numberPerson = Integer.parseInt(request.getParameter("numberPerson"));
        int numberRoom = Integer.parseInt(request.getParameter("numberRoom"));
        String note = request.getParameter("note");

        // Create a new Invoices object with retrieved parameters
        Invoices invoice = new Invoices();
        invoice.setUserID(userId);
        invoice.setRoomID(roomId);
        invoice.setCheckInDate(checkInDate);
        invoice.setCheckOutDate(checkOutDate);
        invoice.setReservationStatus(0);
        invoice.setNumberPerson(numberPerson);
        invoice.setNumberRoom(numberRoom);
        invoice.setNote(note);
        invoice.setTransactionCode(null);

        // Call DAO method to add the new invoice
        invoicesDAO.createNewInvoice(invoice);

        // Redirect back to the invoice list page
        response.sendRedirect("invoice?action=list");
    }

}
