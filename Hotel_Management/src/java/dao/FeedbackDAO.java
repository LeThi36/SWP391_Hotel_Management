/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DAL.DBContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Feedback;

public class FeedbackDAO extends DBContext {

    // Create a new feedback
    public void createFeedback(Feedback feedback) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO feedback (userId, roomId, rating, content, createdDate) VALUES (?, ?, ?, ?, GETDATE())")) {
            preparedStatement.setInt(1, feedback.getUserId());
            preparedStatement.setInt(2, feedback.getRoomId());
            preparedStatement.setInt(3, feedback.getRating());
            preparedStatement.setString(4, feedback.getContent());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("createFeedback: " + e.getMessage());
        }
    }

    // Read all feedback
    public List<Feedback> getAllFeedback() {
        List<Feedback> feedbackList = new ArrayList<>();
        try ( Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback")) {
            while (resultSet.next()) {
                Feedback feedback = new Feedback(
                        resultSet.getInt("userId"),
                        resultSet.getInt("roomId"),
                        resultSet.getInt("rating"),
                        resultSet.getString("content"),
                        resultSet.getDate("createdDate")
                );
                feedbackList.add(feedback);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }

    // Update feedback
    public void updateFeedback(Feedback feedback) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE feedback SET rating = ?, content = ?, createdDate = ? WHERE userId = ? AND roomId = ?")) {
            preparedStatement.setInt(1, feedback.getRating());
            preparedStatement.setString(2, feedback.getContent());
            preparedStatement.setDate(3, new java.sql.Date(feedback.getCreatedDate().getTime()));
            preparedStatement.setInt(4, feedback.getUserId());
            preparedStatement.setInt(5, feedback.getRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete feedback
    public void deleteFeedback(int userId, int roomId) {
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM feedback WHERE userId = ? AND roomId = ?")) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roomId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get feedback by roomId and userId
    public Feedback getFeedbackByRoomAndUser(String roomId, int userId) {
        Feedback feedback = null;
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM feedback WHERE roomId = ? AND userId = ?")) {
            preparedStatement.setString(1, roomId);
            preparedStatement.setInt(2, userId);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    feedback = new Feedback(
                            resultSet.getInt("userId"),
                            resultSet.getInt("roomId"),
                            resultSet.getInt("rating"),
                            resultSet.getString("content"),
                            resultSet.getDate("createdDate")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("getFeedbackByRoomAndUser: " + e.getMessage());
        }
        return feedback;
    }

    // Get feedback by roomId and userId
    public List<Feedback> getFeedbackByRoom(String roomId) {
        List<Feedback> listFeedback = new ArrayList<>();
        try ( PreparedStatement preparedStatement = connection.prepareStatement(
                "select top 2 * from Feedback\n"
                + "where roomid = ?\n"
                + "order by rating")) {
            preparedStatement.setString(1, roomId);
            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Feedback feedback = new Feedback(
                            resultSet.getInt("userId"),
                            resultSet.getInt("roomId"),
                            resultSet.getInt("rating"),
                            resultSet.getString("content"),
                            resultSet.getDate("createdDate")
                    );
                    listFeedback.add(feedback);
                }
            }
        } catch (SQLException e) {
            System.out.println("getFeedbackByRoomAndUser: " + e.getMessage());
        }
        return listFeedback;
    }

}
