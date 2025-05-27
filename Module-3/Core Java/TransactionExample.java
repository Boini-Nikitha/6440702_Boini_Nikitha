import java.sql.*;

public class TransactionExample {

// Get MySQL connection
public static Connection getConnection() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/college", "root", "your_password_here");
}

// Transfer money between accounts
public static void transferMoney(int fromId, int toId, double amount) {
    Connection conn = null;
    PreparedStatement debitStmt = null;
    PreparedStatement creditStmt = null;

    try {
        conn = getConnection();
        conn.setAutoCommit(false); // Begin transaction

        // Debit from source account
        debitStmt = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
        debitStmt.setDouble(1, amount);
        debitStmt.setInt(2, fromId);
        int debitResult = debitStmt.executeUpdate();

        // Credit to destination account
        creditStmt = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
        creditStmt.setDouble(1, amount);
        creditStmt.setInt(2, toId);
        int creditResult = creditStmt.executeUpdate();

        // If both updates succeed
        if (debitResult == 1 && creditResult == 1) {
            conn.commit();
            System.out.println("Transfer successful. ₹" + amount + " transferred.");
        } else {
            conn.rollback();
            System.out.println("Transfer failed. Rolled back.");
        }

    } catch (Exception e) {
        try {
            if (conn != null) conn.rollback();
        } catch (SQLException rollbackEx) {
            rollbackEx.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        try {
            if (debitStmt != null) debitStmt.close();
            if (creditStmt != null) creditStmt.close();
            if (conn != null) conn.close();
        } catch (SQLException closeEx) {
            closeEx.printStackTrace();
        }
    }
}

// Main method
public static void main(String[] args) {
    // Transfer ₹100 from account 1 to account 2
    transferMoney(1, 2, 100.0);
}
}
