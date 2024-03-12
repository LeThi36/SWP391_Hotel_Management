package model;

import java.util.Date;

public class Invoices {
    private int InID;
    private int UserID; // Foreign key referencing Users(UserID)
    private int RoomID; // Foreign key referencing Rooms(RID)
    private Date CheckInDate;
    private Date CheckOutDate;
    private int ReservationStatus;

    // Constructors, getters, setters, and other methods

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
}
