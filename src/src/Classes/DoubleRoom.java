package Classes;

public class DoubleRoom extends Room{
    public DoubleRoom()throws InvalidDataException{
        super();
    }
    public DoubleRoom(int roomId, int roomNum, int pricePerNight)throws InvalidDataException {
        super(roomId, roomNum, 2, true, pricePerNight, "Double Room");
    }
}
