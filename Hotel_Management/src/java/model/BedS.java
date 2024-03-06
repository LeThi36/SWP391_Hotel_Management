/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class BedS {
    private int BID;
    private String BedName;

    // Constructors, getters, setters, and other methods

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getBedName() {
        return BedName;
    }

    public void setBedName(String bedName) {
        BedName = bedName;
    }

    // New method to create a BedS object from a ResultSet
    public static BedS createFromResultSet(ResultSet resultSet) throws SQLException {
        BedS bed = new BedS();
        bed.setBID(resultSet.getInt("BID"));
        bed.setBedName(resultSet.getString("BedName"));
        return bed;
    }
}
