package Classes;



    public class StandardRoom extends Room {
        public StandardRoom(int roomId, int roomNum, int capacity, boolean isAvailable, int pricePerNight, String roomDescription) throws InvalidDataException {
            super(roomId, roomNum, capacity, isAvailable, pricePerNight, roomDescription);
        }
    }

