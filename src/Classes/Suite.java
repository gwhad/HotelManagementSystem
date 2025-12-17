package Classes;

public class Suite extends Room{
    public Suite()throws InvalidDataException{
        super();
    }
    public Suite(int roomId, int roomNum, int pricePerNight)throws InvalidDataException {
        super(roomId, roomNum, 6, true, pricePerNight, "Suite");
    }
}
