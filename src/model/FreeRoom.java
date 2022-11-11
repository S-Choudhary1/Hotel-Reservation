package model;

public class FreeRoom extends Room{

     FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, price, enumeration);
    }
    final int setPrice(){
        return 0;
    }
    @Override
    public String toString(){
        return "freeRoom";
    }
}
