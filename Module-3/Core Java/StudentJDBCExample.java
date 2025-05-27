import java.sql.*;
public class StudentJDBCExample {
// Database connection method
public static Connection getConnection() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    return DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/college", "root", "your_password_here");
}

// Insert student
public static void insertStudent(int id, String name, int age) {
    String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
    try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3, age);
        int rows = ps.executeUpdate();
        System.out.println(rows + " student(s) inserted.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Update student
public static void updateStudent(int id, String newName, int newAge) {
    String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
    try (Connection con = getConnection(); 
    PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, newName);
        ps.setInt(2, newAge);
        ps.setInt(3, id);
        int rows = ps.executeUpdate();
        System.out.println(rows + " student(s) updated.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Main method to test insert and update
public static void main(String[] args) {
    insertStudent(1, "Alice", 20);
    updateStudent(1, "Alice Johnson", 21);
}
}
