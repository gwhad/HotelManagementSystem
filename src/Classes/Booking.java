package Classes;

import java.time.LocalDate;

public class Booking {
    private int id;
    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking(int i, Guest guest1, Room suite, int i1, int i2) {}

    public Booking(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.guest = guest; this.room = room; this.checkIn = checkIn; this.checkOut = checkOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
    @Override
    public String toString() {
        return "Booking { " +
                "id=" + id +
                ", guest=" + (guest != null ? guest.getFirstName() + " " + guest.getLastName() : "null") +
                ", room=" + (room != null ? room.getRoomNum() : "null") +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                " }";
    }


}
