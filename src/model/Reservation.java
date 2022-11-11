package model;
import java.util.*;
public class Reservation {
    private Customer customer;
    public IRoom room;
    public Date checkInDate;
    public Date checkOutDate;
    public Reservation(Customer customer,IRoom room,Date checkInDate ,Date checkOutDate){
        this.customer=customer;
        this.room=room;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
    }
    public String toString(){
      return customer.toString()+" "+room.toString()+" date "+checkInDate+" to "+checkOutDate;
  }
}
