package model;

import dao.BedDAO;

public class Rooms {
    private int RID;
    private String name;
    private double price;
    private int Size;
    private int Capacity;
    private String Img;
    private int Status;
    private int BID; 

    public int getRID() {
        return RID;
    }

    public void setRID(int RID) {
        this.RID = RID;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int capacity) {
        Capacity = capacity;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    public BedS getBedSById() {
        return new BedDAO().getBedById(BID);
    }

    @Override
    public String toString() {
        return "Rooms{" + "RID=" + RID + ", name=" + name + ", price=" + price + ", Size=" + Size + ", Capacity=" + Capacity + ", Img=" + Img + ", Status=" + Status + ", BID=" + BID + '}';
    }

    
    
    
    
}
