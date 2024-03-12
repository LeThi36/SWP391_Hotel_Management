package dao;

import DAL.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BedS;

public class BedDAO extends DBContext{
    public BedS getBedById(int bedId) {
        BedS bed = null;

        try {
            String query = "SELECT * FROM BedS WHERE BID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bedId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                bed = BedS.createFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            System.out.println("getBedById: " + e.getMessage());
        }

        return bed;
    }
}
