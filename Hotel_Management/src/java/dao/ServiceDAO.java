package dao;

import DAL.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Servicess;

public class ServiceDAO extends DBContext {

    public List<Servicess> getTopServices(int count) {
        List<Servicess> serviceList = new ArrayList<>();

        try {
            String query = "SELECT TOP (?) * FROM Servicess";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Servicess service = Servicess.createFromResultSet(resultSet);
                serviceList.add(service);
            }

        } catch (SQLException e) {
            System.out.println("getTopServices: " + e.getMessage());
        }

        return serviceList;
    }

    public List<Servicess> getServicesByRoomId(int roomId) {
        List<Servicess> serviceList = new ArrayList<>();

        try {
            String query = "SELECT S.* FROM Servicess S "
                    + "JOIN RoomServices RS ON S.SeID = RS.SeID "
                    + "WHERE RS.RID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, roomId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Servicess service = Servicess.createFromResultSet(resultSet);
                serviceList.add(service);
            }

        } catch (SQLException e) {
            System.out.println("getServicesByRoomId: " + e.getMessage());
        }

        return serviceList;
    }

    public List<Servicess> getServices() {
        List<Servicess> serviceList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Servicess";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Servicess service = Servicess.createFromResultSet(resultSet);
                serviceList.add(service);
            }

        } catch (SQLException e) {
            System.out.println("getServicesByRoomId: " + e.getMessage());
        }

        return serviceList;
    }

    public boolean updateService(Servicess service) {
        try {
            String query = "UPDATE Servicess SET ServiceName = ?, Status = ?, Icon = ?, Description = ? WHERE SeID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getStatus());
            preparedStatement.setString(3, service.getIcon());
            preparedStatement.setString(4, service.getDescription());
            preparedStatement.setInt(5, service.getSeID());

            int affectedRows = preparedStatement.executeUpdate();

            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("updateService: " + e.getMessage());
            return false;
        }
    }

    public Servicess getServiceById(int serviceId) {
        Servicess service = null;
        try {
            String query = "SELECT * FROM Servicess WHERE SeID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, serviceId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                service = Servicess.createFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("getServiceById: " + e.getMessage());
        }
        return service;
    }

    public boolean addService(Servicess service) {
        try {
            String query = "INSERT INTO Servicess (ServiceName, Status, Icon, Description) "
                    + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setInt(2, service.getStatus());
            preparedStatement.setString(3, service.getIcon());
            preparedStatement.setString(4, service.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("addService: " + e.getMessage());
            return false;
        }
    }
}
