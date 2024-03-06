/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

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

    // Constructors, getters, setters, and other methods

    public String getTransactionCode() {
        return transactionCode;
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

    public Date getCheckInDate() {
        return CheckInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        CheckInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return CheckOutDate;
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

    @Override
    public String toString() {
        return "Invoices{" + "InID=" + InID + ", UserID=" + UserID + ", RoomID=" + RoomID + ", CheckInDate=" + CheckInDate + ", CheckOutDate=" + CheckOutDate + ", ReservationStatus=" + ReservationStatus + ", numberPerson=" + numberPerson + ", numberRoom=" + numberRoom + ", note=" + note + ", transactionCode=" + transactionCode + '}';
    }

  
    
    
}
