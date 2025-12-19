package Classes;

public class Reservation
{
    private int reservationId;
    private int guestId;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private String status;
    public Reservation() {}
    public Reservation( int reservationId, String checkInDate, String checkOutDate, String status, Room room)
    {

        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.room = room;
    }
    public int getRoomId(){return room.getRoomId();}
    public int getReservationId() {
        return reservationId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
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

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
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



