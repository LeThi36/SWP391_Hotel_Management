/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import DAL.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext {

    public int createUser(String role, String phonenumber, String password, String fullName, String email, String gender, String dob) {
        int userId = 0;

        String sql = "INSERT INTO Users (Role, Email, Password, FullName, Phone, Gender, DOB) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, role);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(5, phonenumber);
            preparedStatement.setString(6, gender.equals("Male") ? "1" : "0");

            // Parse DOB string to Date
            Date dobDate = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
            preparedStatement.setDate(7, new java.sql.Date(dobDate.getTime()));

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try ( ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        userId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException | ParseException e) {
            System.out.println("createUser: " + e.getMessage());
        }

        return userId;
    }

    public User readUserById(int userId) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE UserID = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToUser(resultSet);
                }
            }

        } catch (SQLException e) {
            System.out.println("readUserById: " + e.getMessage());
        }

        return user;
    }

    public List<User> readAllUsers() {
        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM Users";

        try ( Statement statement = connection.createStatement();  ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                User user = mapResultSetToUser(resultSet);
                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println("readAllUsers: " + e.getMessage());
        }

        return userList;
    }

    public void updateUser(User user) {
        String sql = "UPDATE Users SET Role = ?, Password = ?, FullName = ?, "
                + "Email = ?, Phone = ?, Gender = ?, DOB = ? WHERE UserID = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getRole());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());

            // Set gender as boolean
            preparedStatement.setBoolean(6, user.getGender().equals("Male"));

            // Parse DOB string to Date
            Date dobDate = new SimpleDateFormat("yyyy-MM-dd").parse(user.getDob());
            preparedStatement.setDate(7, new java.sql.Date(dobDate.getTime()));

            preparedStatement.setInt(8, user.getUserId());

            preparedStatement.executeUpdate();

        } catch (SQLException | ParseException e) {
            System.out.println("updateUser: " + e.getMessage());
        }
    }

    public void changePassword(String userId, String newPass) {
        String sql = "UPDATE Users SET Password = ? WHERE UserID = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newPass);
            preparedStatement.setString(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("updateUser: " + e.getMessage());
        }
    }

    public User readUserByUsername(String username) {
        User user = null;

        String sql = "SELECT * FROM Users WHERE Email = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToUser(resultSet);
                }
            }

        } catch (SQLException e) {
            System.out.println("readUserByUsername: " + e.getMessage());
        }
        return user;
    }

    public User readUserByUsernameAndPassword(String username, String password) {
        User user = null;

        String sql = "SELECT * FROM Users WHERE Email = ? AND Password = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = mapResultSetToUser(resultSet);
                }
            }

        } catch (SQLException e) {
            System.out.println("readUserByUsernameAndPassword: " + e.getMessage());
        }

        return user;
    }

    public boolean doesPhoneNumberExist(String phone) {
        boolean phoneNumberExists = false;

        String sql = "SELECT COUNT(*) AS count FROM Users WHERE Phone = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, phone);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    phoneNumberExists = count > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("doesPhoneNumberExist: " + e.getMessage());
        }

        return phoneNumberExists;
    }

    public boolean doesEmailExist(String email) {
        boolean emailExists = false;

        String sql = "SELECT COUNT(*) AS count FROM Users WHERE Email = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt("count");
                    emailExists = count > 0;
                }
            }

        } catch (SQLException e) {
            System.out.println("doesEmailExist: " + e.getMessage());
        }

        return emailExists;
    }

    public void updatePasswordByUsername(String email, String newPassword) {
        String sql = "UPDATE Users SET Password = ? WHERE Email = ?";

        try ( PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, email);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("updatePasswordByUsername: " + e.getMessage());
        }
    }

    // Helper method to map ResultSet to User object
    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("UserID"),
                resultSet.getInt("Role"),
                resultSet.getString("Password"),
                resultSet.getString("FullName"),
                resultSet.getString("Email"),
                resultSet.getString("Phone"),
                resultSet.getString("Gender"),
                resultSet.getString("DOB")
        );
    }

}
