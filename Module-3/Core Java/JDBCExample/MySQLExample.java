package JDBCExample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLExample {
    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Connect to the database
            String url = "jdbc:mysql://localhost:3306/schooldb"; // database URL
            String user = "root"; // your MySQL username
            String password = "1234"; // your MySQL password
            Connection conn = DriverManager.getConnection(url, user, password);

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute SELECT query
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            // Step 5: Print the result
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Grade: " + rs.getInt("grade"));
                System.out.println("---------------");
            }

            // Step 6: Close connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
