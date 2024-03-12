/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DAL.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Rooms;

/**
 *
 * @author Admin
 */
public class RoomDAO extends DBContext {

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
                room.setName(resultSet.getString("RoomName"));
                room.setPrice(resultSet.getDouble("Price"));
                room.setDetail(resultSet.getString("Details"));
                roomList.add(room);
            }

        } catch (SQLException e) {
            System.out.println("getAllRooms: " + e.getMessage());
        }

        return roomList;
    }

    public List<Rooms> getRoomsForPage(int pageNumber, int roomsPerPage, String checkInDate, String checkOutDate, String Capacity) {
        List<Rooms> roomList = new ArrayList<>();

        try {
            int offset = (pageNumber - 1) * roomsPerPage;

            String query = "SELECT \n"
                    + "    r.[RID],\n"
                    + "    r.[RoomName],\n"
                    + "    r.[Size],\n"
                    + "    r.[Img],\n"
                    + "    r.[Status],\n"
                    + "    r.[BID],\n"
                    + "    r.[Details],\n"
                    + "    r.[Capacity],\n"
                    + "    r.[Price],\n"
                    + "    r.[TotalRoom] - COALESCE(i.NumberRooms, 0) AS AvailableRooms\n"
                    + "FROM \n"
                    + "    [SWP_Hotel_Booking].[dbo].[Rooms] r\n"
                    + "LEFT JOIN (\n"
                    + "    SELECT \n"
                    + "        [RoomID],\n"
                    + "        SUM([NumberRooms]) AS NumberRooms\n"
                    + "    FROM \n"
                    + "        [SWP_Hotel_Booking].[dbo].[INVOICES]\n"
                    + "    WHERE \n"
                    + "        ([CheckInDate] <= ? AND [CheckOutDate] >= ?)\n"
                    + "        AND [ReservationStatus] = 1\n"
                    + "    GROUP BY \n"
                    + "        [RoomID]\n"
                    + ") i ON r.[RID] = i.[RoomID]\n"
                    + "WHERE \n"
                    + "    r.[Capacity] >= ?\n"
                    + "ORDER BY RID "
                    + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, checkInDate);
            preparedStatement.setString(2, checkOutDate);
            preparedStatement.setString(3, Capacity);
            preparedStatement.setInt(4, offset);
            preparedStatement.setInt(5, roomsPerPage);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rooms room = new Rooms();
                room.setRID(resultSet.getInt("RID"));
                room.setTotalRoom(resultSet.getInt("AvailableRooms"));
                room.setSize(resultSet.getInt("Size"));
                room.setCapacity(resultSet.getInt("Capacity"));
                room.setImg(resultSet.getString("Img"));
                room.setStatus(resultSet.getInt("Status"));
                room.setBID(resultSet.getInt("BID"));
                room.setName(resultSet.getString("RoomName"));
                room.setPrice(resultSet.getDouble("Price"));
                room.setDetail(resultSet.getString("Details"));
                roomList.add(room);
            }

        } catch (SQLException e) {
            System.out.println("getRoomsForPageL: " + e.getMessage());
        }

        return roomList;
    }

    public int getTotalRoom(String checkInDate, String checkOutDate, String Capacity) {
        String query = "SELECT \n"
                + "    Count(*)\n"
                + "FROM \n"
                + "    [SWP_Hotel_Booking].[dbo].[Rooms] r\n"
                + "LEFT JOIN (\n"
                + "    SELECT \n"
                + "        [RoomID],\n"
                + "        SUM([NumberRooms]) AS NumberRooms\n"
                + "    FROM \n"
                + "        [SWP_Hotel_Booking].[dbo].[INVOICES]\n"
                + "    WHERE \n"
                + "        ([CheckInDate] < ? AND [CheckOutDate] > ?)\n"
                + "        AND [ReservationStatus] = 1\n"
                + "    GROUP BY \n"
                + "        [RoomID]\n"
                + ") i ON r.[RID] = i.[RoomID]\n"
                + "WHERE \n"
                + "    r.[Capacity] >= ?;";
        try {
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, checkInDate);
            preparedStatement.setString(2, checkOutDate);
            preparedStatement.setString(3, Capacity);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            
        } catch (Exception e) {
            System.out.println("getTotalRoom: " + e.getMessage());
        }
        return 0;
    }

    public List<Rooms> getRoomsForPage(int pageNumber, int roomsPerPage, int userId) {
        List<Rooms> roomList = new ArrayList<>();

        try {
            int offset = (pageNumber - 1) * roomsPerPage;

            String query = "Select * from Rooms\n"
                    + "  where Rid in (select distinct RoomID from INVOICES where userid = ?)  \n"
                    + " Order by RID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, offset);
            preparedStatement.setInt(3, roomsPerPage);

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
                room.setDetail(resultSet.getString("Details"));
                roomList.add(room);
            }

        } catch (SQLException e) {
            System.out.println("getRoomsForPageL: " + e.getMessage());
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
                room.setDetail(resultSet.getString("Details"));
                roomList.add(room);
            }

        } catch (SQLException e) {
            System.out.println("getRandomRooms: " + e.getMessage());
        }

        return roomList;
    }

    public int getNumberOfRooms(int userId) {
        int numberOfRooms = 0;

        try {
            String query = "select Count( distinct RoomID) as TotalRooms from INVOICES where USERid = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                numberOfRooms = resultSet.getInt("TotalRooms");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numberOfRooms;
    }

    public Rooms getRoomById(int roomId, String checkInDate, String checkOutDate, String Capacity) {
        Rooms room = null;

        try {
            String query = "SELECT \n"
                    + "    r.[RID],\n"
                    + "    r.[RoomName],\n"
                    + "    r.[Size],\n"
                    + "    r.[Img],\n"
                    + "    r.[Status],\n"
                    + "    r.[BID],\n"
                    + "    r.[Details],\n"
                    + "    r.[Capacity],\n"
                    + "    r.[Price],\n"
                    + "    r.[TotalRoom] - COALESCE(i.NumberRooms, 0) AS AvailableRooms\n"
                    + "FROM \n"
                    + "    [SWP_Hotel_Booking].[dbo].[Rooms] r\n"
                    + "LEFT JOIN (\n"
                    + "    SELECT \n"
                    + "        [RoomID],\n"
                    + "        SUM([NumberRooms]) AS NumberRooms\n"
                    + "    FROM \n"
                    + "        [SWP_Hotel_Booking].[dbo].[INVOICES]\n"
                    + "    WHERE \n"
                    + "        ([CheckInDate] < ? AND [CheckOutDate] > ?)\n"
                    + "        AND [ReservationStatus] = 1\n"
                    + "    GROUP BY \n"
                    + "        [RoomID]\n"
                    + ") i ON r.[RID] = i.[RoomID]\n"
                    + "WHERE \n"
                    + "    r.[Capacity] >= ? and  r.RID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, checkInDate);
            preparedStatement.setString(2, checkOutDate);
            preparedStatement.setString(3, Capacity);
            preparedStatement.setInt(4, roomId);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                room = new Rooms();
                room.setRID(resultSet.getInt("RID"));
                room.setTotalRoom(resultSet.getInt("AvailableRooms"));
                room.setSize(resultSet.getInt("Size"));
                room.setCapacity(resultSet.getInt("Capacity"));
                room.setImg(resultSet.getString("Img"));
                room.setStatus(resultSet.getInt("Status"));
                room.setBID(resultSet.getInt("BID"));
                room.setName(resultSet.getString("RoomName"));
                room.setPrice(resultSet.getDouble("Price"));
                room.setDetail(resultSet.getString("Details"));
            }

        } catch (SQLException e) {
            System.out.println("getRoomById: " + e.getMessage());
        }

        return room;
    }
    
    public Rooms getRoomById(int roomId) {
        Rooms room = null;

        try {
            String query = "SELECT * From [Rooms] WHERE RID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            

            preparedStatement.setInt(1, roomId);
            
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                room = new Rooms();
                room.setRID(resultSet.getInt("RID"));
                room.setTotalRoom(resultSet.getInt("totalRoom"));
                room.setSize(resultSet.getInt("Size"));
                room.setCapacity(resultSet.getInt("Capacity"));
                room.setImg(resultSet.getString("Img"));
                room.setStatus(resultSet.getInt("Status"));
                room.setBID(resultSet.getInt("BID"));
                room.setName(resultSet.getString("RoomName"));
                room.setPrice(resultSet.getDouble("Price"));
                room.setDetail(resultSet.getString("Details"));
            }

        } catch (SQLException e) {
            System.out.println("getRoomById: " + e.getMessage());
        }

        return room;
    }

    public int checkAvailable(int roomId, int required, String checkInDate, String checkOutDate) {
        Rooms room = null;

        try {
            String query = "SELECT \n"
                    + "    r.[RID],\n"
                    + "    r.[RoomName],\n"
                    + "    r.[Size],\n"
                    + "    r.[Capacity],\n"
                    + "    r.[Price],\n"
                    + "    r.[TotalRoom] - COALESCE(i.NumberRooms, 0) AS AvailableRooms\n"
                    + "FROM \n"
                    + "    [SWP_Hotel_Booking].[dbo].[Rooms] r\n"
                    + "LEFT JOIN (\n"
                    + "    SELECT \n"
                    + "        [RoomID],\n"
                    + "        SUM([NumberRooms]) AS NumberRooms\n"
                    + "    FROM \n"
                    + "        [SWP_Hotel_Booking].[dbo].[INVOICES]\n"
                    + "    WHERE \n"
                    + "        ([CheckInDate] < ? AND [CheckOutDate] > ?)\n"
                    + "        AND [ReservationStatus] = 1\n"
                    + "    GROUP BY \n"
                    + "        [RoomID]\n"
                    + ") i ON r.[RID] = i.[RoomID]\n"
                    + "WHERE \n"
                    + "    r.[Capacity] >= @capacity; and r.[RID] = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, checkInDate);
            preparedStatement.setString(2, checkOutDate);
            preparedStatement.setInt(3, roomId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int total = resultSet.getInt("AvailableRooms");
                return total;

            }

        } catch (SQLException e) {
            System.out.println("checkAvailable: " + e.getMessage());
        }

        return -1;
    }

    public boolean addRoom(Rooms room) {
        try {
            String query = "INSERT INTO Rooms (Size, Capacity, Img, Status, BID, RoomName, Price, Details) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, room.getSize());
            preparedStatement.setInt(2, room.getCapacity());
            preparedStatement.setString(3, room.getImg());
            preparedStatement.setInt(4, room.getStatus());
            preparedStatement.setInt(5, room.getBID());
            preparedStatement.setString(6, room.getName());
            preparedStatement.setDouble(7, room.getPrice());
            preparedStatement.setString(8, room.getDetail());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("addRoom: " + e.getMessage());
            return false;
        }
    }

    // Method to update an existing room
    public boolean updateRoom(Rooms room) {
        try {
            String query = "UPDATE Rooms SET Size=?, Capacity=?, Img=?, Status=?, BID=?, RoomName=?, Price=?, Details=? "
                    + "WHERE RID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, room.getSize());
            preparedStatement.setInt(2, room.getCapacity());
            preparedStatement.setString(3, room.getImg());
            preparedStatement.setInt(4, room.getStatus());
            preparedStatement.setInt(5, room.getBID());
            preparedStatement.setString(6, room.getName());
            preparedStatement.setDouble(7, room.getPrice());
            preparedStatement.setString(8, room.getDetail());
            preparedStatement.setInt(9, room.getRID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("updateRoom: " + e.getMessage());
            return false;
        }
    }

}
