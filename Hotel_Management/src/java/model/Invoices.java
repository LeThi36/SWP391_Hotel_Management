/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.RoomDAO;
import dao.UserDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Invoices {
    private int InID;
    private int UserID; // Foreign key referencing Users(UserID)
    private int RoomID; // Foreign key referencing Rooms(RID)
    private Date CheckInDate;
    private Date CheckOutDate;
    private int ReservationStatus;
    private int numberPerson;
    private int numberRoom;
    private String note;
    private String transactionCode;
    
    private double total;
    private List<Servicess> listService;
    private boolean isEnded;
    

    // Constructors, getters, setters, and other methods

    public boolean isIsEnded() {
        return isEnded;
    }

    public void setIsEnded(boolean isEnded) {
        this.isEnded = isEnded;
    }

    
    public Date getCheckOutDateInTypeDate() {
        return this.CheckOutDate;
    }
    
    
    
    public List<Servicess> getListService() {
        return listService;
    }

    public void setListService(List<Servicess> listService) {
        this.listService = listService;
    }

    
    
    public String getTransactionCode() {
        return transactionCode;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public int getInID() {
        return InID;
    }

    public void setInID(int inID) {
        InID = inID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int roomID) {
        RoomID = roomID;
    }

    public String getCheckInDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(CheckInDate);
    }

    public void setCheckInDate(Date checkInDate) {
        CheckInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(CheckOutDate);
    }

    public void setCheckOutDate(Date checkOutDate) {
        CheckOutDate = checkOutDate;
    }

    public int getReservationStatus() {
        return ReservationStatus;
    }

    public void setReservationStatus(int reservationStatus) {
        ReservationStatus = reservationStatus;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public int getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(int numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public User getUser() {
        return new UserDAO().readUserById(UserID);
    }
    
    public Rooms getRoom() {
        return new RoomDAO().getRoomById(RoomID);
    }

    @Override
    public String toString() {
        return "Invoices{" + "InID=" + InID + ", UserID=" + UserID + ", RoomID=" + RoomID + ", CheckInDate=" + CheckInDate + ", CheckOutDate=" + CheckOutDate + ", ReservationStatus=" + ReservationStatus + ", numberPerson=" + numberPerson + ", numberRoom=" + numberRoom + ", note=" + note + ", transactionCode=" + transactionCode + '}';
    }

  
    
    
}
