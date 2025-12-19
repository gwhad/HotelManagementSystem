package Classes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO {
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
    public List<Room> getAllRooms()throws SQLException , InvalidDataException{
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM Room";
        try (Connection conn=getConnection();
               PreparedStatement stmt= conn.prepareStatement(sql);
               ResultSet rs= stmt.executeQuery()){
            while (rs.next()){
                Room room=new Room(
                        rs.getInt("roomId"),
                        rs.getInt("roomNum"),
                        rs.getInt("capacity"),
                        rs.getBoolean("isAvailable"),
                        rs.getInt("pricePerNight"),
                        rs.getString("roomDescription")
                ) {};
                rooms.add(room);
            }

        } /*catch (SQLException | InvalidDataException e) {
            e.printStackTrace();
        }*/

        return rooms;
    }

    public void addRoom(Room room) throws SQLException{
        String sql="INSERT INTO Room " +
                "(roomId, roomNum, capacity,  isAvailable, pricePerNight,roomDescription) "+ "VALUES" +
                "(?,?,?,?,?,?)";
        try(Connection conn=getConnection();
            PreparedStatement stmt= conn.prepareStatement(sql) ){
            stmt.setInt(1, room.getRoomId());
            stmt.setInt(2, room.getRoomNum());
            stmt.setInt(3, room.getcapacity());
            stmt.setBoolean(4, room.getStatus());
            stmt.setInt(5, room.getPricePerNight());
            stmt.setString(6, room.getRoomDescribtion());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
           e.printStackTrace();
        }



        }
    public boolean isRoomExists(int roomId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM Room WHERE roomId = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, roomId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    }


