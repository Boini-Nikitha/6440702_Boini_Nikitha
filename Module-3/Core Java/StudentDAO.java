import java.sql.*;

public class StudentDAO {
    public static void insertStudent(int id, String name) throws Exception {
        Connection conn = getConnection();
        String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
        conn.close();
    }

    public static void updateStudent(int id, String name) throws Exception {
        Connection conn = getConnection();
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
        conn.close();
    }

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "password");
    }
}
