package Classes;

import java.sql.SQLException;
import java.util.List;

public class MainGuest {
    public static void main(String[] args) {
        GuestDAO guestDAO = new GuestDAO();

        try {

            System.out.println("Existing Guests:");
            List<Guest> guests = guestDAO.getAllGuests();
            for (Guest g : guests) {
                System.out.println(g);
            }


            Guest newGuest = new Guest(4, "Laila", "Samir", "laila.samir@example.com", "01011112222", 444444444, "Cairo, Egypt");
            if (!guestDAO.isGuestExist(newGuest.getGuestId())) {
                guestDAO.addGuest(newGuest);
                System.out.println("\nNew guest added successfully!");
            } else {
                System.out.println("\nGuest ID " + newGuest.getGuestId() + " already exists. Skipping insertion.");
            }


            System.out.println("\nGuests after insertion:");
            guests = guestDAO.getAllGuests();
            for (Guest g : guests) {
                System.out.println(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}