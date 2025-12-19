package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private final String url =
            "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=HotelDB;" +
                    "encrypt=true;trustServerCertificate=true;" +
                    "integratedSecurity=true";
    private final String  user ="sa";
    private final String password ="Your Pass";
    private Connection getConnection() throws SQLException {
        return
                DriverManager.getConnection(url, user, password);
    }
    public List<Reservation> getAllRes()throws SQLException , InvalidDataException{
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation";
        try (Connection conn=getConnection();
             PreparedStatement stmt= conn.prepareStatement(sql);
             ResultSet rs= stmt.executeQuery()){

            while (rs.next()){
                int idFromDB = rs.getInt("roomId");
                Room room = new StandardRoom(idFromDB);

                Reservation reservation=new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getString("check_in_date"),
                        rs.getString("check_out_date"),
                        rs.getString("guest_status"),
                        room
                ) {};
                reservations.add(reservation);
            }

        }

        return reservations;
    }

    public void addReservation(Reservation reservation) throws SQLException{
        String sql="INSERT INTO Reservation " +
                "(reservation_id ,check_in_date,check_out_date,guest_status, roomId)"+ "VALUES" +
                "(?,?,?,?,?)";
        try(Connection conn=getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql) ){
            stmt.setInt(1, reservation.getReservationId());
            stmt.setString(2, reservation.getCheckInDate());
            stmt.setString(3, reservation.getCheckOutDate());
            stmt.setString(4, reservation.getStatus());
            stmt.setInt(5, reservation.getRoom().getRoomId());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }



    }
    public boolean isResExists(int reservationId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Reservation WHERE reservation_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, reservationId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}



