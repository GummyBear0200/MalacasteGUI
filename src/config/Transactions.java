
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Transactions {
    
    
    public void recordBorrowTransaction(int userId, int bookId) {
    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/malacaste_db",
            "root",
            ""
        );

        String sql = "INSERT INTO transactions (user_id, book_id, borrow_date) VALUES (?, ?, NOW())";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setInt(2, bookId);
        ps.executeUpdate();

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error logging borrow transaction: " + e.getMessage());
    }
}
public void recordReturnTransaction(int userId, int bookId) {
    try {
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/malacaste_db",
            "root",
            ""
        );

        String sql = "UPDATE transactions SET return_date = NOW() " +
                     "WHERE user_id = ? AND book_id = ? AND return_date IS NULL ORDER BY borrow_date DESC LIMIT 1";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, userId);
        ps.setInt(2, bookId);
        int rows = ps.executeUpdate();

        if (rows == 0) {
            JOptionPane.showMessageDialog(null, "No active borrow record found to return.");
        }

        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error logging return transaction: " + e.getMessage());
    }
}

}
