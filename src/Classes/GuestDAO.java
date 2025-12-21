
package Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDAO {

    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDB;encrypt=true;trustServerCertificate=true;integratedSecurity=true";

    public GuestDAO() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // استرجاع كل الجيست
    public List<Guest> getAllGuests() throws SQLException {
        List<Guest> guests = new ArrayList<>();
        String query = "SELECT guestId, firstName, lastName, email, phone, idNumber, address FROM Guest";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Guest g = new Guest(
                        rs.getInt("guestId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("idNumber"),
                        rs.getString("address")
                );
                guests.add(g);
            }
        }
        return guests;
    }

    // التحقق إذا كان الجيست موجود
    public boolean isGuestExist(int guestId) throws SQLException {
        String query = "SELECT COUNT(*) FROM Guest WHERE guestId=?";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, guestId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    // إضافة جيست جديد
    public void addGuest(Guest guest) throws SQLException {
        String query = "INSERT INTO Guest (guestId, firstName, lastName, email, phone, idNumber, address) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, guest.getGuestId());
            ps.setString(2, guest.getFirstName());
            ps.setString(3, guest.getLastName());
            ps.setString(4, guest.getEmail());
            ps.setString(5, guest.getPhone());
            ps.setInt(6, guest.getIdNumber());
            ps.setString(7, guest.getAddress());
            ps.executeUpdate();
        }
    }
}
