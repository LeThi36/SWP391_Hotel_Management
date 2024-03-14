package model;

import dao.BedDAO;
import dao.ServiceDAO;
import java.util.List;

public class Rooms {
    private int RID;
    private String name;
    private double price;
    private int Size;
    private int Capacity;
    private String Img;
    private int Status;
    private String detail;
    private int BID; 
    
    List<Servicess> listService;

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
    
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<Servicess> getListService() {
        return listService;
    }

    public void setListService(List<Servicess> listService) {
        this.listService = listService;
    }

    public List<Servicess> getListServiceByRoomId() {
        return new ServiceDAO().getServicesByRoomId(RID);
    }

    public String listServiceInString() {
        List<Servicess> list = getListServiceByRoomId();
        int size = list.size();
        int count = 0;
        String listServiceString = "";
        for (Servicess servicess : list) {

            listServiceString+= servicess.getServiceName();
            count++;
            if(count != size) {
                listServiceString += " ,";
            }
        }
        return listServiceString;
    }


    @Override
    public String toString() {
        return "Rooms{" + "RID=" + RID + ", name=" + name + ", price=" + price + ", Size=" + Size + ", Capacity=" + Capacity + ", Img=" + Img + ", Status=" + Status + ", BID=" + BID + '}';
    }

    
    
    
    
}
