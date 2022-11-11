

package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;
public class ReservationService {
    public static Map<Customer, Reservation> customerReservationMap=new HashMap<>();
    public static List<IRoom> listOfRoom =new ArrayList<>();
    public static List<IRoom> roomList=new ArrayList<>();
    public static List<IRoom> recRooms=new ArrayList<>();

    public static void addRoom(IRoom room){
        listOfRoom.add(room);
    }
    public static IRoom getARoom(String roomId){
        if(listOfRoom.size()==0){
            System.out.println("Please first add room");
        }
       return listOfRoom.get(Integer.parseInt(roomId)-1);
    }
    public static Reservation reserveARoom(Customer customer,IRoom room,Date checkInDate,Date checkOutDate){
        Reservation res =new Reservation(customer,room,checkInDate,checkOutDate);
        customerReservationMap.put(customer,res);
        return res;
    }
    public static Collection<IRoom> findRooms(Date checkInDate,Date checkOutDate){
            roomList.addAll(listOfRoom);
        for(Reservation res:customerReservationMap.values()){
          //  System.out.println(res.room);
          // if room is already reserve we will remove from list which customer is getting
            if(res.checkInDate.compareTo(checkInDate) <= 0 && res.checkOutDate.compareTo(checkOutDate) >=0 ){
                roomList.remove(res.room);
            }
        }

        return roomList;
    }
    public  static Collection<Reservation> getCustomerReservation(Customer customer){
       return Collections.singleton(customerReservationMap.get(customer));
    }
    public static void printAllReservation(){
        Collection<Reservation> values = customerReservationMap.values();
        for(Reservation res:values){
            System.out.println(res);
        }

    }
}


