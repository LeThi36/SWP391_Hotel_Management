package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Servicess {

    private int SeID;
    private String ServiceName;
    private int Status;
    private String icon;
    private String description;

    // Constructors, getters, setters, and other methods
    public int getSeID() {
        return SeID;
    }

    public void setSeID(int seID) {
        SeID = seID;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    // New method to create a Servicess object from a ResultSet
    public static Servicess createFromResultSet(ResultSet resultSet) throws SQLException {
        Servicess service = new Servicess();
        service.setSeID(resultSet.getInt("SeID"));
        service.setServiceName(resultSet.getString("ServiceName"));
        service.setIcon(resultSet.getString("Icon"));
        service.setDescription(resultSet.getString("Description"));
        service.setStatus(resultSet.getInt("Status"));
        return service;
    }

}
