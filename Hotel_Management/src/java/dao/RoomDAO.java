package dao;

import DAL.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Rooms;

public class RoomDAO extends  DBContext{
    public List<Rooms> getAllRooms() {
        List<Rooms> roomList = new ArrayList<>();

        try {
            String query = "SELECT * FROM Rooms";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rooms room = new Rooms();
                room.setRID(resultSet.getInt("RID"));
                room.setSize(resultSet.getInt("Size"));
                room.setCapacity(resultSet.getInt("Capacity"));
                room.setImg(resultSet.getString("Img"));
                room.setStatus(resultSet.getInt("Status"));
                room.setBID(resultSet.getInt("BID"));
                roomList.add(room);
            }

        } catch (SQLException e) {
            System.out.println("getAllRooms: " + e.getMessage());
        }

        return roomList;
    }
    
    public List<Rooms> getRandomRooms(int count) {
        List<Rooms> roomList = new ArrayList<>();

        try {
            String query = "SELECT TOP (?) * FROM ROOMS ORDER BY NEWID()";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rooms room = new Rooms();
                room.setRID(resultSet.getInt("RID"));
                room.setSize(resultSet.getInt("Size"));
                room.setCapacity(resultSet.getInt("Capacity"));
                room.setImg(resultSet.getString("Img"));
                room.setStatus(resultSet.getInt("Status"));
                room.setBID(resultSet.getInt("BID"));
                room.setName(resultSet.getString("RoomName"));
                room.setPrice(resultSet.getDouble("Price"));
                roomList.add(room);
            }

        } catch (SQLException e) {
            System.out.println("getRandomRooms: " + e.getMessage());
        }

        return roomList;
    }
}
