package Classes;

public abstract class Room {
    private int roomId; //From DB
    private int roomNum;
    private int capacity ;
    private boolean isAvailable;
    private int pricePerNight;
    private String roomDescription;

    public Room() {
    }
    public Room(int roomId) {
        this.roomId = roomId;
    }
    public Room(int roomId, int roomNum, int capacity, boolean isAvailable, int pricePerNight, String roomDescription)throws InvalidDataException  {
        setRoomId(roomId);
        setRoomNum(roomNum);
        setPricePerNight(pricePerNight);

        this.capacity = capacity ;
        this.isAvailable = isAvailable;
        this.roomDescription = roomDescription;
    }

    public int getRoomId() {
        return roomId;
    }
    public void setRoomId(int roomId) throws InvalidDataException {
        if (roomId <= 0) throw new InvalidDataException("Room ID must be positive.");
        this.roomId = roomId;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) throws InvalidDataException {
        if (roomNum <= 0) throw new InvalidDataException("Room number must be positive.");
        this.roomNum = roomNum;
    }

    public int getcapacity () {
        return capacity ;
    }

    public void setcapacity (int capacity ) {
        this.capacity = capacity ;
    }

    public boolean getStatus() { return isAvailable; }

    public void setStatus(boolean isAvailable) { this.isAvailable = isAvailable;}

    public int getPricePerNight() { return pricePerNight;}

    public void setPricePerNight(int pricePerNight) throws InvalidDataException {
        if (pricePerNight < 0) throw new InvalidDataException("Price cannot be negative.");
        this.pricePerNight = pricePerNight;
    }

    public String getRoomDescribtion() {return roomDescription;}

    public void setRoomdescription(String roomDescription) {this.roomDescription = roomDescription;}

    @Override
    public String toString() {
        return "Classes.Room{" +
                "roomId=" + roomId +
                ", roomNum=" + roomNum +
                ", capacity =" + capacity  +
                ", isAvailable=" + isAvailable +
                ", pricePerNight=" + pricePerNight +
                ", roomDescription='" + roomDescription + '\'' +
                '}';
    }
}
