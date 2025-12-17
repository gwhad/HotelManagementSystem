package Classes;

public class Reservation
{
    private int reservationId;
    private int guestId;
    private Room room;
    private int checkInDate;
    private int checkOutDate;
    private String status;
    public Reservation() {}
    public Reservation(int guestId, int reservationId, int checkInDate, int checkOutDate, String status, Room room)
    {
        this.guestId = guestId;
        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.room = room;
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public void setCheckInDate(int checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(int checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation { " +
                "id=" + reservationId +
                ", guestId=" + guestId +
                ", checkIn=" + checkInDate +
                ", checkOut=" + checkOutDate +
                ", status='" + status + '\'' +
                " }";
    }

    //calculateTotal()
    //addRoom()
    //cancel()
    //checkIN()
    //checkOUT()

}



