/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.RoomDAO;
import dao.ServiceDAO;

/**
 *
 * @author lvhn1
 */
public class RoomService {
    private int RID;
    private int SeID;

    public RoomService() {
    }

    public RoomService(int RID, int SeID) {
        this.RID = RID;
        this.SeID = SeID;
    }

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getSeID() {
        return SeID;
    }

    public void setSeID(int SeID) {
        this.SeID = SeID;
    }
    
    public Rooms getRoom() {
        return new RoomDAO().getRoomById(RID);
    }
    
    public Servicess getService() {
        return new ServiceDAO().getServiceById(SeID);
    }
    
}
