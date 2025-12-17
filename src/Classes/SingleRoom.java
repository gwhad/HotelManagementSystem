package Classes;

public class SingleRoom extends Room{
    public SingleRoom()throws InvalidDataException{
        super();
    }
    public SingleRoom(int roomId, int roomNum, int pricePerNight)throws InvalidDataException {
        super(roomId, roomNum, 1, true, pricePerNight, "Single Room");
    }
}
