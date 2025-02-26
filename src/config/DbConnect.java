package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnect {
    private Connection connect;

    public DbConnect() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/malacaste_db", "root", "");
            System.out.println("Connected to database successfully!");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database: " + ex.getMessage());
        }
    }

    
    public Connection getConnection() {
        return connect;
    }

    public int insertUser(String fname, String lname, String contactnum, String email,String UserType, String reguser, String regpass) {
        int result = 0; 
        String sql = "INSERT INTO users (Fname, Lname, Contactnum, email,usertype, Reguser, RegPass, status) VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try (PreparedStatement pst = connect.prepareStatement(sql)) {
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, contactnum);
            pst.setString(4, email);
            pst.setString(5, UserType);
            pst.setString(6, reguser);
            pst.setString(7, regpass);
            pst.setString(8, "Pending"); // Ensure "Pending" is stored correctly

            result = pst.executeUpdate();
            System.out.println("User inserted successfully with 'Pending' status!");
        } catch (SQLException ex) {
            System.out.println("Insert Error: " + ex.getMessage());
        }
        return result;
    }
    

}
