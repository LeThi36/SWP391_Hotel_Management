package dao;

import DAL.DBContext;
import model.Message;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO extends DBContext {

    public List<Message> getMessagesByConversationId(int conversationId) {
        List<Message> messages = new ArrayList<>();
        try {
            String query = "SELECT id, conversationId, message, created_by, created_at FROM Message WHERE conversationId = ? ORDER BY created_at";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, conversationId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Message message = new Message();
                message.setId(resultSet.getInt("id"));
                message.setConversationId(resultSet.getInt("conversationId"));
                message.setMessage(resultSet.getString("message"));
                message.setCreatedBy(resultSet.getInt("created_by"));
                message.setCreatedAt(resultSet.getTimestamp("created_at"));
                messages.add(message);
            }
        } catch (SQLException e) {
            System.out.println("getMessagesByConversationId: " + e.getMessage());
        }
        return messages;
    }

    public boolean addMessage(Message message) {
        try {
            String query = "INSERT INTO Message (conversationId, message, created_by) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, message.getConversationId());
            preparedStatement.setString(2, message.getMessage());
            preparedStatement.setInt(3, message.getCreatedBy());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("addMessage: " + e.getMessage());
            return false;
        }
    }
}
