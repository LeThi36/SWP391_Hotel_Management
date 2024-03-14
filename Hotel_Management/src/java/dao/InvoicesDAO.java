package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoices;

public class InvoicesDAO extends DAL.DBContext{
    public void createNewInvoice(Invoices invoice) {
        String insertQuery = "INSERT INTO INVOICES (UserID, RoomID, CheckInDate, CheckOutDate, ReservationStatus, " +
                             "NumberPerson, NumberRooms, Note, transactionCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // Set values for the parameters using the Invoice object
            preparedStatement.setInt(1, invoice.getUserID());
            preparedStatement.setInt(2, invoice.getRoomID());
            preparedStatement.setString(3, format.format(invoice.getCheckInDate()));
            preparedStatement.setString(4, format.format(invoice.getCheckOutDate()));
            preparedStatement.setInt(5, 0);
            preparedStatement.setInt(6, invoice.getNumberPerson());
            preparedStatement.setInt(7, invoice.getNumberRoom());
            preparedStatement.setString(8, invoice.getNote());
            preparedStatement.setString(9, invoice.getTransactionCode());
            // Execute the query
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Invoice created successfully.");
            } else {
                System.out.println("Failed to create invoice.");
            }
        } catch (SQLException ex) {
            System.out.println("createNewInvoice: " + ex.getMessage());
        }
    }
    
    public boolean updateInvoiceStatusByTransactionCode(String transactionCode) {
        String updateQuery = "UPDATE INVOICES SET ReservationStatus = 1 WHERE TransactionCode = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            
            preparedStatement.setString(1, transactionCode);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("updateInvoiceStatusByTransactionCode: " + e.getMessage());
            return false;
        }
    }
}
