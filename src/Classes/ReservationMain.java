
import Classes.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ReservationMain {
    public static void main(String[] args) {
        ReservationDAO resDAO = new ReservationDAO();

        try {
            System.out.println("Existing Reservation: ");

            List<Reservation> reservations = resDAO.getAllRes();/*HERE*/
            System.out.println("Existing Reservations: ");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
            StandardRoom newRoom = new StandardRoom(10, 404, 2, true, 900, "Double Room");

            Reservation newReservation = new Reservation(505, "2-10-2025", "5-10-2025", "checked", newRoom );
            if (!resDAO.isResExists(newReservation.getReservationId())) {
                resDAO.addReservation(newReservation);
                System.out.println("Reservation added successfully");
            } else {
                System.out.println("Reservation ID " + newReservation.getReservationId() + " already exists! Skipping insertion.");
            }


            reservations = resDAO.getAllRes();
            System.out.println("Reservations After Attempting to Add New Reservation: ");
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
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