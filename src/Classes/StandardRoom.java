/*package Classes;



    public class StandardRoom extends Room {
        public StandardRoom(int roomId){
            super(roomId,0,0,false,0,"");
        }
        public StandardRoom(int roomId, int roomNum, int capacity, boolean isAvailable, int pricePerNight, String roomDescription) throws InvalidDataException {
           try {
               super(roomId, roomNum, capacity, isAvailable, pricePerNight, roomDescription);

           }
           catch (InvalidDataException e){
               e.printStackTrace();
           }
        }


    }
*/

package Classes;

public class StandardRoom extends Room {

    public StandardRoom(){

    }


    public StandardRoom(int roomId, int roomNum, int capacity, boolean isAvailable, int pricePerNight, String roomDescription) throws InvalidDataException {
        super(roomId, roomNum, capacity, isAvailable, pricePerNight, roomDescription);
    }
}