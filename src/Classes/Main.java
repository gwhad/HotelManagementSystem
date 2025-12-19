/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url =
                "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;" +
                        "databaseName=HotelDB;" +
                        "encrypt=true;trustServerCertificate=true;" +
                        "integratedSecurity=true";
        Connection conn = DriverManager.getConnection(url);


        System.out.println("Connected!");
    }
}


*/
import Classes.InvalidDataException;
import Classes.Room;
import Classes.RoomDAO;
import Classes.StandardRoom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAO();

        try {

            List<Room> rooms = roomDAO.getAllRooms();
            System.out.println("Existing Rooms: ");
            for (Room room : rooms) {
                System.out.println(room);
            }


            StandardRoom newRoom = new StandardRoom(20, 404, 2, true, 900, "Deluxe Room");
            if (!roomDAO.isRoomExists(newRoom.getRoomId())) {
                roomDAO.addRoom(newRoom);
                System.out.println("Room added successfully");
            } else {
                System.out.println("Room ID " + newRoom.getRoomId() + " already exists! Skipping insertion.");
            }


            rooms = roomDAO.getAllRooms();
            System.out.println("Rooms After Attempting to Add New Room: ");
            for (Room room : rooms) {
                System.out.println(room);
            }


            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;" +
                    "databaseName=HotelDB;" +
                    "encrypt=true;trustServerCertificate=true;" +
                    "integratedSecurity=true";

            try (Connection conn = DriverManager.getConnection(url)) {
                System.out.println("Connected.");
            }

        } catch (SQLException | ClassNotFoundException | InvalidDataException e) {
            e.printStackTrace();
        }
    }
}