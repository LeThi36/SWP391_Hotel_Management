/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoices;

/**
 *
 * @author Admin
 */
public class InvoicesDAO extends DAL.DBContext {

    public void createNewInvoice(Invoices invoice) {
        String insertQuery = "INSERT INTO INVOICES (UserID, RoomID, CheckInDate, CheckOutDate, ReservationStatus, "
                + "NumberPerson, NumberRooms, Note, transactionCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
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

        try ( PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            preparedStatement.setString(1, transactionCode);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("updateInvoiceStatusByTransactionCode: " + e.getMessage());
            return false;
        }
    }

    public List<Invoices> getAllInvoices() {
        List<Invoices> invoicesList = new ArrayList<>();

        String selectQuery = "SELECT * FROM INVOICES";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Invoices invoice = new Invoices();
                invoice.setInID(resultSet.getInt("InID"));
                invoice.setUserID(resultSet.getInt("UserID"));
                invoice.setRoomID(resultSet.getInt("RoomID"));
                invoice.setCheckInDate(resultSet.getDate("CheckInDate"));
                invoice.setCheckOutDate(resultSet.getDate("CheckOutDate"));
                invoice.setReservationStatus(resultSet.getInt("ReservationStatus"));
                invoice.setNumberPerson(resultSet.getInt("NumberPerson"));
                invoice.setNumberRoom(resultSet.getInt("NumberRooms"));
                invoice.setNote(resultSet.getString("Note"));
                invoice.setTransactionCode(resultSet.getString("transactionCode"));

                invoicesList.add(invoice);
            }
        } catch (SQLException ex) {
            System.out.println("getAllInvoices: " + ex.getMessage());
        }

        return invoicesList;
    }

    public void insertDetail(String[] skillIds, String transactionCode) {
        String sql = "Insert into InvoiceDetails values ";
        if (skillIds != null && skillIds.length != 0) {
            int inId = this.getInvoiceByTransactionCode(transactionCode);
            System.out.println(inId);
            for (String skillId : skillIds) {
                sql += "(" + inId + "," + skillId + "),";
            }
            sql = sql.substring(0, sql.length() - 1);
            System.out.println(sql);
        } else {
            return;
        }
        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("insertDetail: " + ex.getMessage());
        }

    }

    public int getInvoiceByTransactionCode(String transactionCode) {
        String sql = "select [InID] from INVOICES where transactionCode = ?";
        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, transactionCode);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("getInvoiceByTransactionCode: " + ex.getMessage());
        }
        return -1;
    }

    public boolean updateInvoiceStatusById(int invoiceId, int status) {
        String updateQuery = "UPDATE INVOICES SET ReservationStatus = ? WHERE InID = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, invoiceId);

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println("updateInvoiceStatusById: " + e.getMessage());
            return false;
        }
    }

}
